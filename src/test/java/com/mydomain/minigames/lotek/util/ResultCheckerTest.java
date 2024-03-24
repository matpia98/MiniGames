package com.mydomain.minigames.lotek.util;

import com.mydomain.minigames.lotek.util.NumberUtils;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultCheckerTest {

    @Test
    public void shouldReturnCorrectNumberOfHits() {
        // given
        NumberUtils numberUtils = new NumberUtils();
        List<Integer> userNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> drawnNumbers = List.of(2, 4, 6, 8, 10, 12);

        // when
        int hits = numberUtils.countMatches(userNumbers, drawnNumbers);

        // then
        assertEquals(3, hits, "Should correctly calculate the number of hits.");
    }

    @Test
    public void shouldReturnZeroWhenNoHits() {
        // given
        NumberUtils numberUtils = new NumberUtils();
        List<Integer> userNumbers = List.of(1, 3, 5, 7, 9, 11);
        List<Integer> drawnNumbers = List.of(2, 4, 6, 8, 10, 12);

        // when
        int hits = numberUtils.countMatches(userNumbers, drawnNumbers);

        // then
        assertEquals(0, hits, "Should return zero when there are no hits.");
    }

    @Test
    public void shouldHandleAllHitsCorrectly() {
        // given
        NumberUtils numberUtils = new NumberUtils();
        List<Integer> userNumbers = List.of(2, 4, 6, 8, 10, 12);
        List<Integer> drawnNumbers = List.of(2, 4, 6, 8, 10, 12);

        // when
        int hits = numberUtils.countMatches(userNumbers, drawnNumbers);

        // then
        assertEquals(6, hits, "Should handle all hits correctly.");
    }

    @Test
    public void shouldHandleEmptyLists() {
        // given
        NumberUtils numberUtils = new NumberUtils();
        List<Integer> userNumbers = List.of();
        List<Integer> drawnNumbers = List.of();

        // when
        int hits = numberUtils.countMatches(userNumbers, drawnNumbers);

        // then
        assertEquals(0, hits, "Should return zero when both lists are empty.");
    }
}
