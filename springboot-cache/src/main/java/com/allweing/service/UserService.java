package com.allweing.service;

import com.allweing.YuService;
import com.allweing.mapper.UserMapper;
import com.allweing.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @auther: zzzgyu
 */

@Service
public class UserService {

    @Resource
    UserMapper userMapper;

    @Autowired
    YuService yuService;

    @Cacheable(value = "mm",key = "#id")
    public User queryUserById(Long id ) {
        System.out.println(yuService.getMyName()+"======"+yuService.getMyAge()+"======"+yuService.getMySex());
        System.out.println("=======================================");
        User user = userMapper.selectById(id);
        return user;
    }
    @CachePut(value = "mm",key = "#id")
    @Async
    public void updataUserById( Long id ) {
        System.out.println("==================updataUserById");
        User user = new User();
        user.setId(id);
        user.setPhone("2919999999");
        userMapper.updateById(user);
    }
}
