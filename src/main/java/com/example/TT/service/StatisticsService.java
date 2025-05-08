package com.example.TT.service;

import com.example.TT.dto.response.statistics.PlayerStatisticsResponse;
import com.example.TT.dto.response.statistics.SeasonStatisticsResponse;

import java.util.UUID;

public interface StatisticsService {

    PlayerStatisticsResponse getPlayerStatistics(UUID id);

    SeasonStatisticsResponse getSeasonStatistics(Integer id);
}
