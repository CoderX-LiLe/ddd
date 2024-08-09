package com.freetime.demo.example.domain.repository.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.freetime.ddd.orm.BaseDO;
import lombok.Builder;
import lombok.Data;

@TableName("user_info")
@Data
@Builder
public class UserInfoDO extends BaseDO {

    private  String address;

    private  Long userId;

    private  String phone;

    private  String email;

    private  String alias;
}
