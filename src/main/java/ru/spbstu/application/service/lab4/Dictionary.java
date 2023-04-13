package ru.spbstu.application.service.lab4;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Dictionary {

    private final Map<String, String> wordsMap;

    public Dictionary(Map<String, String> wordsList) {
        this.wordsMap = new HashMap<>(wordsList);
    }

    public String translate(String str) {
        String resultStr = str.toLowerCase(Locale.ROOT);

        for(Map.Entry<String, String> entry : wordsMap.entrySet()) {
            resultStr =  resultStr.replaceAll(entry.getKey(), entry.getValue());
        }
        return resultStr;
    }

}
