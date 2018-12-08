package com.lk.mapper;

import com.lk.pojo.User;

public interface UserMapper {
    /**
     * 根据用户名获取用户信息
     * @param user_name
     * @return
     */
    User selectUserByName(String user_name);
}
