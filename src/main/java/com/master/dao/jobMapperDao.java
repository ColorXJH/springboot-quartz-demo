package com.master.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2020/9/25 9:21
 */

//@Component
@Mapper
//@Mapper可以代替@Repository/@Component，可以省却@MapperScan扫描，但是每个接口上注解一个@Mapper
//并不是一个好办法，还是建议注解一个@MapperScan扫描所有的接口
public interface jobMapperDao {

    public void insertRecordByJob(@Param("name")String name);
}
