package com.freetime.event.example.service;

import org.springframework.stereotype.Service;

@Service
public class ReceiverService {

    public void receive(String name) {
        System.out.println("Received message: name=" + name);
    }
}
