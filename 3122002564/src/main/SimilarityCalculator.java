package main;

import java.util.*;

public class SimilarityCalculator {
    //计算单词出现次数
    private static Map<String, Integer> getWordFrequencyVector(List<String> tokens) {
        Map<String, Integer> wordFreq = new HashMap<>();
        for (String token : tokens) {
            wordFreq.put(token, wordFreq.getOrDefault(token, 0) + 1);
        }
        return wordFreq;
    }
    // 计算重复率
    public static double calculateSimilarity(List<String> originalTokens, List<String> plagiarizedTokens) {
        Map<String, Integer> vector1 = getWordFrequencyVector(originalTokens);
        Map<String, Integer> vector2 = getWordFrequencyVector(plagiarizedTokens);

        // 获取词汇的并集
        Set<String> allWords = new HashSet<>();
        allWords.addAll(vector1.keySet());
        allWords.addAll(vector2.keySet());

        // 计算点积
        double dotProduct = 0.0;
        for (String word : allWords) {
            int freq1 = vector1.getOrDefault(word, 0);
            int freq2 = vector2.getOrDefault(word, 0);
            dotProduct += freq1 * freq2;
        }

        // 计算两个向量的模
        double magnitude1 = 0.0;
        for (int freq : vector1.values()) {
            magnitude1 += freq * freq;
        }
        magnitude1 = Math.sqrt(magnitude1);

        double magnitude2 = 0.0;
        for (int freq : vector2.values()) {
            magnitude2 += freq * freq;
        }
        magnitude2 = Math.sqrt(magnitude2);

        // 防止除以零的情况
        if (magnitude1 == 0 || magnitude2 == 0) {
            return 0.0;
        }

        // 计算余弦相似度
        return dotProduct / (magnitude1 * magnitude2);
    }
}
