package com.example.TT.service.impl;

import com.example.TT.dto.EventDTO;
import com.example.TT.mapper.EventMapper;
import com.example.TT.persistent.model.EventEntity;
import com.example.TT.persistent.repository.EventRepository;
import com.example.TT.persistent.repository.SubscriberRepository;
import com.example.TT.service.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final SubscriberRepository subscriberRepository;
    private final EventMapper eventMapper;

    @Override
    public List<EventDTO> getAllUserEvents(String login) {
        List<EventEntity> result = eventRepository.findSubscribedEventsByLogin(login);
        return result.stream()
                .map(eventMapper::fromEntityToDto)
                .toList();
    }

    @Override
    public EventDTO createEvent(EventDTO eventDTO) {
        EventEntity result = eventRepository.save(eventMapper.fromDtoToEntity(eventDTO));
        return eventMapper.fromEntityToDto(result);
    }

    @Override
    @Transactional
    public boolean subscribe(UUID eventId, String login) {
        return subscriberRepository.subscribe(login, eventId) > 0;
    }

}
