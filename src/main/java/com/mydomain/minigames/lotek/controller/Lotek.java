package com.mydomain.minigames.lotek.controller;

import com.mydomain.minigames.lotek.core.Game;
import com.mydomain.minigames.lotek.model.NumberGenerator;
import com.mydomain.minigames.lotek.model.ResultChecker;
import com.mydomain.minigames.lotek.util.InputProcessor;
import com.mydomain.minigames.lotek.util.InputValidator;
import com.mydomain.minigames.lotek.util.NumbersSorter;
import com.mydomain.minigames.lotek.view.MessageProvider;
import lombok.AllArgsConstructor;


import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
public class Lotek implements Game {

    private final InputProcessor inputProcessor;
    private final InputValidator inputValidator;
    private final NumberGenerator numberGenerator;
    private final ResultChecker resultChecker;
    private final NumbersSorter numbersSorter;
    private final Scanner scanner;


    @Override
    public void startGame() {
        try {
            System.out.println(MessageProvider.WELCOME_MESSAGE);
            System.out.println(MessageProvider.ENTER_NUMBERS_PROMPT);
            String inputLine = scanner.nextLine();

            List<Integer> userNumbers = inputProcessor.convertToNumbers(inputLine);
            inputValidator.validateNumbers(userNumbers);
            userNumbers = numbersSorter.sortNumbers(userNumbers);

            List<Integer> drawnNumbers = numberGenerator.generateNumbers();
            System.out.println(MessageProvider.formatMessage(MessageProvider.DRAWN_NUMBERS, drawnNumbers));

            int hits = resultChecker.checkResults(userNumbers, drawnNumbers);
            System.out.println(resultMessage(hits, userNumbers, drawnNumbers));
            if (hits == 6) {
                System.out.println(MessageProvider.USER_WINS);
            }

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    String resultMessage(int hits, List<Integer> userNumbers, List<Integer> drawnNumbers) {
        return MessageProvider.formatMessage(MessageProvider.HIT_NUMBERS, hits, userNumbers, drawnNumbers);
    }
}
