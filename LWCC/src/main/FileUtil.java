package main;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;


public class FileUtil {

    private static void logError(String filePath, String errorMessage) {
        try (BufferedWriter errorWriter = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(filePath, true), StandardCharsets.UTF_8))) {
            errorWriter.write(errorMessage);
            errorWriter.newLine();
        } catch (IOException e) {
            // 处理记录错误信息时发生的异常
            System.err.println("写入错误信息时发生错误: " + e.getMessage());
        }
    }
    // 读文件
    public static String readFile(String filePath,String outputFilePath) throws FileException.InvalidFilePathException {
        if (filePath == null || filePath.trim().isEmpty()) {
            logError(outputFilePath, "读入路径无效: " + filePath);
            throw new FileException.InvalidFilePathException("读入路径无效");
        }
        try {
            return Files.readString(Path.of(filePath), StandardCharsets.UTF_8);
        } catch (NoSuchFileException e) {
            logError(outputFilePath, "文件不存在: " + filePath);
            throw new FileException.InvalidFilePathException("文件不存在: " + filePath);
        } catch (IOException e) {
            logError(outputFilePath, "读取文件时发生错误: " + e.getMessage());
            throw new FileException.InvalidFilePathException("读取文件时发生错误: " + e.getMessage());
        }
    }

    // 写文件
    public static void writeFile(String filePath, String content) throws FileException.InvalidFilePathException {
        if (filePath == null || filePath.trim().isEmpty()) {
            throw new FileException.InvalidFilePathException("写入路径无效");
        }
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(filePath, true), StandardCharsets.UTF_8))) { // true 表示追加模式
            writer.write(content);
            writer.newLine(); // 添加换行符
        } catch (IOException e) {
            throw new FileException.InvalidFilePathException("写入文件时发生错误: " + e.getMessage());
        }
    }
}
