package com.mydomain.minigames.lotek.model;

import java.util.List;

public class ResultChecker {
    public int countMatches(List<Integer> userNumbers, List<Integer> drawnNumbers) {
        int hits = 0;
        for (Integer number : userNumbers) {
            if (drawnNumbers.contains(number)) {
                hits++;
            }
        }
        return hits;
    }
}
