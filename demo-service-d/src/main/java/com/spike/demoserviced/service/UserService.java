package com.spike.demoserviced.service;

import com.spike.demoserviced.entity.User;
import com.spike.demoserviced.repo.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * date: 2021/8/17
 * author: Spike
 * description:
 */
@Service
public class UserService {
    @Resource
    UserRepository userRepository;

    /**
     * 单独创建user
     * @param user user对象
     * @return userId
     */
    @Transactional(rollbackFor = Throwable.class)
    public Long createUser(User user){
        List<User> users = Collections.singletonList(user);
        /**
         * serf-invoke 会令被调用的方法上的spring事务注解失效
         * 解决办法：在产生self-invoke的方法上面也加上同样的事务注解即可
         */
        List<Long> userIds = this.batchCreateUser(users);
        return CollectionUtils.firstElement(userIds);
    }

    /**
     * 批量创建
     * @param userList user集合
     * @return  返回userId集合
     */
    @Transactional(rollbackFor = Throwable.class)
    public List<Long> batchCreateUser(List<User> userList){
        return userRepository.batchCreateUser(userList);
    }

}
