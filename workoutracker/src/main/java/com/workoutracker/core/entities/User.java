package com.workoutracker.core.entities;

public record User(
        Long id,
        String username,
        String password
) {}
