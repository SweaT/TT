package com.example.TT.mapper;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Getter
@Component
@RequiredArgsConstructor
public class SuperMapper {
    private final MatchMapper matchMapper;
    private final TeamMapper teamMapper;
    private final SeasonMapper seasonMapper;
    private final PlayerMapper playerMapper;
}
