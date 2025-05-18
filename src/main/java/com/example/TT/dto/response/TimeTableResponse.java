package com.example.TT.dto.response;

import com.example.TT.dto.MatchDTO;

import java.util.List;

public record TimeTableResponse(List<MatchDTO> playedMatches,
                                List<MatchDTO> notPlayedMatches,
                                List<MatchDTO> playingNowMatches) {
}
