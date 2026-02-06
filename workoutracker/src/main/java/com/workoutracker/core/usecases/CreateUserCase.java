package com.workoutracker.core.usecases;

import com.workoutracker.core.entities.User;

public interface CreateUserCase {

    public User execute(User user);
}
