package com.example.TT.dto;

import java.util.UUID;

public record PlayerDTO(
        UUID id,
        String name,
        String country,
        TeamDTO team,
        Integer goals) {
}
