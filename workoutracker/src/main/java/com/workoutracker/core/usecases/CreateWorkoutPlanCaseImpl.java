package com.workoutracker.core.usecases;

import com.workoutracker.core.entities.WorkoutPlan;
import com.workoutracker.core.gateway.WorkoutPlanGateway;

public class CreateWorkoutPlanCaseImpl implements CreateWorkoutPlanCase{

    private final WorkoutPlanGateway workoutPlanGateway;

    public CreateWorkoutPlanCaseImpl(WorkoutPlanGateway workoutPlanGateway) {
        this.workoutPlanGateway = workoutPlanGateway;
    }

    @Override
    public WorkoutPlan execute(WorkoutPlan workoutPlan) {
        WorkoutPlan workoutPlan1 = new WorkoutPlan(
                workoutPlan.id(),
                workoutPlan.userId(),
                workoutPlan.name(),
                workoutPlan.createdAt()
        );

        return workoutPlanGateway.createWorkoutPlan(workoutPlan1);
    }
}
