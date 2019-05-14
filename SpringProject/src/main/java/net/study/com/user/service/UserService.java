package net.study.com.user.service;

import net.study.com.user.domain.User;

import java.util.Map;

public interface UserService {

    User getUserByUserId(String userId);

    void registerUser(Map userinfo, String loginType);

    boolean userCheck(String userId);
}
