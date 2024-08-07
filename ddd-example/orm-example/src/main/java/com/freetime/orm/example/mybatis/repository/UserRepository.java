package com.freetime.orm.example.mybatis.repository;

import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.freetime.ddd.orm.repository.MybatisRepository;
import com.freetime.orm.example.mybatis.entity.UserEntity;
import com.freetime.orm.example.mybatis.mapper.UserMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends MybatisRepository<UserMapper, UserEntity> {
    @Override
    protected SFunction<UserEntity, ?> getIdAccessor() {
        return UserEntity::getId;
    }
}
