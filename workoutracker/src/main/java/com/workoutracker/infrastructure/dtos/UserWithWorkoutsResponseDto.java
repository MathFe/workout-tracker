package com.workoutracker.infrastructure.dtos;

import java.util.List;

public record UserWithWorkoutsResponseDto(
        Long id,
        String username,
        List<WorkoutPlanResponseDto> workoutPlans
) {
}
