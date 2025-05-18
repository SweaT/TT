package com.example.TT.mapper;

import com.example.TT.dto.MatchDTO;
import com.example.TT.persistent.model.MatchEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface MatchMapper {

    MatchEntity fromDtoToEntity(MatchDTO dto);

    MatchDTO fromEntityToDto(MatchEntity entity);

    List<MatchDTO> fromEntityToDtoList(List<MatchEntity> entity);

    List<MatchEntity> fromDtoToEntityList(List<MatchEntity> entity);

}
