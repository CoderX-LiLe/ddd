package com.freetime.ddd.event.akka.base;

public interface BaseActor<T extends BaseEvent> {

    void perform(T event);
}
