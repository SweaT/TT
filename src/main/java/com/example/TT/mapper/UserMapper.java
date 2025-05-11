package com.example.TT.mapper;

import com.example.TT.dto.UserDto;
import com.example.TT.persistent.model.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "role", expression = "java(dto.role() == null ? UserRole.USER : dto.role())")
    UserEntity fromDtoToEntity(UserDto dto);

    UserDto entityToDto(UserEntity entity);
}
