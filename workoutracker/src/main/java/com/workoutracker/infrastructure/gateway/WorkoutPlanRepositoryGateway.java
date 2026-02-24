package com.workoutracker.infrastructure.gateway;

import com.workoutracker.core.entities.WorkoutPlan;
import com.workoutracker.core.gateway.WorkoutPlanGateway;
import com.workoutracker.infrastructure.mapper.WorkoutPlanEntityMapper;
import com.workoutracker.infrastructure.persistence.UserEntity;
import com.workoutracker.infrastructure.persistence.UserRepository;
import com.workoutracker.infrastructure.persistence.WorkoutPlanEntity;
import com.workoutracker.infrastructure.persistence.WorkoutPlanRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public class WorkoutPlanRepositoryGateway implements WorkoutPlanGateway {

    private final WorkoutPlanRepository workoutPlanRepository;
    private final UserRepository userRepository;
    private final WorkoutPlanEntityMapper mapper;

    public WorkoutPlanRepositoryGateway(
            WorkoutPlanRepository workoutPlanRepository,
            UserRepository userRepository,
            WorkoutPlanEntityMapper mapper
    ) {
        this.workoutPlanRepository = workoutPlanRepository;
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public WorkoutPlan createWorkoutPlan(WorkoutPlan workoutPlan) {
        UserEntity user = userRepository.findById(workoutPlan.userId())
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + workoutPlan.userId()));

        WorkoutPlanEntity entity = mapper.toEntity(workoutPlan, user);
        WorkoutPlanEntity saved = workoutPlanRepository.save(entity);
        return mapper.toDomain(saved);
    }
}