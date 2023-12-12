package com.example.dao;

import com.example.entity.TeacherInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface TeacherInfoDao extends Mapper<TeacherInfo> {
    @Select("select * from teacher_info where name = #{name} and password = #{password}")
    TeacherInfo findByNameAndPassword(@Param("name") String name, @Param("password") String password);

    @Select("select * from teacher_info where id = #{id}")
    TeacherInfo findById(Long id);

    @Select("select * from teacher_info where name like concat('%', #{search}, '%')")
    List<TeacherInfo> findSearch(String search);

    @Select("select * from teacher_info where name = #{name} ")
    TeacherInfo findByName(String name);
}
