package com.freetime.spring.example.controller;

import com.freetime.spring.example.service.ExampleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/example")
public class ExampleController {

    final ExampleService exampleService;

    public ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @RequestMapping("/test")
    public String test() {
        return exampleService.test();
    }
}
