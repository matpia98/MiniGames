package com.mydomain.minigames.lotek.util;

import java.util.List;
import java.util.stream.Collectors;

public class NumbersSorter {
    public List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
