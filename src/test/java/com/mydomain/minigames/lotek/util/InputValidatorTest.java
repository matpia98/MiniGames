package com.mydomain.minigames.lotek.util;

import com.mydomain.minigames.lotek.view.MessageProvider;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {
    @Test
    public void shouldPassValidationWithCorrectInput() {
        // given
        List<Integer> inputNumbers = List.of(1, 2, 3, 4, 5, 6);
        InputValidator inputValidator = new InputValidator();

        // when
        boolean result = inputValidator.validateNumbers(inputNumbers);

        // then
        assertTrue(result, "Valid input should pass validation");
    }

    @Test
    public void shouldThrowExceptionWhenNotExactlySixNumbers() {
        // given
        List<Integer> inputNumbers = List.of(10, 28, 35);
        InputValidator inputValidator = new InputValidator();

        // when, then
        assertThatThrownBy(() -> inputValidator.validateNumbers(inputNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MessageProvider.EXACTLY_SIX_NUMBERS_REQUIRED);
    }

    @Test
    public void shouldThrowExceptionForNumbersOutOfRange() {
        // given
        List<Integer> inputNumbers = List.of(10, 28, 35, 50, 70, 100);
        InputValidator inputValidator = new InputValidator();

        // when, then
        assertThatThrownBy(() -> inputValidator.validateNumbers(inputNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MessageProvider.NUMBER_OUT_OF_RANGE);
    }

    @Test
    public void shouldThrowExceptionForNonUniqueNumbers() {
        // given
        List<Integer> inputNumbers = List.of(5, 10, 10, 20, 20, 30);
        InputValidator inputValidator = new InputValidator();

        // when, then
        assertThatThrownBy(() -> inputValidator.validateNumbers(inputNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MessageProvider.NOT_UNIQUE_NUMBERS);
    }

    @Test
    public void shouldThrowExceptionForNullOrEmptyInput() {
        // given
        List<Integer> inputNumbers = new ArrayList<>();
        InputValidator inputValidator = new InputValidator();

        // when, then
        assertThatThrownBy(() -> inputValidator.validateNumbers(inputNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MessageProvider.LIST_NULL_OR_EMPTY);
    }


}