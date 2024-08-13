package com.freetime.spring.example.interfaces.api;

import com.freetime.spring.example.interfaces.query.TestQuery;
import com.freetime.spring.example.service.ExampleService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/api/example")
public class ExampleApi {

    final ExampleService exampleService;

    public ExampleApi(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @RequestMapping("/test")
    public String test(@Validated @RequestBody  TestQuery testQuery) {
        return exampleService.test(testQuery);
    }
}
