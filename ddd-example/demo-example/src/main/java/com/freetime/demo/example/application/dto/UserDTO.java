package com.freetime.demo.example.application.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    private Long userId;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String address;
    private String alias;
}
