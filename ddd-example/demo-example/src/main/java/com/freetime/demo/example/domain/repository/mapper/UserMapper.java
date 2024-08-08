package com.freetime.demo.example.domain.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.freetime.demo.example.domain.repository.dataobject.UserDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserDO> {
}
