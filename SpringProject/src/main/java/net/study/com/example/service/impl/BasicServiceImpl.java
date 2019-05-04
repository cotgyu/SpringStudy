package net.study.com.example.service.impl;


import net.study.com.example.dao.impl.basicDao;
import net.study.com.example.domain.basic;
import net.study.com.example.service.BasicService;
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
