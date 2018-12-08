package com.lk.service;

import com.lk.custom.result.YHResult;
import com.lk.pojo.User;

public interface LoginService {
    YHResult loginVerify(User user);
}
