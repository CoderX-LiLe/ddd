package com.freetime.demo.example.application.event;

import akka.actor.ActorSystem;
import com.freetime.ddd.event.akka.base.BaseEvent;
import com.freetime.ddd.spring.utils.BeanUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
public class LoginEvent extends BaseEvent implements Serializable {

    private Long userId;

    @Override
    public ActorSystem getActorSystem() {
        return BeanUtils.getBean(ActorSystem.class);
    }
}
