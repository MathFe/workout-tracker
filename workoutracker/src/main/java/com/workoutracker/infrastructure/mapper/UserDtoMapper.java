package com.workoutracker.infrastructure.mapper;

import com.workoutracker.core.entities.User;
import com.workoutracker.infrastructure.dtos.UserDto;
import com.workoutracker.infrastructure.dtos.UserResponseDto;
import org.springframework.stereotype.Component;

@Component
public class UserDtoMapper {
    public User toEntity(UserDto user) {
        return new User(
                null,
                user.username(),
                user.password()
        );
    }
    public UserResponseDto toResponseDto(User user){
        return new UserResponseDto(
                user.id(),
                user.username(),
                user.password()
        );
    }
}
