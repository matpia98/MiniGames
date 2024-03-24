package com.mydomain.minigames.lotek.util;

import java.util.List;
import java.util.stream.Collectors;

public class NumberUtils {
    public List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public int countMatches(List<Integer> userNumbers, List<Integer> drawnNumbers) {
        int hits = 0;
        for (Integer number : userNumbers) {
            if (drawnNumbers.contains(number)) {
                hits++;
            }
        }
        return hits;
    }
}
