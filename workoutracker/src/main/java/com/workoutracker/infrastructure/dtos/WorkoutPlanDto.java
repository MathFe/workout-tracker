package com.workoutracker.infrastructure.dtos;

import java.time.LocalDateTime;

public record WorkoutPlanDto(
        Long id,
        Long userId,
        String name,
        LocalDateTime createdAt

) {
}
