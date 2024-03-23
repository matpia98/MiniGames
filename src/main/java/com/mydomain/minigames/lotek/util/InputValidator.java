package com.mydomain.minigames.lotek.util;

import com.mydomain.minigames.lotek.view.MessageProvider;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    public boolean validateNumbers(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException(MessageProvider.LIST_NULL_OR_EMPTY);
        }
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(MessageProvider.EXACTLY_SIX_NUMBERS_REQUIRED);
        }
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (Integer number : numbers) {
            if (number < 1 || number > 99) {
                throw new IllegalArgumentException(MessageProvider.NUMBER_OUT_OF_RANGE);
            }
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException(MessageProvider.NOT_UNIQUE_NUMBERS);
            }
        }
        return true;
    }
}
