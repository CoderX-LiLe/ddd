package com.freetime.orm.example.mybatis.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.freetime.ddd.orm.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@TableName("t_user")
@Data
public class UserEntity extends BaseDO {

    private String userName;

    private String password;
}
