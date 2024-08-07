package com.freetime.orm.example.mybatis.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.freetime.ddd.orm.repository.Predicate;
import com.freetime.orm.example.mybatis.entity.UserEntity;
import com.freetime.orm.example.mybatis.repository.UserRepository;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * 添加
     */
    public void add() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName("test");
        userEntity.setPassword("123456");
        userRepository.save(userEntity);
    }

    /**
     * 查询列表
     */
    public void list() {
        List<Triple<SFunction<UserEntity, ?>, Object, Predicate>> queryConditions = userRepository.getQueryConditions();
        queryConditions.add(Triple.of(UserEntity::getUserName, "test", Predicate.IS_EQUAL));
        List<UserEntity> userEntityList = userRepository.findList(queryConditions);
        System.out.println(userEntityList);
    }

    /**
     * 分页查询
     */
    public void page() {
        Long pageNum = 1L;
        Long pageSize = 10L;
        List<Triple<SFunction<UserEntity, ?>, Object, Predicate>> queryConditions = userRepository.getQueryConditions();
        queryConditions.add(Triple.of(UserEntity::getUserName, "test", Predicate.IS_EQUAL));
        IPage<UserEntity> page = userRepository.findPage(queryConditions, pageNum, pageSize);
        System.out.println(page);
    }

    /**
     * 查询单个
     */
    public UserEntity findOne() {
        List<Triple<SFunction<UserEntity, ?>, Object, Predicate>> queryConditions = userRepository.getQueryConditions();
        queryConditions.add(Triple.of(UserEntity::getUserName, "test", Predicate.IS_EQUAL));
        UserEntity userEntity = userRepository.findOne(queryConditions);
        System.out.println(userEntity);
        return userEntity;
    }

    /**
     * 删除
     */
    public void deleteByConditions() {
        List<Triple<SFunction<UserEntity, ?>, Object, Predicate>> queryConditions = userRepository.getQueryConditions();
        queryConditions.add(Triple.of(UserEntity::getUserName, "test", Predicate.IS_EQUAL));
        userRepository.delete(queryConditions);
    }

    /**
     * 通过id删除
     */
    public void deleteById() {
        userRepository.removeById(1L);
    }

    /**
     * 修改
     */
    public void update() {
        UserEntity userEntity = findOne();
        List<Pair<SFunction<UserEntity, ?>, Object>> updateConditions = userRepository.getUpdateConditions();
        updateConditions.add(Pair.of(UserEntity::getUserName, "test1"));
        userRepository.updateById(userEntity.getId(), userEntity, updateConditions);
    }
}
