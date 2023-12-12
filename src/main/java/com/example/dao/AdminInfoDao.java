package com.example.dao;

import com.example.entity.AdminInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface AdminInfoDao extends Mapper<AdminInfo> {

    @Select("select * from admin_info where name = #{name} and password = #{password}")
    AdminInfo findByNameAndPassword(@Param("name") String name, @Param("password") String password);

    @Select("select * from admin_info where id = #{id}")
    AdminInfo findById(Long id);

    @Select("select * from admin_info where name like concat('%', #{search}, '%')")
    List<AdminInfo> findSearch(String search);
}
