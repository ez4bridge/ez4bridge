package main;

import java.util.List;
import java.util.Random;

public class createQuestion {
    /*
     * 生成问题并将问题和答案添加到对应的列表中
     */
    public static void create(int number, int range, List<String> exercises, List<String> answers) {
        Random rand = new Random();
        for (int i = 0; i < number; i++) {
            int a = rand.nextInt(range);
            int b = rand.nextInt(range);
            char operator = createOperator();
            String question = a + " " + operator + " " + b + " = ";
            String answer = calculateAnswer(a, b, operator);

            exercises.add(question);
            answers.add(answer);
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
     * 根据操作符计算答案
     */
    private static String calculateAnswer(int a, int b, char operator) {
        switch (operator) {
            case '+':
                return String.valueOf(a + b);
            case '-':
                return String.valueOf(a - b);
            case '*':
                return String.valueOf(a * b);
            case '/':
                if (b != 0) {
                    return String.valueOf((double) a / b);
                } else {
                    return "undefined"; // 避免除以零的情况
                }
            default:
                return "";
        }
    }
}
