package com.workoutracker.infrastructure.beans;

import com.workoutracker.core.gateway.UserGateway;
import com.workoutracker.core.usecases.CreateUserCase;
import com.workoutracker.core.usecases.CreateUserCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public CreateUserCase createUserCase(UserGateway userGateway){
        return new CreateUserCaseImpl(userGateway);
    }
}
