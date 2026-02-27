package com.workoutracker.infrastructure.dtos;

import java.util.List;

public record UserWithWorkoutsRersponseDto(
        Long id,
        String username,
        List<WorkoutPlanResponseDto> workoutPlanResponseDtos
) {
}
