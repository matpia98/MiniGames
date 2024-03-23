package com.mydomain.minigames.lotek.util;

import com.mydomain.minigames.lotek.exception.NotANumberException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputProcessorTest {

    @Test
    public void shouldCorrectlyConvertStringToNumbers() {
        // given
        InputProcessor inputProcessor = new InputProcessor();
        String text = "1 5 2 18 20 25";

        // when
        List<Integer> numbers = inputProcessor.convertToNumbers(text);

        // then
        assertEquals(List.of(1,5,2,18,20,25), numbers);
    }

    @Test
    public void shouldCorrectlyThrowExceptionWhenUserGaveText() {
        // given
        InputProcessor inputProcessor = new InputProcessor();
        String text = "1 5 x 18 20 25";

        // when, then
        assertThrows(NotANumberException.class, () -> inputProcessor.convertToNumbers(text),
                "A NotANumberException should be thrown when the input contains non-numeric text");
    }

    @Test
    public void shouldCorrectlyConvertStringToNumbersWithMoreSpacesBetweenNumbers() {
        // given
        InputProcessor inputProcessor = new InputProcessor();
        String text = "1 5 2   18    20 25";

        // when
        List<Integer> numbers = inputProcessor.convertToNumbers(text);

        // then
        assertEquals(List.of(1,5,2,18,20,25), numbers);
    }

}