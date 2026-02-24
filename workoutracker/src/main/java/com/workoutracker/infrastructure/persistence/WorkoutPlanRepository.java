package com.workoutracker.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutPlanRepository extends JpaRepository<WorkoutPlanEntity, Long> {
}
