package com.mydomain.minigames.lotek.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import com.mydomain.minigames.lotek.model.NumberGenerator;
import com.mydomain.minigames.lotek.model.ResultChecker;
import com.mydomain.minigames.lotek.util.InputProcessor;
import com.mydomain.minigames.lotek.util.InputValidator;
import com.mydomain.minigames.lotek.util.NumbersSorter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

class LotekTest {

    @Mock
    private InputProcessor inputProcessor;
    @Mock
    private InputValidator inputValidator;
    @Mock
    private NumberGenerator numberGenerator;
    @Mock
    private ResultChecker resultChecker;
    @Mock
    private NumbersSorter numbersSorter;
    @Mock
    private Scanner scanner;

    private Lotek lotek;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        lotek = new Lotek(inputProcessor, inputValidator, numberGenerator, resultChecker, numbersSorter, scanner);
    }

    private static Stream<Arguments> provideNumbersAndMessages() {
        Arguments argument1 = Arguments.of(6,List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 6),
                "You hit 6 numbers. Your numbers: [1, 2, 3, 4, 5, 6], drawn numbers: [1, 2, 3, 4, 5, 6]");
        Arguments argument2 = Arguments.of(5,List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 7),
                "You hit 5 numbers. Your numbers: [1, 2, 3, 4, 5, 6], drawn numbers: [1, 2, 3, 4, 5, 7]");
        Arguments argument3 = Arguments.of(4,List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 7, 8),
                "You hit 4 numbers. Your numbers: [1, 2, 3, 4, 5, 6], drawn numbers: [1, 2, 3, 4, 7, 8]");
        Arguments argument4 = Arguments.of(3,List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 7, 8, 9),
                "You hit 3 numbers. Your numbers: [1, 2, 3, 4, 5, 6], drawn numbers: [1, 2, 3, 7, 8, 9]");
        Arguments argument5 = Arguments.of(2,List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 7, 8, 9, 10),
                "You hit 2 numbers. Your numbers: [1, 2, 3, 4, 5, 6], drawn numbers: [1, 2, 7, 8, 9, 10]");
        Arguments argument6 = Arguments.of(1,List.of(1, 2, 3, 4, 5, 6), List.of(1, 7, 8, 9, 10, 11),
                "You hit 1 numbers. Your numbers: [1, 2, 3, 4, 5, 6], drawn numbers: [1, 7, 8, 9, 10, 11]");
        Arguments argument7 = Arguments.of(0,List.of(1, 2, 3, 4, 5, 6), List.of(7, 8, 9, 10, 11, 12),
                "You hit 0 numbers. Your numbers: [1, 2, 3, 4, 5, 6], drawn numbers: [7, 8, 9, 10, 11, 12]");
        return Stream.of(argument1, argument2, argument3, argument4, argument5, argument6, argument7);
    }

    @ParameterizedTest
    @MethodSource("provideNumbersAndMessages")
    void shouldReturnCorrectMessageWhenUserHitSixNumbers(int hits, List<Integer> userNumbers, List<Integer> drawnNumbers, String expectedMessage) {
        String inputLine = "1 2 3 4 5 6";

        when(scanner.nextLine()).thenReturn(inputLine);
        when(inputProcessor.convertToNumbers(inputLine)).thenReturn(userNumbers);
        when(numbersSorter.sortNumbers(userNumbers)).thenReturn(userNumbers);
        when(numberGenerator.generateNumbers()).thenReturn(drawnNumbers);
        when(resultChecker.countMatches(userNumbers, drawnNumbers)).thenReturn(hits);

        // when
        String providedMessage = lotek.resultMessage(hits, userNumbers, drawnNumbers);

        // then
        assertThat(providedMessage)
                .isEqualTo(expectedMessage);

    }
}
