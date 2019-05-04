package net.study.com.example.dao.impl;


import net.study.com.example.dao.AbstractDAO;
import net.study.com.example.domain.basic;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("basicDao")
public class basicDao extends AbstractDAO{

    public List<basic> basic1Select(){

        return selectList("basicMapper.basicSelect");
    }
}
