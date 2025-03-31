package com.example.TT.service;

import com.example.TT.dto.MatchDTO;
import com.example.TT.dto.PlayerDTO;
import com.example.TT.dto.SeasonDTO;
import com.example.TT.dto.TeamDTO;

public interface AdminService {

    MatchDTO createMatch(MatchDTO match);

    TeamDTO createTeam(TeamDTO team);

    PlayerDTO createPlayer(PlayerDTO player);

    SeasonDTO createSeason(SeasonDTO season);

}
