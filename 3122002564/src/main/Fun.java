package main;

import java.io.IOException;
import java.util.List;
/*
使用方式：
java -jar main.jar E:\java\LWCC\orig.txt E:\java\LWCC\orig_0.8_add.txt E:\java\LWCC\test.txt
java -jar main.jar E:\java\LWCC\orig.txt E:\java\LWCC\orig_0.8_del.txt E:\java\LWCC\test.txt
java -jar main.jar E:/java/LWCC/self_test1.txt E:/java/LWCC/self_test2.txt E:\java\LWCC\test.txt
 */
public class Fun {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("使用方法: java -jar main.jar <原文章路径> <待测文章路径> <输出路径>");
            return;
        }

        String originalFilePath = args[0];
        String copyFilePath = args[1];
        String outputFilePath = args[2];

        try {
            // 读取原文和抄袭版的内容
            String originalText = FileUtil.readFile(originalFilePath,outputFilePath);
            String copyText = FileUtil.readFile(copyFilePath,outputFilePath);

            // 进行分词
            List<String> originalTokens = DivideWord.tokenize(originalText);
            List<String> copyTokens = DivideWord.tokenize(copyText);

            // 计算重复率
            double similarityRate = SimilarityCalculator.calculateSimilarity(originalTokens, copyTokens) * 100;

            // 将结果输出到指定文件
            FileUtil.writeFile(outputFilePath, "\"" + copyFilePath + "\" 的重复率: " + String.format("%.2f", similarityRate) + "%");
            System.out.println("查重结果已输出到: " + outputFilePath);

        } catch (IOException e) {
            System.err.println("文件读取或写入错误: " + e.getMessage());
        }
    }
}
