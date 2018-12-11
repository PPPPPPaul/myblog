package com.lk.service;

import com.lk.pojo.User;

import java.util.List;

public interface UserService {
    /**
     * 查询全部的用户信息
     * @return
     */
    List<User> getUsers();

    /**
     * 根据用户id获取用户的基本资料
     * @param uid
     * @return
     */
    User getMyProfile(int uid);
}
