package com.freetime.event.example.config;

import akka.actor.ActorSystem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public ActorSystem getActorSystem() {
        return ActorSystem.create("freetime");
    }
}
