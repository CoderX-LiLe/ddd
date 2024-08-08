package com.freetime.demo.example.domain.repository.convertor;

import com.freetime.demo.example.domain.entity.user.vo.UserInfo;
import com.freetime.demo.example.domain.repository.dataobject.UserInfoDO;

public class UserInfoConvertor {

    public static UserInfo toEntity(UserInfoDO userInfoDO) {
        return UserInfo.builder()
                .userId(userInfoDO.getUserId())
                .address(userInfoDO.getAddress())
                .phone(userInfoDO.getPhone())
                .email(userInfoDO.getEmail())
                .alias(userInfoDO.getAlias())
                .build();
    }

    public static UserInfoDO toDO(UserInfo userInfo) {
        return UserInfoDO.builder()
                .userId(userInfo.getUserId())
                .address(userInfo.getAddress())
                .phone(userInfo.getPhone())
                .email(userInfo.getEmail())
                .alias(userInfo.getAlias())
                .build();
    }
}
