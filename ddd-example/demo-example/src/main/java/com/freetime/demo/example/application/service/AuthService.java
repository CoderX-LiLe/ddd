package com.freetime.demo.example.application.service;

import com.freetime.demo.example.application.event.LoginEvent;

public interface AuthService {

    void login(LoginEvent loginEvent);
}
