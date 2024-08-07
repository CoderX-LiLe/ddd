package com.freetime.event.example.service;

import com.freetime.ddd.event.akka.sender.BaseEventSender;
import com.freetime.event.example.eventactors.DemoActor;
import com.freetime.event.example.events.DemoEvent;
import org.assertj.core.util.Lists;
import org.springframework.stereotype.Service;


@Service
public class SenderService {

    public void send(String name) {
        BaseEventSender<DemoEvent> demoEventBaseEventSender = new BaseEventSender<>();
        DemoEvent demoEvent = new DemoEvent();
        demoEvent.setName(name);
        demoEventBaseEventSender.send(demoEvent, Lists.newArrayList(DemoActor.class));
    }
}
