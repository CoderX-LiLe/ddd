package com.freetime.demo.example.domain.service.impl;

import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.freetime.ddd.orm.repository.Predicate;
import com.freetime.demo.example.domain.entity.user.User;
import com.freetime.demo.example.domain.entity.user.vo.UserInfo;
import com.freetime.demo.example.domain.repository.UserInfoRepository;
import com.freetime.demo.example.domain.repository.UserRepository;
import com.freetime.demo.example.domain.repository.convertor.UserConvertor;
import com.freetime.demo.example.domain.repository.convertor.UserInfoConvertor;
import com.freetime.demo.example.domain.repository.dataobject.UserDO;
import com.freetime.demo.example.domain.repository.dataobject.UserInfoDO;
import com.freetime.demo.example.domain.service.UserDomainService;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDomainServiceImpl implements UserDomainService {

    final UserRepository userRepository;
    final UserInfoRepository userInfoRepository;

    public UserDomainServiceImpl(UserRepository userRepository, UserInfoRepository userInfoRepository) {
        this.userRepository = userRepository;
        this.userInfoRepository = userInfoRepository;
    }

    @Override
    public User getUser(Long userId) {
        List<Triple<SFunction<UserDO, ?>, Object, Predicate>> userQueryConditions = userRepository.getQueryConditions();
        userQueryConditions.add(Triple.of(UserDO::getId, userId, Predicate.IS_EQUAL));
        UserDO userDO = userRepository.findOne(userQueryConditions);

        List<Triple<SFunction<UserInfoDO, ?>, Object, Predicate>> userInfoQueryConditions = userInfoRepository.getQueryConditions();
        userInfoQueryConditions.add(Triple.of(UserInfoDO::getUserId, userId, Predicate.IS_EQUAL));
        UserInfoDO userInfoDO = userInfoRepository.findOne(userInfoQueryConditions);

        User user = UserConvertor.toEntity(userDO);
        UserInfo userInfo = UserInfo.builder().build();
        if(userInfoDO != null){
            userInfo = UserInfoConvertor.toEntity(userInfoDO);
        }
        user.setUserInfo(userInfo);
        return user;
    }

    @Override
    public void createUser(User user) {
        UserDO userDO = UserConvertor.toDO(user);
        userRepository.save(userDO);

        if(user.getUserInfo() != null){
            UserInfoDO userInfoDO = UserInfoConvertor.toDO(user.getUserInfo());
            userInfoRepository.save(userInfoDO);
        }
    }

    @Override
    public void login(Long userId) {
        List<Triple<SFunction<UserDO, ?>, Object, Predicate>> queryConditions = userRepository.getQueryConditions();
        queryConditions.add(Triple.of(UserDO::getId, userId, Predicate.IS_EQUAL));
        UserDO userDO = userRepository.findOne(queryConditions);

        if(userDO == null){
            throw new RuntimeException("User not found");
        }

        List<Pair<SFunction<UserDO, ?>, Object>> updateConditions = userRepository.getUpdateConditions();
        updateConditions.add(Pair.of(UserDO::getStatus, 1));
        userRepository.updateById(userId,userDO,updateConditions);
    }
}
