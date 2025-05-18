package com.example.TT.controller.admin;

import com.example.TT.dto.response.DefaultRs;
import com.example.TT.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/admin/delete")
@PreAuthorize("hasAuthority('ADMIN')")
@RequiredArgsConstructor
public class AdminDeleteController {

    private final AdminService adminService;

    @PreAuthorize("hasAuthority('MANAGER')")
    @PostMapping("/match")
    public ResponseEntity<DefaultRs> deleteMatch(@RequestBody UUID[] matchUids) {
        DefaultRs response = adminService.deleteMatches(matchUids);
        return ResponseEntity.status(response.statusCode()).body(response);
    }

    @PostMapping("/player")
    public ResponseEntity<DefaultRs> DeletePlayer(@RequestBody UUID[] playerUids) {
        DefaultRs response = adminService.deletePlayers(playerUids);
        return ResponseEntity.status(response.statusCode()).body(response);
    }

    @PreAuthorize("hasAuthority('MANAGER')")
    @PostMapping("/season")
    public ResponseEntity<DefaultRs> DeleteSeason(@RequestBody Integer[] seasonsUids) {
        DefaultRs response = adminService.deleteSeasons(seasonsUids);
        return ResponseEntity.status(response.statusCode()).body(response);
    }

    @PostMapping("/team")
    public ResponseEntity<DefaultRs> DeleteTeam(@RequestBody UUID[] teamUids) {
        DefaultRs response = adminService.deleteTeams(teamUids);
        return ResponseEntity.status(response.statusCode()).body(response);
    }

}
