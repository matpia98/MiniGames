package com.mydomain.minigames.lotek.util;

import java.util.*;

public class NumberGenerator {
    private final Random random;

    public NumberGenerator() {
        this.random = new Random();
    }

    public List<Integer> generateNumbers() {

        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < 6) {
            numbers.add(random.nextInt(1, 100));
        }
        return new ArrayList<>(numbers).stream()
                .sorted().toList();
    }
}
