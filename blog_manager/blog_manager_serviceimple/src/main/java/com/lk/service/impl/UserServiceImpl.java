package com.lk.service.impl;

import com.lk.mapper.UserMapper;
import com.lk.pojo.User;
import com.lk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> getUsers() {
        try {
            return userMapper.selectUserList();
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public User getMyProfile(int uid) {
        try {
            return userMapper.selectUserById(uid);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public User editUser(User user) {
        try {
            userMapper.updateUser(user);
            return userMapper.selectUserById(user.getUserId());
        }catch (Exception e) {
            return null;
        }
    }
}
