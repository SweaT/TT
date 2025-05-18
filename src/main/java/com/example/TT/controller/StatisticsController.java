package com.example.TT.controller;

import com.example.TT.dto.response.statistics.PlayerStatisticsResponse;
import com.example.TT.dto.response.statistics.SeasonStatisticsResponse;
import com.example.TT.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/stat")
@RequiredArgsConstructor
public class StatisticsController {

    private final StatisticsService statisticsService;

    @GetMapping("/player")
    public ResponseEntity<PlayerStatisticsResponse> getPlayerStatistic(@RequestParam("id") UUID id) {
        return ResponseEntity.ok(statisticsService.getPlayerStatistics(id));
    }

    @GetMapping("/season")
    public ResponseEntity<SeasonStatisticsResponse> getSeasonStatistic(@RequestParam("id") Integer id) {
        return ResponseEntity.ok(statisticsService.getSeasonStatistics(id));
    }

    @GetMapping("/teamScore")
    public ResponseEntity<Integer> getTeamScore(@RequestParam("id") UUID TeamId) {
        return ResponseEntity.ok(statisticsService.getTeamScore(TeamId));
    }

}
