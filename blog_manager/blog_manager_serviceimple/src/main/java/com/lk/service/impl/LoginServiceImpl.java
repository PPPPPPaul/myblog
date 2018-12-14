package com.lk.service.impl;

import com.lk.custom.result.YHResult;
import com.lk.mapper.UserMapper;
import com.lk.pojo.User;
import com.lk.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public YHResult loginVerify(User user) {
        try {
            User userByName = userMapper.selectUserByName(user.getUserName());
            if (userByName==null){
                return YHResult.build(500,"不存在该用户名!");
            }else {
                if (user.getUserPass().equals(userByName.getUserPass())){
                    Date date = new Date();
                    user.setUserLastLoginTime(date);
                    userMapper.updateUser(user);
                    return YHResult.ok(200,userByName);
                }else {
                    return YHResult.build(500,"密码输入错误!");
                }
            }
        }catch (Exception e){
           return YHResult.build(500,"未知错误!");
        }
    }
}
