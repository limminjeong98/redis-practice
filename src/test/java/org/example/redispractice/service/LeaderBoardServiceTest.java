package org.example.redispractice.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class LeaderBoardServiceTest {

    @Autowired
    private LeaderBoardService sut;

    @Test
    void leaderboardOperationsTest() {
        // Given
        String userId = "user2";
        double score = 100.0;

        // When
        sut.addScore(userId, score);
        List<String> topPlayers = sut.getTopPlayers(1);
        Long rank = sut.getUserRank(userId);

        // Then
        assertFalse(topPlayers.isEmpty());
        assertEquals(userId, topPlayers.get(0));
        assertEquals(0L, rank); // 첫 번째 순위 (0-based index)
    }

}