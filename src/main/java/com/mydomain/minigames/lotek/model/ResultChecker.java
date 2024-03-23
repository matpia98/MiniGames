package com.mydomain.minigames.lotek;

import java.util.List;

public class ResultChecker {
    public int checkResults(List<Integer> userNumbers, List<Integer> drawnNumbers) {
        int hits = 0;
        for (Integer number : userNumbers) {
            if (drawnNumbers.contains(number)) {
                hits++;
            }
        }
        return hits;
    }
}
