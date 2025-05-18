package com.example.TT.controller;

import com.example.TT.dto.PlayerDTO;
import com.example.TT.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/team")
@RequiredArgsConstructor
public class TeamManagerController {

    private final UserService userService;

    @GetMapping("/players")
    public ResponseEntity<List<PlayerDTO>> getPlayerStatistic(@RequestParam("id") UUID id) {
        return ResponseEntity.ok(userService.getAllPlayersInTeam(id, Pageable.unpaged()));
    }

}
