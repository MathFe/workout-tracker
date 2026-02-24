package com.workoutracker.core.gateway;

import com.workoutracker.core.entities.WorkoutPlan;

public interface WorkoutPlanGateway {

    WorkoutPlan createWorkoutPlan(WorkoutPlan workoutPlan);
}
