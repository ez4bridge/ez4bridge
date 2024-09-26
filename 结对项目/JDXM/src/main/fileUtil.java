package main;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class fileUtil {

    //写文件
    public static void writeToFile(String fileName, List<String> content) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        int lineNum = 1;
        for (String line : content) {
            writer.write(lineNum + ". " + line);
            writer.newLine();
            lineNum++;
        }
        writer.close();
    }

    //读文件
    public static List<String> readFromFile(String fileName) throws IOException {
        List<String> content = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            content.add(line);
        }
        reader.close();
        return content;
    }
}

