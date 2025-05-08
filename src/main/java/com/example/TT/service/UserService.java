package com.example.TT.service;

import com.example.TT.dto.TeamDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    List<TeamDTO> getAllTeams(Pageable pageable);


}
