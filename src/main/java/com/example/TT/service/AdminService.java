package com.example.TT.service;

import com.example.TT.persistent.model.MatchEntity;
import com.example.TT.persistent.model.PlayerEntity;
import com.example.TT.persistent.model.TeamEntity;

public interface AdminService {

    MatchEntity createMatch(MatchEntity match);

    TeamEntity createTeam(TeamEntity team);

    PlayerEntity createPlayer(PlayerEntity player);

}
