package com.workoutracker.infrastructure.dtos;

import java.time.LocalDateTime;

public record WorkoutPlanResponseDto(
        Long id,
        Long userId,
        String name,
        LocalDateTime createdAt
) {
}
