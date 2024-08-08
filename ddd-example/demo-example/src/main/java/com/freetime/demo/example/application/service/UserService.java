package com.freetime.demo.example.application.service;

import com.freetime.demo.example.application.command.CreateUserCommand;
import com.freetime.demo.example.application.dto.UserDTO;
import com.freetime.demo.example.interfaces.query.GetUserQuery;

public interface UserService {

    UserDTO getUser(GetUserQuery getUserQuery);

    void createUser(CreateUserCommand createUserCommand);
}
