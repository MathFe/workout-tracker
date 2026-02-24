package com.workoutracker.core.usecases;

import com.workoutracker.core.entities.WorkoutPlan;

public interface CreateWorkoutPlanCase {

    public WorkoutPlan execute(WorkoutPlan workoutPlan);
}
