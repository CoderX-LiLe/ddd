package com.freetime.demo.example.interfaces.api;

import com.freetime.ddd.core.dto.Result;
import com.freetime.demo.example.application.command.CreateUserCommand;
import com.freetime.demo.example.application.service.UserService;
import com.freetime.demo.example.application.dto.UserDTO;
import com.freetime.demo.example.interfaces.query.GetUserQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserApi {

    final UserService userService;

    public UserApi(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/get")
    public UserDTO getUser(@RequestBody @Validated GetUserQuery getUserQuery) {
        return userService.getUser(getUserQuery);
    }

    @RequestMapping("/create")
    public void createUser(@RequestBody @Validated CreateUserCommand createUserCommand) {
        userService.createUser(createUserCommand);
    }
}
