package com.freetime.ddd.event.akka.sender;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.pattern.Patterns;
import akka.util.Timeout;
import com.freetime.ddd.event.akka.base.BaseEvent;
import scala.concurrent.Future;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BaseEventSender<T extends BaseEvent> {

    /**
     * 发送事件，无返回结果
     * @param event
     * @param actorClasses
     */
    public void send(T event, List<Class<? extends AbstractActor>> actorClasses) {
        ActorSystem actorSystem = event.getActorSystem();
        actorClasses.parallelStream()
                .map(actorClass -> actorSystem.actorOf(Props.create(actorClass)))
                .forEach(actorRef -> actorRef.tell(event, ActorRef.noSender()));
    }

    /**
     * 发送时间，带返回结果
     * @param event
     * @param actorClassesMap
     * @param timeout
     * @return
     */
    public Map<String, scala.concurrent.Future<Object>> send(T event, Map<String, Class<? extends AbstractActor>> actorClassesMap, Timeout timeout) {
        Map<String, scala.concurrent.Future<Object>> futureList = new HashMap<>(actorClassesMap.keySet().size());
        ActorSystem actorSystem = event.getActorSystem();

        Set<String> messageIds = actorClassesMap.keySet();
        for (String messageId : messageIds) {
            Class<? extends AbstractActor> actorClass = actorClassesMap.get(messageId);
            ActorRef actorRef = actorSystem.actorOf(Props.create(actorClass));
            Future<Object> future = Patterns.ask(actorRef, event, timeout);
            futureList.put(messageId, future);
        }
        return futureList;
    }
}
