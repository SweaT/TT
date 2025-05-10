package com.example.TT.service;

import com.example.TT.dto.EventDTO;

import java.util.List;
import java.util.UUID;

public interface EventService {

    List<EventDTO> getAllUserEvents(String login);

    EventDTO createEvent(EventDTO eventDTO);

    boolean subscribe(UUID eventId, String login);

}
