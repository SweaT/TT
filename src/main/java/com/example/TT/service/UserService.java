package com.example.TT.service;

import com.example.TT.dto.PlayerDTO;
import com.example.TT.dto.TeamDTO;
import com.example.TT.dto.response.TimeTableResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface UserService {

    List<TeamDTO> getAllTeams(Pageable pageable);

    List<PlayerDTO> getAllPlayersInTeam(UUID teamId, Pageable pageable);

    TimeTableResponse getAllMatchesInSeason(Integer seasonId, Pageable pageable);

}
