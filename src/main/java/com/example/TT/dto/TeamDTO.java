package com.example.TT.dto;

import java.util.UUID;

public record TeamDTO(
        UUID id,
        String name,
        String country) {
}
