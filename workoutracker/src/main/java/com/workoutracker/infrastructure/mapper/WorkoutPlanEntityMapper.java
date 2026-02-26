package com.workoutracker.infrastructure.mapper;

import com.workoutracker.core.entities.WorkoutPlan;
import com.workoutracker.infrastructure.persistence.UserEntity;
import com.workoutracker.infrastructure.persistence.WorkoutPlanEntity;
import org.springframework.stereotype.Component;

@Component
public class WorkoutPlanEntityMapper {

    public WorkoutPlanEntity toEntity(WorkoutPlan domain, UserEntity user) {
        return new WorkoutPlanEntity(
                domain.id(),
                user,
                domain.name(),
                domain.createdAt()
        );
    }

    public WorkoutPlan toDomain(WorkoutPlanEntity entity) {
        return new WorkoutPlan(
                entity.getId(),
                entity.getUser().getId(),
                entity.getName(),
                entity.getCreatedAt()
        );
    }
}