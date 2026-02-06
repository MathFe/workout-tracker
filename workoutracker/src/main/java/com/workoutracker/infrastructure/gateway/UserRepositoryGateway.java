package com.workoutracker.infrastructure.gateway;

import com.workoutracker.core.entities.User;
import com.workoutracker.core.gateway.UserGateway;
import com.workoutracker.infrastructure.mapper.UserEntityMapper;
import com.workoutracker.infrastructure.persistence.UserEntity;
import com.workoutracker.infrastructure.persistence.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Transactional
@Component
public class UserRepositoryGateway  implements UserGateway {
    private final UserRepository userRepository;
    private final UserEntityMapper mapper;

    public UserRepositoryGateway(UserRepository userRepository, UserEntityMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public User createUser(User user) {
        UserEntity entity = mapper.toEntity(user);
        UserEntity newUser = userRepository.save(entity);
        return mapper.toDomain(newUser);
    }
}
