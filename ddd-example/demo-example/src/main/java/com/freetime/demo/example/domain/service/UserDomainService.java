package com.freetime.demo.example.domain.service;

import com.freetime.demo.example.domain.entity.user.User;

public interface UserDomainService {

    User getUser(Long userId);

    void createUser(User user);

    void login(Long userId);
}
