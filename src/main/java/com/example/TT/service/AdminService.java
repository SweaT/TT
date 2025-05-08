package com.example.TT.service;

import com.example.TT.dto.MatchDTO;
import com.example.TT.dto.PlayerDTO;
import com.example.TT.dto.SeasonDTO;
import com.example.TT.dto.TeamDTO;
import com.example.TT.dto.response.DefaultRs;

import java.util.UUID;

public interface AdminService {

    MatchDTO createMatch(MatchDTO match);

    DefaultRs deleteMatches(UUID[] matchId);

    TeamDTO createTeam(TeamDTO team);

    DefaultRs deleteTeams(UUID[] teamId);

    PlayerDTO createPlayer(PlayerDTO player);

    DefaultRs deletePlayers(UUID[] playerId);

    SeasonDTO createSeason(SeasonDTO season);

    DefaultRs deleteSeasons(Integer[] seasonId);



}
