package net.study.baseMybatis.dao;


import net.study.baseMybatis.domain.basic;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("basicDao")
public class basicDao extends AbstractDAO{

    public List<basic> basic1Select(){

        return selectList("basicMapper.basicSelect");
    }
}
