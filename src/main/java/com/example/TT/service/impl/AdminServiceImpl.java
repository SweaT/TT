package com.example.TT.service.impl;

import com.example.TT.dto.MatchDTO;
import com.example.TT.dto.PlayerDTO;
import com.example.TT.dto.SeasonDTO;
import com.example.TT.dto.TeamDTO;
import com.example.TT.mapper.SuperMapper;
import com.example.TT.persistent.model.MatchEntity;
import com.example.TT.persistent.model.PlayerEntity;
import com.example.TT.persistent.model.SeasonEntity;
import com.example.TT.persistent.model.TeamEntity;
import com.example.TT.persistent.repository.MatchRepository;
import com.example.TT.persistent.repository.PlayerRepository;
import com.example.TT.persistent.repository.SeasonRepository;
import com.example.TT.persistent.repository.TeamRepository;
import com.example.TT.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;
    private final MatchRepository matchRepository;
    private final SeasonRepository seasonRepository;
    private final SuperMapper mapper;

    @Override
    public MatchDTO createMatch(MatchDTO match) {
        MatchEntity matchDTO = matchRepository.save(mapper.getMatchMapper().fromDtoToEntity(match));
        return mapper.getMatchMapper().fromEntityToDto(matchDTO);
    }

    @Override
    public TeamDTO createTeam(TeamDTO team) {
        TeamEntity teamEntity = teamRepository.save(mapper.getTeamMapper().fromDtoToEntity(team));
        return mapper.getTeamMapper().fromEntityToDto(teamEntity);
    }

    @Override
    public PlayerDTO createPlayer(PlayerDTO player) {
        PlayerEntity playerEntity = playerRepository.save(mapper.getPlayerMapper().fromDtoToEntity(player));
        return mapper.getPlayerMapper().fromEntityToDto(playerEntity);
    }

    @Override
    public SeasonDTO createSeason(SeasonDTO season) {
        SeasonEntity seasonEntity = seasonRepository.save(mapper.getSeasonMapper().fromDtoToEntity(season));
        return mapper.getSeasonMapper().fromEntityToDto(seasonEntity);
    }
}
