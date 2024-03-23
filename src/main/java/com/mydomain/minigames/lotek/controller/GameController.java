package com.mydomain.minigames.lotek;

import java.util.List;
import java.util.Scanner;

public class GameController implements Game{

    private final InputProcessor inputProcessor;
    private final InputValidator inputValidator;
    private final NumberGenerator numberGenerator;
    private final ResultChecker resultChecker;
    private final Scanner scanner;

    public GameController(InputProcessor inputProcessor, InputValidator inputValidator, NumberGenerator numberGenerator, ResultChecker resultChecker) {
        this.inputProcessor = inputProcessor;
        this.inputValidator = inputValidator;
        this.numberGenerator = numberGenerator;
        this.resultChecker = resultChecker;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void startGame() {
        try {
            System.out.println(MessageProvider.WELCOME_MESSAGE);
            System.out.println(MessageProvider.ENTER_NUMBERS_PROMPT);
            String inputLine = scanner.nextLine();

            List<Integer> userNumbers = inputProcessor.convertToNumbers(inputLine);
            inputValidator.validateNumbers(userNumbers);

            List<Integer> drawnNumbers = numberGenerator.generateNumbers();
            System.out.printf((MessageProvider.DRAWN_NUMBERS) + "%n", drawnNumbers);

            int hits = resultChecker.checkResults(userNumbers, drawnNumbers);
            System.out.printf((MessageProvider.HIT_NUMBERS) + "%n", hits, userNumbers, drawnNumbers);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
