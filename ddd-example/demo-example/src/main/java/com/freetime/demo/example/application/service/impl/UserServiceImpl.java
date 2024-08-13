package com.freetime.demo.example.application.service.impl;

import com.freetime.ddd.command.base.BaseService;
import com.freetime.ddd.command.invoker.CommandInvoker;
import com.freetime.demo.example.application.command.CreateUserCommand;
import com.freetime.demo.example.application.convertor.UserDTOConverter;
import com.freetime.demo.example.application.dto.UserDTO;
import com.freetime.demo.example.application.service.UserService;
import com.freetime.demo.example.domain.entity.user.User;
import com.freetime.demo.example.domain.service.UserDomainService;
import com.freetime.demo.example.application.query.GetUserQuery;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseService implements UserService {

    final UserDomainService userDomainService;

    public UserServiceImpl(CommandInvoker commandInvoker, UserDomainService userDomainService) {
        super(commandInvoker);
        this.userDomainService = userDomainService;
    }


    @Override
    public UserDTO getUser(GetUserQuery getUserQuery) {
        User user = userDomainService.getUser(getUserQuery.getUserId());
        return UserDTOConverter.toDTO(user);
    }

    @Override
    public void createUser(CreateUserCommand createUserCommand) {
        commandInvoker.executeCommand(createUserCommand);
    }
}
