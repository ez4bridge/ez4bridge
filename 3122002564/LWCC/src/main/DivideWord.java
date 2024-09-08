package main;

import com.hankcs.hanlp.HanLP;
import java.util.*;

public class DivideWord {
    // 使用 HanLP 进行中文分词
    public static List<String> tokenize(String text) {
        return HanLP.segment(text)
                .stream()
                .map(term -> term.word) // 获取词汇
                .toList();
    }
}
