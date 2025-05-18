package com.example.TT.service.impl;

import com.example.TT.dto.PlayerDTO;
import com.example.TT.dto.TeamDTO;
import com.example.TT.dto.response.TimeTableResponse;
import com.example.TT.exception.GlobalRecourseNotFound;
import com.example.TT.mapper.SuperMapper;
import com.example.TT.persistent.model.TeamEntity;
import com.example.TT.persistent.repository.MatchRepository;
import com.example.TT.persistent.repository.PlayerRepository;
import com.example.TT.persistent.repository.TeamRepository;
import com.example.TT.persistent.repository.UserRepository;
import com.example.TT.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final SuperMapper mapper;
    private final UserRepository userRepository;
    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;
    private final MatchRepository matchRepository;

    @Override
    public List<TeamDTO> getAllTeams(Pageable pageable) {
        Page<TeamEntity> teamEntityPage = teamRepository.findAll(pageable);

        if (teamEntityPage.isEmpty()) {
            throw new GlobalRecourseNotFound("Teams not found");
        } else {
            return teamEntityPage
                    .map(each -> mapper.getTeamMapper().fromEntityToDto(each))
                    .toList();
        }
    }

    @Override
    public List<PlayerDTO> getAllPlayersInTeam(UUID teamId, Pageable pageable) {
        return playerRepository.findAllByTeamId(teamId).stream()
                .map(each -> mapper.getPlayerMapper().fromEntityToDto(each))
                .toList();
    }

    @Override
    public TimeTableResponse getAllMatchesInSeason(Integer seasonId, Pageable pageable) {
        TimeTableResponse result = new TimeTableResponse(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        matchRepository.findMatchEntitiesBySeasonId(seasonId).stream()
                .map(each -> mapper.getMatchMapper().fromEntityToDto(each))
                .forEach(each -> {
                    switch (each.date().compareTo(LocalDateTime.now())) {
                        case -1:
                            result.notPlayedMatches().add(each);
                            break;
                        case 0:
                            result.playingNowMatches().add(each);
                            break;
                        case 1:
                            result.playedMatches().add(each);
                            break;
                    }
                });
        return result;
    }

}
