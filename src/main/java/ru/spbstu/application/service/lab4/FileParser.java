package ru.spbstu.application.service.lab4;

import ru.spbstu.application.service.lab4.exception.InvalidFileFormatException;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class FileParser {

    public Map<String, String> parse(BufferedReader reader) throws InvalidFileFormatException {
        try {
            Map<String, String> wordsMap = new HashMap<>();

            String line = reader.readLine();
            while(line != null) {
                String[] split = line.split(" [|] ");
                wordsMap.put(split[0].toLowerCase(Locale.ROOT), split[1]);
                line = reader.readLine();
            }

            return wordsMap;

        } catch (Exception e) {
            throw new InvalidFileFormatException();
        }
    }

}
