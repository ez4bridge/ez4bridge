package main;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class createQuestion {

    private static Set<String> generatedQuestions = new HashSet<>();

    /*
     * 生成问题并将问题和答案添加到对应的列表中
     */
    public static void create(int number, int range, List<String> exercises, List<String> answers) {

        Random rand = new Random();
        while (exercises.size() < number) {
            try{
                // 生成分子和分母，控制整数和分数的出现概率
                int[] fraction1 = generateNumberOrFraction(rand, range);
                int[] fraction2 = generateNumberOrFraction(rand, range);
                int[] fraction3 = generateNumberOrFraction(rand, range);

                // 获取分数或整数
                Fraction num1=new Fraction (fraction1[0],fraction1[1]);
                Fraction num2=new Fraction (fraction2[0],fraction2[1]);
                Fraction num3=new Fraction (fraction3[0],fraction3[1]);

                // 生成两个运算符
                char operator1 = createOperator();
                char operator2 = createOperator();

                // 随机决定是否添加括号
                boolean addBracket = rand.nextBoolean();
                boolean[] bracket1Ref = {false};
                boolean[] bracket2Ref = {false};

                // 生成题目
                String question = createBracket(addBracket, fraction1, fraction2, fraction3, operator1, operator2, bracket1Ref, bracket2Ref);
                if (!generatedQuestions.contains(question)) {
                    boolean bracket1 = bracket1Ref[0];
                    boolean bracket2 = bracket2Ref[0];
                    String answer = calculateAnswer(num1, num2, num3, operator1, operator2,bracket1, bracket2);
                    exercises.add(question);
                    answers.add(answer);
                    generatedQuestions.add(question);// 记录生成的题目
                }
            }catch (ArithmeticException e) {
                continue;
            }
        }
    }

    /*
     * 生成整数或分数，根据随机数控制出现概率
     */
    private static int[] generateNumberOrFraction(Random rand, int range) {
        // 50% 概率生成整数，50% 概率生成分数
        if (rand.nextBoolean()) {
            int numerator = rand.nextInt(range); // 生成整数
            return new int[]{numerator, 1};      // 分母为1，表示整数
        } else {
            int numerator = rand.nextInt(range);
            int denominator = rand.nextInt(range - 1) + 1; // 确保分母不为0
            return new int[]{numerator, denominator};
        }
    }

    /*
     * 随机生成运算符
     */
    private static char createOperator() {
        char[] operators = {'+', '-', '*', '/'};
        return operators[new Random().nextInt(operators.length)];
    }

    /*
     * 计算两个运算符的四则运算
     */
    public static String calculateAnswer(Fraction num1, Fraction num2, Fraction num3,
                                          char operator1, char operator2, boolean bracket1, boolean bracket2) {
        Fraction finalResult = new Fraction(1,1);

        if (bracket1) {
            // 先计算括号内的操作
            Fraction middleResult = applyOperator(num1, num2, operator1);
            finalResult = applyOperator(middleResult, num3, operator2);
        } else if (bracket2) {
            Fraction middleResult = applyOperator(num2, num3, operator2);
            finalResult = applyOperator(num1, middleResult, operator1);
        } else {
            // 正常顺序运算
            if((operator1 == '+' || operator1 == '-') && (operator2 == '*' || operator2 == '/')) {
                Fraction middleResult = applyOperator(num2, num3, operator2);
                finalResult = applyOperator(num1, middleResult, operator1);
            }
            else
            {
                Fraction middleResult = applyOperator(num1, num2, operator1);
                finalResult = applyOperator(middleResult, num3, operator2);
            }
        }

        return finalResult.toString();
    }

    /*
     * 根据操作符应用运算
     */
    private static Fraction applyOperator(Fraction a, Fraction b, char operator) {
        switch (operator) {
            case '+':
                return a.add(b);
            case '-':
                return a.subtract(b);
            case '*':
                return a.multiply(b);
            case '/':
                return a.divide(b);
            default:
                throw new IllegalArgumentException("无效操作");
        }
    }


    /*
     * 随机决定是否添加括号
     */
    private static String createBracket(boolean addParentheses, int[] fraction1, int[] fraction2,
                                        int[] fraction3, char operator1, char operator2, boolean[] bracket1, boolean[] bracket2) {
        String question;
        // 获取分数或整数
        double num1 = (double) fraction1[0] / fraction1[1];
        double num2 = (double) fraction2[0] / fraction2[1];
        double num3 = (double) fraction3[0] / fraction3[1];
        // 随机添加括号
        if (addParentheses && ((operator1 == '+' || operator1 == '-') && (operator2 == '*' || operator2 == '/'))
                || ((operator2 == '+' || operator2 == '-') && (operator1 == '*' || operator1 == '/')))
        {
            if(operator1 == '+' || operator1 == '-')
            {
                bracket1[0]=true;
                if(operator1 == '-' && num1<num2)swap(fraction1,fraction2);
                question = "(" + formatFraction(fraction1[0], fraction1[1]) + " " + operator1 + " " +
                        formatFraction(fraction2[0], fraction2[1]) + ") " + operator2 + " " +
                        formatFraction(fraction3[0], fraction3[1]) + " = ";
            }
            else
            {
                bracket2[0]=true;
                if(operator2 == '-' && num2<num3)swap(fraction2,fraction3);
                question =  formatFraction(fraction1[0], fraction1[1]) + " " + operator1 + " (" +
                        formatFraction(fraction2[0], fraction2[1]) + " " + operator2 + " " +
                        formatFraction(fraction3[0], fraction3[1]) + " )= ";
            }
        } else if (addParentheses) {
            bracket2[0]=true;
            if(operator2 == '-' && num2<num3)swap(fraction2,fraction3);
            question =  formatFraction(fraction1[0], fraction1[1]) + " " + operator1 + " (" +
                    formatFraction(fraction2[0], fraction2[1]) + " " + operator2 + " " +
                    formatFraction(fraction3[0], fraction3[1]) + " )= ";
        } else {
            question = formatFraction(fraction1[0], fraction1[1]) + " " + operator1 + " " +
                    formatFraction(fraction2[0], fraction2[1]) + " " + operator2 + " " +
                    formatFraction(fraction3[0], fraction3[1]) + " = ";
        }


        return question;
    }

    private static void swap(int[] a, int[] b) {
        int[] temp = a;
        a = b;
        b = temp;
    }

    /*
     * 格式化分数
     */
    private static String formatFraction(int numerator, int denominator) {
        if (denominator == 1 || numerator == 0) {
            return String.valueOf(numerator); // 如果分母为1或分子为0，直接返回分子
        } else {
            return numerator + "/" + denominator; // 否则返回分数
        }
    }

}
