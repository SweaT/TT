package com.example.TT.mapper;

import com.example.TT.dto.EventDTO;
import com.example.TT.persistent.model.EventEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventMapper {

    EventEntity fromDtoToEntity(EventDTO eventDTO);

    EventDTO fromEntityToDto(EventEntity eventEntity);

}
