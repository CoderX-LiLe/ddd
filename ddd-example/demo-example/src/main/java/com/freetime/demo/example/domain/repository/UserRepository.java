package com.freetime.demo.example.domain.repository;

import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.freetime.ddd.orm.repository.MybatisRepository;
import com.freetime.demo.example.domain.entity.user.User;
import com.freetime.demo.example.domain.repository.dataobject.UserDO;
import com.freetime.demo.example.domain.repository.mapper.UserMapper;
import org.springframework.stereotype.Repository;

/**
 * user类仓储
 */
@Repository
public class UserRepository extends MybatisRepository<UserMapper, UserDO> {

    @Override
    protected SFunction<UserDO, ?> getIdAccessor() {
        return null;
    }
}
