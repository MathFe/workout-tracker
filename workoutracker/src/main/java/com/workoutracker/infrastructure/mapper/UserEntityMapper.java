package com.workoutracker.infrastructure.mapper;

import com.workoutracker.core.entities.User;
import com.workoutracker.infrastructure.persistence.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserEntityMapper {

    public UserEntity toEntity(User user){
        return new UserEntity(
                user.id(),
                user.username(),
                user.password()
        );
    }
    public User toDomain(UserEntity userEntity){
        return new User(
                userEntity.getId(),
                userEntity.getUsername(),
                userEntity.getPassword()
        );
    }
}
