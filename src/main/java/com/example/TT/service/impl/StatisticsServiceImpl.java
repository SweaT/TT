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
import org.jetbrains.annotations.NotNull;
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

        List<MatchDTO> wonMathces = getGetWonMathces(PlayersTeamId, false);

        return PlayerStatisticsResponse.builder()
                .playerDTO(player)
                .matchesWon(wonMathces.size())
                .playedMathces(wonMathces)
                .build();
    }

    @Override
    public SeasonStatisticsResponse getSeasonStatistics(Integer id) {
        return new SeasonStatisticsResponse(matchRepository.findMatchEntitiesBySeasonId(id).size());
    }

    @Override
    public Integer getTeamScore(UUID teamId) {
        return getGetWonMathces(teamId, true).stream()
                .mapToInt(each -> each.firstTeamWon() == null ? 1 : 3)
                .sum();
    }

    @NotNull
    private List<MatchDTO> getGetWonMathces(UUID teamId, boolean withDraw) {
        List<MatchDTO> matches = matchRepository.findMatchEntitiesByFirstTeamOrSecondTeamEagerOnly(teamId)
                .stream().map(each -> mapper.getMatchMapper().fromEntityToDto(each)).toList();

        return matches.stream().filter(each -> {
            boolean draw = withDraw && each.firstTeamWon() == null;
            boolean firstTeam = each.firstTeam().id().equals(teamId) && Boolean.TRUE.equals(each.firstTeamWon());
            boolean secondTeam = each.secondTeam().id().equals(teamId) && Boolean.FALSE.equals(each.firstTeamWon());
            return firstTeam || secondTeam || draw;
        }).toList();
    }


}
