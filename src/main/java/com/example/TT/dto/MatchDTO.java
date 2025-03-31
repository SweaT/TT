package com.example.TT.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record MatchDTO(
        UUID id,
        SeasonDTO season,
        TeamDTO firstTeam,
        TeamDTO secondTeam,
        LocalDateTime date,
        String score,
        boolean firstTeamWon) {
}
