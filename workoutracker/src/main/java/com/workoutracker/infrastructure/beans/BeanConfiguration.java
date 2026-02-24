package com.workoutracker.infrastructure.beans;

import com.workoutracker.core.gateway.UserGateway;
import com.workoutracker.core.gateway.WorkoutPlanGateway;
import com.workoutracker.core.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public CreateUserCase createUserCase(UserGateway userGateway){
        return new CreateUserCaseImpl(userGateway);
    }

    @Bean
    public ListUserCase listUserCase(UserGateway userGateway){
        return new ListUserCaseImpl(userGateway);
    }

    @Bean
    public CreateWorkoutPlanCase createWorkoutPlanCase(WorkoutPlanGateway workoutPlanGateway){
        return new CreateWorkoutPlanCaseImpl(workoutPlanGateway);
    }
}
