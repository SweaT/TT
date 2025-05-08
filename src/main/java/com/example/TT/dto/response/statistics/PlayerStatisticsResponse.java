package com.example.TT.dto.response.statistics;

import com.example.TT.dto.MatchDTO;
import com.example.TT.dto.PlayerDTO;
import lombok.Builder;

import java.util.List;

@Builder
public record PlayerStatisticsResponse(PlayerDTO playerDTO, List<MatchDTO> playedMathces, Integer matchesWon) {
}
