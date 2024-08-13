package com.freetime.demo.example.interfaces.api;

import com.freetime.ddd.core.dto.Result;
import com.freetime.demo.example.application.query.LoginQuery;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthApi {

    @RequestMapping("/login")
    public Result login(@RequestBody @Valid LoginQuery loginQuery) {
        return Result.success();
    }
}
