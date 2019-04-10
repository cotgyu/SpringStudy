package net.study.baseMybatis.service;


import net.study.baseMybatis.dao.basicDao;
import net.study.baseMybatis.domain.basic;
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
