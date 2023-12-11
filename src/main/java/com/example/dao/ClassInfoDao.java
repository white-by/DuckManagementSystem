package com.example.dao;

import com.example.entity.ClassInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface ClassInfoDao extends Mapper<ClassInfo> {

    @Select("select a.*, b.name as teacherName from class_info as a left join teacher_info as b on a.teacherId = b.id where a.name like concat('%', #{search}, '%')")
    List<ClassInfo> findSearch(@Param("search") String search);
    @Select("select a.*, b.name as teacherName from class_info as a left join teacher_info as b on a.teacherId = b.id")
    List<ClassInfo> findAll();

    @Delete("delete from class_info where teacherId = #{id}")
    void deleteByTeacherId(Long id);
}
