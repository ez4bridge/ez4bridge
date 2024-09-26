package main;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static main.createQuestion.calculateAnswer;
import static org.junit.Assert.*;

public class JDXMTest {
    @Test
    public void testCreateQuestion() {
        List<String> exercises = new ArrayList<>();
        List<String> answers = new ArrayList<>();
        int numOfQuestions = 10;
        int range = 10;

        createQuestion.create(numOfQuestions, range, exercises, answers);

        assertEquals(numOfQuestions, exercises.size());
        assertEquals(numOfQuestions, answers.size());

        int lineNum = 1;
        for (String question : exercises) {
            System.out.println(lineNum + ". " + question);
            lineNum++;
        }
        System.out.println(" ");
        lineNum = 1;
        for (String question : answers) {
            System.out.println(lineNum + ". " +question);
            lineNum++;
        }
    }

    @Test
    public void testGoodAnswers() throws Exception {
        List<String> exercises = Arrays.asList("1 + 1 = ", "2 * 2 = ");
        List<String> userAnswers = Arrays.asList("2", "4");
        List<String> correctAnswers = Arrays.asList("2", "4");

        AnswerChecker.checkAnswers(exercises, userAnswers, correctAnswers);

        File file = new File("Grade.txt");
        assertTrue(file.exists());
    }

    @Test
    public void testWrongAnswers() throws Exception {
        List<String> exercises = Arrays.asList("1 + 1 = ", "2 * 2 = ");
        List<String> userAnswers = Arrays.asList("3", "5");
        List<String> correctAnswers = Arrays.asList("2", "4");

        AnswerChecker.checkAnswers(exercises, userAnswers, correctAnswers);

        File file = new File("Grade.txt");
        assertTrue(file.exists());
    }

    @Test
    public void testCalculateAnswerWithBracket1() {
        // 括号优先: (num1 op1 num2) op2 num3
        Fraction num1=new Fraction (1,7);
        Fraction num2=new Fraction (10,1);
        Fraction num3 =new Fraction (1,3);
        String result1 =calculateAnswer(num1, num2, num3, '+', '*', true, false);
        System.out.println(result1);
    }

    @Test
    public void testCalculateAnswerWithBracket2() {
        // 括号优先: num1 op1 (num2 op2 num3)
        Fraction num1=new Fraction (6,3);
        Fraction num2=new Fraction (8,1);
        Fraction num3 =new Fraction (8,1);
        String result1 =calculateAnswer(num1, num2, num3, '*', '-', false, true);
        System.out.println(result1);
    }

    @Test
    public void testCalculateAnswerWithNoBracket() {
        // 括号优先: num1 op1 num2 op2 num3
        Fraction num1=new Fraction (6,1);
        Fraction num2=new Fraction (4,1);
        Fraction num3 =new Fraction (3,5);
        String result1 =calculateAnswer(num1, num2, num3, '/', '/', false, false);
        System.out.println(result1);
    }

    @Test
    public void testMain(){
        String[] args = {"-n","10000","-r","10"};
        Myapp.main(args);
    }
}
