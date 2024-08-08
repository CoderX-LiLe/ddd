package com.freetime.demo.example.domain.repository;

import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.freetime.ddd.orm.repository.MybatisRepository;

import com.freetime.demo.example.domain.repository.dataobject.UserInfoDO;
import com.freetime.demo.example.domain.repository.mapper.UserInfoMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserInfoRepository extends MybatisRepository<UserInfoMapper, UserInfoDO> {

    @Override
    protected SFunction<UserInfoDO, ?> getIdAccessor() {
        return null;
    }
}
