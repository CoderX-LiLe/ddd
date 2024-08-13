package com.freetime.demo.example.application.eventactor;

import akka.actor.AbstractActor;
import com.freetime.ddd.event.akka.base.BaseActor;
import com.freetime.ddd.spring.utils.BeanUtils;
import com.freetime.demo.example.application.event.LoginEvent;
import com.freetime.demo.example.domain.service.UserDomainService;

public class LoginEventActor extends AbstractActor implements BaseActor<LoginEvent> {

    @Override
    public Receive createReceive() {
        return receiveBuilder().match(LoginEvent.class, this::perform).build();
    }

    @Override
    public void perform(LoginEvent event) {
        UserDomainService userDomainService = BeanUtils.getBean(UserDomainService.class);
        userDomainService.login(event.getUserId());
        System.out.println("LoginEventActor: " + event.getUserId());
    }
}
