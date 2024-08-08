package com.freetime.demo.example.domain.entity.user;

import com.baomidou.mybatisplus.annotation.TableName;
import com.freetime.ddd.core.annotations.Entity;
import com.freetime.demo.example.domain.entity.user.vo.UserInfo;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private Long id;

    private Long userId;

    private String userName;

    private String password;

    @Entity
    private UserInfo userInfo;
}
