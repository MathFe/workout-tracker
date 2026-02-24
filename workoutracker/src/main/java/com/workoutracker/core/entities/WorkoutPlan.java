package com.workoutracker.core.entities;

import java.time.LocalDateTime;

public record WorkoutPlan(
        Long id,
        Long userId,
        String name,
        LocalDateTime createdAt
) {}
