package com.freetime.event.example.events;

import akka.actor.ActorSystem;
import com.freetime.ddd.event.akka.base.BaseEvent;
import com.freetime.ddd.spring.utils.BeanUtils;

public class DemoEvent extends BaseEvent {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public ActorSystem getActorSystem() {
        return BeanUtils.getBean(ActorSystem.class);
    }
}
