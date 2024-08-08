package com.freetime.demo.example.domain.repository.convertor;


import com.freetime.demo.example.domain.entity.user.User;
import com.freetime.demo.example.domain.repository.dataobject.UserDO;

public class UserConvertor {

    public static User toEntity(UserDO userDo) {
        return User.builder()
                .id(userDo.getId())
                .userId(userDo.getUserId())
                .userName(userDo.getUserName())
                .password(userDo.getPassword())
                .build();
    }

    public static UserDO toDO(User user) {
        return UserDO.builder()
                .id(user.getId())
                .userId(user.getUserId())
                .userName(user.getUserName())
                .password(user.getPassword())
                .build();
    }
}
