package com.freetime.demo.example.domain.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.freetime.demo.example.domain.entity.user.vo.UserInfo;
import com.freetime.demo.example.domain.repository.dataobject.UserInfoDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfoDO> {
}
