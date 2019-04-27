package net.study.com.service;


import net.study.com.dao.basicDao;
import net.study.com.domain.basic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicServiceImpl implements BasicService {

    @Autowired
    basicDao basicDao;

    public List<basic> basic1go (){
        return basicDao.basic1Select();
    }

}
