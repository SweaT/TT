package com.example.TT.service.impl;

import com.example.TT.dto.TeamDTO;
import com.example.TT.exception.GlobalRecourseNotFound;
import com.example.TT.mapper.SuperMapper;
import com.example.TT.persistent.model.TeamEntity;
import com.example.TT.persistent.repository.TeamRepository;
import com.example.TT.persistent.repository.UserRepository;
import com.example.TT.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final SuperMapper mapper;
    private final UserRepository userRepository;
    private final TeamRepository teamRepository;

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

}
