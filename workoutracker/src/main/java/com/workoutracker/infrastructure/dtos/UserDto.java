package com.workoutracker.infrastructure.dtos;

public record UserDto(
        Long id,
        String username,
        String password
) {
}
