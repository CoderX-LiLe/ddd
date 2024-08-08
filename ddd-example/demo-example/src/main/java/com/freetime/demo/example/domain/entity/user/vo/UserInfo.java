package com.freetime.demo.example.domain.entity.user.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserInfo {

    private final String address;

    private final Long userId;

    private final String phone;

    private final String email;

    private final String alias;
}
