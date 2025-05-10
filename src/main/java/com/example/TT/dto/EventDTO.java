package com.example.TT.dto;

import com.example.TT.persistent.model.EventType;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record EventDTO(UUID uuid, EventType type, String description) {
}
