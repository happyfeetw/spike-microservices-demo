package com.spike.demoserviced.mapper;

import com.spike.demoserviced.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * date: 2021/8/17
 * author: Spike
 * description:
 */
@Mapper
public interface UserMapper {

    void insert(@Param("user") User user);
    void batchInsert(@Param("userList") List<User> userList);
}
