package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class AnswerChecker {

    public static void checkAnswers(List<String> exercises, List<String> userAnswers, List<String> correctAnswers) throws IOException {
        int correctCount = 0;
        int wrongCount = 0;
        List<Integer> correctIndices = new ArrayList<>();
        List<Integer> wrongIndices = new ArrayList<>();

        for (int i = 0; i < exercises.size(); i++) {
            if (userAnswers.get(i).equals(correctAnswers.get(i))) {
                correctCount++;
                correctIndices.add(i + 1);
            } else {
                wrongCount++;
                wrongIndices.add(i + 1);
            }
        }

        //写入
        BufferedWriter writer = new BufferedWriter(new FileWriter("Grade.txt"));
        writer.write("Correct: " + correctCount + " " + correctIndices.toString());
        writer.newLine();
        writer.write("Wrong: " + wrongCount + " " + wrongIndices.toString());
        writer.close();

        System.out.println("结果已输出到Grade.txt");
    }
}

