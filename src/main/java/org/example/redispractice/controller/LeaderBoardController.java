package org.example.redispractice.controller;

import org.example.redispractice.service.LeaderBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaderboard")
public class LeaderBoardController {

    private final LeaderBoardService leaderBoardService;

    @Autowired
    public LeaderBoardController(LeaderBoardService leaderBoardService) {
        this.leaderBoardService = leaderBoardService;
    }

    @PostMapping("/scores")
    public ResponseEntity<Void> addScore(@RequestParam String userId, @RequestParam double score) {
        leaderBoardService.addScore(userId, score);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/top/{count}")
    public ResponseEntity<List<String>> getTopPlayers(@PathVariable int count) {
        return ResponseEntity.ok(leaderBoardService.getTopPlayers(count));
    }

    @GetMapping("/rank/{userId}")
    public ResponseEntity<Long> getUserRank(@PathVariable String userId) {
        Long rank = leaderBoardService.getUserRank(userId);
        return rank != null ? ResponseEntity.ok(rank) : ResponseEntity.notFound().build();
    }
}
