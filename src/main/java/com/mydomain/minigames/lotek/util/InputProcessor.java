package com.mydomain.minigames.lotek.util;

import com.mydomain.minigames.lotek.exception.NotANumberException;
import com.mydomain.minigames.lotek.view.MessageProvider;

import java.util.ArrayList;
import java.util.List;

public class InputProcessor {

    public List<Integer> convertToNumbers(String inputLine) throws IllegalArgumentException {
        String[] splitInput = inputLine.split("\\s+");

        List<Integer> numbers = new ArrayList<>();
        for (String stringNumber : splitInput) {
            try {
                int number = Integer.parseInt(stringNumber);
                numbers.add(number);
            } catch (NumberFormatException e) {
                throw new NotANumberException(MessageProvider.formatMessage(MessageProvider.INVALID_NUMBER_FORMAT, stringNumber));
            }
        }
        return numbers;
    }
}
