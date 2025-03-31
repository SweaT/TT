package com.example.TT.mapper;

import com.example.TT.dto.PlayerDTO;
import com.example.TT.persistent.model.PlayerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

    PlayerEntity fromDtoToEntity(PlayerDTO dto);

    PlayerDTO fromEntityToDto(PlayerEntity entity);
}
