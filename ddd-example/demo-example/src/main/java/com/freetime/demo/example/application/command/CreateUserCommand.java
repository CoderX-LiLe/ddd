package com.freetime.demo.example.application.command;

import com.freetime.ddd.command.base.BaseCommand;
import com.freetime.ddd.spring.utils.BeanUtils;
import com.freetime.demo.example.domain.entity.user.User;
import com.freetime.demo.example.domain.service.UserDomainService;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CreateUserCommand extends BaseCommand<String> {

    private String username;

    private String password;

    @Override
    public void execute() {
        User user = User.builder()
                .userName(username)
                .password(password)
                .build();
        UserDomainService userDomainService = BeanUtils.getBean(UserDomainService.class);
        userDomainService.createUser(user);
        setResult("success");
    }
}
