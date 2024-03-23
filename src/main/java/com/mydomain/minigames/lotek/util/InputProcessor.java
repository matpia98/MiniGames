package com.mydomain.minigames.lotek;

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
                throw new IllegalArgumentException(MessageProvider.INVALID_INPUT_FORMAT);
            }
        }
        return numbers.stream().sorted().toList();
    }
}
