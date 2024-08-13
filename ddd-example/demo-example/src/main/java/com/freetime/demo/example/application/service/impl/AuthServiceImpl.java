package com.freetime.demo.example.application.service.impl;

import com.freetime.ddd.event.akka.sender.BaseEventSender;
import com.freetime.demo.example.application.event.LoginEvent;
import com.freetime.demo.example.application.eventactor.LoginEventActor;
import com.freetime.demo.example.application.service.AuthService;
import org.assertj.core.util.Lists;
import org.springframework.stereotype.Service;


@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public void login(LoginEvent loginEvent) {
        BaseEventSender<LoginEvent> loginEventBaseEventSender = new BaseEventSender<>();
        loginEventBaseEventSender.send(loginEvent, Lists.newArrayList(LoginEventActor.class));
    }
}
