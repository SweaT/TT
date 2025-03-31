package com.example.TT.mapper;

import com.example.TT.dto.SeasonDTO;
import com.example.TT.persistent.model.SeasonEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SeasonMapper {

    SeasonEntity fromDtoToEntity(SeasonDTO dto);

    SeasonDTO fromEntityToDto(SeasonEntity entity);
}
