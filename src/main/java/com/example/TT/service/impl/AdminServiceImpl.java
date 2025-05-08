package com.example.TT.service.impl;

import com.example.TT.dto.MatchDTO;
import com.example.TT.dto.PlayerDTO;
import com.example.TT.dto.SeasonDTO;
import com.example.TT.dto.TeamDTO;
import com.example.TT.dto.response.DefaultRs;
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
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminServiceImpl implements AdminService {

    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;
    private final MatchRepository matchRepository;
    private final SeasonRepository seasonRepository;
    private final SuperMapper mapper;

    // --- MATCH ---

    @Override
    public MatchDTO createMatch(MatchDTO match) {
        MatchEntity matchDTO = matchRepository.save(mapper.getMatchMapper().fromDtoToEntity(match));
        return mapper.getMatchMapper().fromEntityToDto(matchDTO);
    }

    @Override
    public DefaultRs deleteMatches(UUID[] matchId) {
        try {
            matchRepository.deleteAllById(Arrays.asList(matchId));
        } catch (Exception e) {
            log.error("Ошибка удаления из базы данных Матчей: {}", e.getMessage());
            return DefaultRs.getServerFail();
        }
        return DefaultRs.getSuccess();
    }

    // --- TEAM ---

    @Override
    public TeamDTO createTeam(TeamDTO team) {
        TeamEntity teamEntity = teamRepository.save(mapper.getTeamMapper().fromDtoToEntity(team));
        return mapper.getTeamMapper().fromEntityToDto(teamEntity);
    }

    @Override
    public DefaultRs deleteTeams(UUID[] teamId) {
        try {
            teamRepository.deleteAllById(Arrays.asList(teamId));
        } catch (Exception e) {
            log.error("Ошибка удаления из базы данных Команд: {}", e.getMessage());
            return DefaultRs.getServerFail();
        }
        return DefaultRs.getSuccess();
    }

    // --- PLAYER ---

    @Override
    public PlayerDTO createPlayer(PlayerDTO player) {
        PlayerEntity playerEntity = playerRepository.save(mapper.getPlayerMapper().fromDtoToEntity(player));
        return mapper.getPlayerMapper().fromEntityToDto(playerEntity);
    }

    @Override
    public DefaultRs deletePlayers(UUID[] playerId) {
        try {
            playerRepository.deleteAllById(Arrays.asList(playerId));
        } catch (Exception e) {
            log.error("Ошибка удаления из базы данных игрока: {}", e.getMessage());
            return DefaultRs.getServerFail();
        }
        return DefaultRs.getSuccess();
    }

    // --- SEASON ---

    @Override
    public SeasonDTO createSeason(SeasonDTO season) {
        SeasonEntity seasonEntity = seasonRepository.save(mapper.getSeasonMapper().fromDtoToEntity(season));
        return mapper.getSeasonMapper().fromEntityToDto(seasonEntity);
    }

    @Override
    public DefaultRs deleteSeasons(Integer[] SeasonId) {
        try {
            seasonRepository.deleteAllById(Arrays.asList(SeasonId));
        } catch (Exception e) {
            log.error("Ошибка удаления из базы данных сезона: {}", e.getMessage());
            return DefaultRs.getServerFail();
        }
        return DefaultRs.getSuccess();
    }

}
