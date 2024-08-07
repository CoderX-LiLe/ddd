package com.freetime.ddd.event.akka.base;

import akka.actor.ActorSystem;
import lombok.Getter;

import java.util.UUID;

@Getter
public abstract class BaseEvent {
    private final String transactionId;

    public abstract ActorSystem getActorSystem();

    public BaseEvent() {
        this.transactionId = UUID.randomUUID().toString();
    }

}
