package com.example.TT.service.impl;

import com.example.TT.dto.MatchDTO;
import com.example.TT.dto.PlayerDTO;
import com.example.TT.dto.response.statistics.PlayerStatisticsResponse;
import com.example.TT.dto.response.statistics.SeasonStatisticsResponse;
import com.example.TT.mapper.SuperMapper;
import com.example.TT.persistent.repository.MatchRepository;
import com.example.TT.persistent.repository.PlayerRepository;
import com.example.TT.persistent.repository.SeasonRepository;
import com.example.TT.persistent.repository.TeamRepository;
import com.example.TT.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StatisticsServiceImpl implements StatisticsService {

    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;
    private final MatchRepository matchRepository;
    private final SeasonRepository seasonRepository;
    private final SuperMapper mapper;

    @Override
    public PlayerStatisticsResponse getPlayerStatistics(UUID id) {
        PlayerDTO player = mapper.getPlayerMapper().fromEntityToDto(
                playerRepository.findWithTeamById(id).orElseThrow(() ->
                        new UsernameNotFoundException("Нет такого пользака"))
        );
        UUID PlayersTeamId = player.team().id();

        List<MatchDTO> matches = matchRepository.findMatchEntitiesByFirstTeamOrSecondTeamEagerOnly(PlayersTeamId)
                .stream().map(each -> mapper.getMatchMapper().fromEntityToDto(each)).toList();

        List<MatchDTO> wonMatches = matches.stream().filter(each -> {
            boolean firstTeam = each.firstTeam().id().equals(PlayersTeamId) && each.firstTeamWon();
            boolean secondTeam = each.secondTeam().id().equals(PlayersTeamId) && !each.firstTeamWon();
            return firstTeam || secondTeam;
        }).toList();

        return PlayerStatisticsResponse.builder()
                .playerDTO(player)
                .matchesWon(wonMatches.size())
                .playedMathces(matches)
                .build();
    }

    @Override
    public SeasonStatisticsResponse getSeasonStatistics(Integer id) {
        return new SeasonStatisticsResponse(matchRepository.findMatchEntitiesBySeasonId(id).size());
    }

}
