package com.example.dao;

import com.example.entity.CourseSelectInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface CourseSelectInfoDao extends Mapper<CourseSelectInfo> {

    @Select("select a.*, b.name as teacherName from course_select_info as a left join teacher_info as b on a.teacherId = b.id")
    List<CourseSelectInfo> findAll();

    @Select("select * from course_select_info where name = #{name} and teacherId = #{teacherId} and studentId = #{studentId}")
    CourseSelectInfo find(@Param("name") String name, @Param("teacherId") Long teacherId, @Param("studentId") Long studentId);

    List<CourseSelectInfo> findByCondition(@Param("teacherId") Long teacherId, @Param("studentId") Long studentId);
}
