package com.freetime.event.example.eventactors;

import akka.actor.AbstractActor;
import com.freetime.ddd.event.akka.base.BaseActor;
import com.freetime.ddd.spring.utils.BeanUtils;
import com.freetime.event.example.events.DemoEvent;
import com.freetime.event.example.service.ReceiverService;

public class DemoActor extends AbstractActor implements BaseActor<DemoEvent> {

    @Override
    public Receive createReceive() {
        return receiveBuilder().match(DemoEvent.class, this::perform).build();
    }

    @Override
    public void perform(DemoEvent event) {
        ReceiverService receiverService = BeanUtils.getBean(ReceiverService.class);
        receiverService.receive(event.getName());
    }
}
