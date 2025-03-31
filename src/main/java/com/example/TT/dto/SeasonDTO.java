package com.example.TT.dto;

import java.time.LocalDate;

public record SeasonDTO(
        Integer id,
        String name,
        LocalDate seasonStarts,
        LocalDate seasonEnds) {
}
