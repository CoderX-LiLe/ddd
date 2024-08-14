package com.freetime.spring.example.interfaces.api;

import com.freetime.ddd.core.dto.Result;
import com.freetime.spring.example.interfaces.query.TestQuery;
import com.freetime.spring.example.service.ExampleService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/example")
public class ExampleApi {

    final ExampleService exampleService;

    public ExampleApi(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @RequestMapping("/test")
    public Result test(@RequestBody @Validated TestQuery testQuery) {
        exampleService.test(testQuery);
        return Result.success();
    }
}
