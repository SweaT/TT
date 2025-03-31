package com.example.TT.controller;

import com.example.TT.dto.MatchDTO;
import com.example.TT.dto.PlayerDTO;
import com.example.TT.dto.SeasonDTO;
import com.example.TT.dto.TeamDTO;
import com.example.TT.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/match/create")
    public ResponseEntity<MatchDTO> createMatch(@RequestBody MatchDTO matchDTO) {
        MatchDTO result = adminService.createMatch(matchDTO);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/player/create")
    public ResponseEntity<PlayerDTO> createPlayer(@RequestBody PlayerDTO playerDTO) {
        PlayerDTO result = adminService.createPlayer(playerDTO);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/season/create")
    public ResponseEntity<SeasonDTO> createSeason(@RequestBody SeasonDTO seasonDTO) {
        SeasonDTO result = adminService.createSeason(seasonDTO);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/team/create")
    public ResponseEntity<TeamDTO> createTeam(@RequestBody TeamDTO teamDTO) {
        TeamDTO result = adminService.createTeam(teamDTO);
        return ResponseEntity.ok(result);
    }

}
