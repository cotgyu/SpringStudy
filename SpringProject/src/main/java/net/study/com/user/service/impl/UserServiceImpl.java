package net.study.com.user.service.impl;

import net.study.com.user.dao.userDao;
import net.study.com.user.domain.User;
import net.study.com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    userDao userDao;

    @Override
    public User getUserByUserId(String userId) {

        User user = userDao.getUserByUserId(userId);

        return user;
    }

    @Override
    public void registerUser(Map userinfo, String loginType) {

        Date regDate = new Date();
        User user = new User();

        if(loginType.equals("GOOGLE")) {
            user.setUser_id((String) userinfo.get("sub"));
            user.setLogin_id((String) userinfo.get("sub"));
        }else if(loginType.equals("KAKAO")){

            user.setUser_id(userinfo.get("id").toString());
            user.setLogin_id(userinfo.get("id").toString());
        }else{
            // 일반 등록
        }


        if(loginType!= null && loginType.length()!=0) {
            user.setLogin_type(loginType);
        }

        user.setReg_date(regDate);



        userDao.insertUser(user);
    }

    @Override
    public boolean userCheck(String userId) {

        if(getUserByUserId(userId) != null) {
            return  true;
        }else{
            return false;
        }
    }


}
