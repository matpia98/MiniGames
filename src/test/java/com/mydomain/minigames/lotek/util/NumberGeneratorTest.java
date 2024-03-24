package com.mydomain.minigames.lotek.util;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class NumberGeneratorTest {

    @Test
    public void shouldCorrectlyDrawNumbersAndSortThem() {
        // given
        NumberGenerator numberGenerator = new NumberGenerator();

        // when
        List<Integer> numbers = numberGenerator.generateNumbers();
        boolean isSorted = IntStream.range(0, numbers.size() - 1)
                .allMatch(i -> numbers.get(i) <= numbers.get(i + 1));

        // then
        assertTrue(isSorted, "Numbers should be sorted in ascending order");
    }

    @Test
    public void shouldCorrectlyDrawNumbersWithinExpectedRange() {
        // given
        NumberGenerator numberGenerator = new NumberGenerator();

        // when
        List<Integer> numbers = numberGenerator.generateNumbers();
        boolean allInRange = numbers.stream()
                .allMatch(number -> number >= 1 && number < 100);

        // then
        assertTrue(allInRange, "Numbers should be within range 1 to 99");
    }

}