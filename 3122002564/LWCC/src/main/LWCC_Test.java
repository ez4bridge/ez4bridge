package main;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LWCC_Test {
    @Test
    public void sameTest() throws IOException {
        //输入
        String originalFilePath ="E:/java/LWCC/orig.txt";
        String copyFilePath ="E:/java/LWCC/orig.txt";
        String outputFilePath ="E:/java/LWCC/test.txt";
        String[] args = new String[3];
        args[0] = originalFilePath;
        args[1] = copyFilePath;
        args[2] = outputFilePath;
        Fun.main(args);
    }

    @Test
    public void addTest() throws IOException {
        //输入
        String originalFilePath ="E:/java/LWCC/orig.txt";
        String copyFilePath ="E:/java/LWCC/orig_0.8_add.txt";
        String outputFilePath ="E:/java/LWCC/test.txt";
        String[] args = new String[3];
        args[0] = originalFilePath;
        args[1] = copyFilePath;
        args[2] = outputFilePath;
        Fun.main(args);
    }

    @Test
    public void delTest() throws IOException {
        //输入
        String originalFilePath ="E:/java/LWCC/orig.txt";
        String copyFilePath ="E:/java/LWCC/orig_0.8_del.txt";
        String outputFilePath ="E:/java/LWCC/test.txt";
        String[] args = new String[3];
        args[0] = originalFilePath;
        args[1] = copyFilePath;
        args[2] = outputFilePath;
        Fun.main(args);
    }

    @Test
    public void dis_1Test() throws IOException {
        //输入
        String originalFilePath ="E:/java/LWCC/orig.txt";
        String copyFilePath ="E:/java/LWCC/orig_0.8_dis_1.txt";
        String outputFilePath ="E:/java/LWCC/test.txt";
        String[] args = new String[3];
        args[0] = originalFilePath;
        args[1] = copyFilePath;
        args[2] = outputFilePath;
        Fun.main(args);
    }

    @Test
    public void dis_10Test() throws IOException {
        //输入
        String originalFilePath ="E:/java/LWCC/orig.txt";
        String copyFilePath ="E:/java/LWCC/orig_0.8_dis_10.txt";
        String outputFilePath ="E:/java/LWCC/test.txt";
        String[] args = new String[3];
        args[0] = originalFilePath;
        args[1] = copyFilePath;
        args[2] = outputFilePath;
        Fun.main(args);
    }

    @Test
    public void dis_15Test() throws IOException {
        //输入
        String originalFilePath ="E:/java/LWCC/orig.txt";
        String copyFilePath ="E:/java/LWCC/orig_0.8_dis_15.txt";
        String outputFilePath ="E:/java/LWCC/test.txt";
        String[] args = new String[3];
        args[0] = originalFilePath;
        args[1] = copyFilePath;
        args[2] = outputFilePath;
        Fun.main(args);
    }

    @Test
    public void  nullTest() throws IOException {
        //输入
        String originalFilePath =" ";
        String copyFilePath =" ";
        String outputFilePath ="E:/java/LWCC/test.txt";
        String[] args = new String[3];
        args[0] = originalFilePath;
        args[1] = copyFilePath;
        args[2] = outputFilePath;
        Fun.main(args);
    }

    @Test
    public void  wrongTest() throws IOException {
        //输入
        String originalFilePath ="E:/java/LWCC/faker.txt";
        String copyFilePath ="E:/java/LWCC/faker.txt";
        String outputFilePath ="E:/java/LWCC/test.txt";
        String[] args = new String[3];
        args[0] = originalFilePath;
        args[1] = copyFilePath;
        args[2] = outputFilePath;
        Fun.main(args);
    }

    @Test
    public void  writeTest() throws IOException {
        //输入
        String originalFilePath ="E:/java/LWCC/orig.txt";
        String copyFilePath ="E:/java/LWCC/orig_0.8_dis_15.txt";
        String outputFilePath ="";
        String[] args = new String[3];
        args[0] = originalFilePath;
        args[1] = copyFilePath;
        args[2] = outputFilePath;
        Fun.main(args);
    }


//    @Test
//    public void selfTest() throws IOException {
//        //输入
//        String originalFilePath ="E:/java/LWCC/self_test1.txt";
//        String copyFilePath ="E:/java/LWCC/self_test2.txt";
//        String originalText = FileUtil.readFile(originalFilePath);
//        String copyText = FileUtil.readFile(copyFilePath);
//        List<String> originalTokens =DivideWord.tokenize(originalText);
//        List<String> copyTokens =DivideWord.tokenize(copyText);
//
//        double similarity = SimilarityCalculator.calculateSimilarity(originalTokens, copyTokens)*100;
//        System.out.printf("\"%s\" 的重复率: %.2f%%\n", copyFilePath, similarity);
//    }
}
