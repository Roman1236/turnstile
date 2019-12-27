package com.example.turnstile.services;

import com.example.turnstile.models.User;

public interface UserService {
    User findByLogin(String login);

    void create(User user);
}
