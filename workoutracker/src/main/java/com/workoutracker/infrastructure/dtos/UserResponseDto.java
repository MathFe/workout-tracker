package com.workoutracker.infrastructure.dtos;

public record UserResponseDto(
        Long id,
        String username,
        String password
) {
}
