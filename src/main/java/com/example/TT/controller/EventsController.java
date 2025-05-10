package com.example.TT.controller;

import com.example.TT.dto.EventDTO;
import com.example.TT.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventsController {

    private final EventService eventService;

    @PostMapping("/get")
    public List<EventDTO> getUserNotifications(@RequestParam("login") String login) {
        return eventService.getAllUserEvents(login);
    }

    @PostMapping("create")
    @PreAuthorize("hasAuthority('ADMIN')")
    public EventDTO createEvent(@RequestBody EventDTO event) {
        return eventService.createEvent(event);
    }

    @PostMapping("subscribe")
    public boolean subscribe(@RequestParam("eventId") UUID eventId,
                             @RequestParam("login") String login) {
        return eventService.subscribe(eventId, login);
    }

}
