package com.freetime.spring.example.service;

import com.freetime.spring.example.interfaces.query.TestQuery;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {

    public String test(TestQuery testQuery) {
        return testQuery.getTestString();
    }
}
