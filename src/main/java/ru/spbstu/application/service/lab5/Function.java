package ru.spbstu.application.service.lab5;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Function {

    public static Double getAverageValue(List<Integer> list) {
        return list.stream()
                .mapToInt(el -> el)
                .average()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static List<String> toUpperCase(List<String> list) {
        return list.stream()
                .map(element -> "_new_".concat(element.toUpperCase()))
                .collect(Collectors.toList());
    }

    public static List<Integer> getLonelySquareList(List<Integer> list) {
        return list.stream()
                .distinct()
                .map(el -> el*el)
                .collect(Collectors.toList());
    }

    public static List<String> getSortedStrings(char c, Collection<String> collection) {
        return collection.stream()
                .filter(el -> el.charAt(0) == c)
                .sorted()
                .collect(Collectors.toList());
    }

    public static <T> T getLast(Collection<T> collection) {
        return collection.stream()
                .reduce((ac, el) -> ac = el)
                .orElseThrow(IllegalArgumentException::new);
    }

    public static int getEvenSum(List<Integer> array) {
        return array.stream().filter(element -> element % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static Map<Character, String> convertToMap(List<String> list) {
        return list.stream()
                .collect(Collectors.toMap(k -> k.charAt(0), k -> k.substring(1), (e1, e2) -> e1));
    }

}
