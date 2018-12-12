package com.lk.mapper;

import com.lk.pojo.User;

import java.util.List;

public interface UserMapper {
    /**
     * 根据用户名获取用户信息
     * @param user_name
     * @return
     */
    User selectUserByName(String user_name);

    /**
     * 根据用户id获取用户信息
     * @param uid
     * @return
     */
    User selectUserById(int uid);
    /**
     * 获取全部的用户信息
     * @return
     */
    List<User> selectUserList();

    /**
     * 更新数据库用户信息
     * @param user
     */
    void updateUser(User user);
}
