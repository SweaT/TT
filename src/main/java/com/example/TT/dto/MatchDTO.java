package com.example.TT.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record MatchDTO(
        UUID id,
        SeasonDTO season,
        TeamDTO firstTeam,
        TeamDTO secondTeam,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime date,
        String score,
        Boolean firstTeamWon) {
}
