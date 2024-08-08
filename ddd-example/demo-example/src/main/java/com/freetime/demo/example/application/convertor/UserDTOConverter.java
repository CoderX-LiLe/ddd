package com.freetime.demo.example.application.convertor;

import com.freetime.demo.example.application.dto.UserDTO;
import com.freetime.demo.example.domain.entity.user.User;

public class UserDTOConverter {

    public static UserDTO toDTO(User user) {
        return UserDTO.builder()
                .userId(user.getUserId())
                .username(user.getUserName())
                .password(user.getPassword())
                .email(user.getUserInfo().getEmail())
                .phone(user.getUserInfo().getPhone())
                .address(user.getUserInfo().getAddress())
                .build();
    }

}
