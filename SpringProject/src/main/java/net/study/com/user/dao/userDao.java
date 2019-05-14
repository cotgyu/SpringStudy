package net.study.com.user.dao;

import net.study.com.example.dao.AbstractDAO;
import net.study.com.user.domain.User;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class userDao extends AbstractDAO {

    public User getUserByUserId(String userId){

        return (User)selectOne("userMapper.getUserByUserId", userId);
    }

    public void insertUser(User user){

        insert("userMapper.insertUser", user);
    }
}
