package com.workoutracker.core.gateway;

import com.workoutracker.core.entities.User;
import java.util.List;

public interface UserGateway {

    User createUser(User user);
    List<User> listUsers();
}
