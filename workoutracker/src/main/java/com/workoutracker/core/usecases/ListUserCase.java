package com.workoutracker.core.usecases;

import com.workoutracker.core.entities.User;

import java.util.List;

public interface ListUserCase {
    List<User> execute();
}
