package com.workoutracker.infrastructure.mapper;

import com.workoutracker.core.entities.WorkoutPlan;
import com.workoutracker.infrastructure.dtos.WorkoutPlanDto;
import org.springframework.stereotype.Component;

@Component
public class WorkoutPlanDtoMapper {

    public WorkoutPlan toEntity(WorkoutPlanDto dto) {
        return new WorkoutPlan(
                dto.id(),
                dto.userId(),
                dto.name(),
                dto.createdAt()
        );
    }

    public WorkoutPlanDto toResponseDto(WorkoutPlan workoutplan) {
        return new WorkoutPlanDto(
                workoutplan.id(),
                workoutplan.userId(),
                workoutplan.name(),
                workoutplan.createdAt()
        );
    }
}