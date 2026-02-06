package com.workoutracker.core.usecases;

import com.workoutracker.core.entities.User;
import com.workoutracker.core.gateway.UserGateway;

public class CreateUserCaseImpl implements CreateUserCase {

    private final UserGateway userGateway;

    public CreateUserCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public User execute(User user) {
        User user1 = new User(
                user.id(),
                user.username(),
                user.password()
        );

        return userGateway.createUser(user1);
    }
}
