package com.example.TT.mapper;

import com.example.TT.dto.TeamDTO;
import com.example.TT.persistent.model.TeamEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeamMapper {

    TeamEntity fromDtoToEntity(TeamDTO dto);

    TeamDTO fromEntityToDto(TeamEntity entity);
}
