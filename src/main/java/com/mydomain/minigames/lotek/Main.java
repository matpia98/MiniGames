package com.mydomain.minigames.game;

public class Main {
    public static void main(String[] args) {
        Game game = createGame();
        game.startGame();
    }

    private static Game createGame() {
        InputProcessor inputProcessor = new InputProcessor();
        InputValidator inputValidator = new InputValidator();
        NumberGenerator numberGenerator = new NumberGenerator();
        ResultChecker resultChecker = new ResultChecker();
        return new GameController(inputProcessor, inputValidator, numberGenerator, resultChecker);
    }
}