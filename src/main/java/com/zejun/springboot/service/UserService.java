package com.zejun.springboot.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zejun.springboot.entity.User;
import com.zejun.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {

    public boolean saveUser(User user) {
        return saveOrUpdate(user);
    }
//    @Autowired
//    private UserMapper userMapper;
//    public int save(User user){
//        if(user.getId() == null) { //add
//            return userMapper.insert(user);
//        }else { //update
//            return userMapper.update(user);
//        }
//
//    }
}
