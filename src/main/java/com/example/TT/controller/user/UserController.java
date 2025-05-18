package com.example.TT.controller.user;

import com.example.TT.dto.TeamDTO;
import com.example.TT.dto.response.TimeTableResponse;
import com.example.TT.service.PdfReportService;
import com.example.TT.service.UserService;
import com.itextpdf.text.DocumentException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final PdfReportService pdfReportService;

    @GetMapping("/teams")
    public ResponseEntity<List<TeamDTO>> getAllTeams(@RequestParam("page") int page,
                                                     @RequestParam("size") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(userService.getAllTeams(pageable));
    }

    @GetMapping(value = "/teams/report", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> getReport(@RequestParam("id") UUID teamId) throws DocumentException {
        return ResponseEntity.ok(pdfReportService.generateReportByEveryPlayerInTeam(teamId));
    }

    @GetMapping(value = "/table")
    public ResponseEntity<TimeTableResponse> getTimeTable(@RequestParam("id") int seasonId) {
        return ResponseEntity.ok(userService.getAllMatchesInSeason(seasonId, Pageable.unpaged()));
    }

}
