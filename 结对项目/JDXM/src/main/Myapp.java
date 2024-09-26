package main;

import java.util.*;

public class Myapp {
    public static void main(String[] args) {
        try {
            Map<String, String> command = cmdController.cmdControl(args);

            if (command.containsKey("-n") && command.containsKey("-r")) {
                // 生成题目
                int numberOfQuestions = Integer.parseInt(command.get("-n"));
                int range = Integer.parseInt(command.get("-r"));
                List<String> exercises = new ArrayList<>();
                List<String> answers = new ArrayList<>();

                createQuestion.create(numberOfQuestions, range, exercises, answers);
                fileUtil.writeToFile("Exercises.txt", exercises);
                fileUtil.writeToFile("Answers.txt", answers);
                System.out.println("题目和答案已给出");

            } else if (command.containsKey("-e") && command.containsKey("-a")) {
                // 校验答案
                String exerciseFile = command.get("-e");
                String answerFile = command.get("-a");
                List<String> exercises = fileUtil.readFromFile(exerciseFile);
                List<String> userAnswers = fileUtil.readFromFile(answerFile);
                List<String> correctAnswers = fileUtil.readFromFile("Answers.txt");
                AnswerChecker.checkAnswers(exercises, userAnswers, correctAnswers);
            } else {
                printHelp();
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            printHelp();
        }
    }

    private static void printHelp() {
        System.out.println("用法:");
        System.out.println("生成问题: java -jar MyApp.jar -n <题目数目> -r <范围>");
        System.out.println("检查答案: java -jar MyApp.jar -e <exercise_file> -a <answer_file>");
    }
}

