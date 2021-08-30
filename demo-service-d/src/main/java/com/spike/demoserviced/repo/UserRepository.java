package com.spike.demoserviced.repo;

import com.spike.demoserviced.entity.User;
import com.spike.demoserviced.mapper.UserMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * date: 2021/8/16
 * author: Spike
 * description:
 */
@Component
public class UserRepository {

    @Resource
    UserMapper userMapper;

    public Long createUser(User user){
        userMapper.insert(user);
        return user.getId();
    }

    public List<Long> batchCreateUser(List<User> userList){
        userMapper.batchInsert(userList);
        int a = 1/0;
        return userList.stream().map(User::getId).collect(Collectors.toList());
    }



}
