package com.workoutracker.core.usecases;

import com.workoutracker.core.entities.User;
import com.workoutracker.core.gateway.UserGateway;

import java.util.List;

public class ListUserCaseImpl implements ListUserCase{
    private final UserGateway userGateway;

    public ListUserCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public List<User> execute() {
        return userGateway.listUsers();
    }
}
