package com.mydomain.minigames.lotek;

import com.mydomain.minigames.lotek.controller.Lotek;
import com.mydomain.minigames.lotek.core.Game;
import com.mydomain.minigames.lotek.model.NumberGenerator;
import com.mydomain.minigames.lotek.model.ResultChecker;
import com.mydomain.minigames.lotek.util.InputProcessor;
import com.mydomain.minigames.lotek.util.InputValidator;
import com.mydomain.minigames.lotek.util.NumbersSorter;

import java.util.Scanner;

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
        NumbersSorter numbersSorter = new NumbersSorter();
        Scanner scanner = new Scanner(System.in);
        return new Lotek(inputProcessor, inputValidator, numberGenerator, resultChecker, numbersSorter, scanner);
    }
}