package com.freetime.demo.example.domain.repository.dataobject;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.freetime.ddd.orm.BaseDO;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@TableName("user")
@Data
@Builder
public class UserDO extends BaseDO {

    private Long id;

    @TableField("user_id")
    private Long userId;

    private String userName;

    private String password;
}
