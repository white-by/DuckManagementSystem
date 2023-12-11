package com.example.service;

import cn.hutool.core.util.ObjectUtil;
import com.example.dao.CourseSelectInfoDao;
import com.example.dao.StudentInfoDao;
import com.example.dao.TeacherInfoDao;
import com.example.entity.*;
import com.example.exception.CustomException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class CourseSelectInfoService {
    @Resource
    private CourseSelectInfoDao courseSelectInfoDao;
    @Resource
    private TeacherInfoDao teacherInfoDao;
    @Resource
    private StudentInfoDao studentInfoDao;

    public List<CourseSelectInfo> findAll(HttpServletRequest request) {
        Account user = (Account) request.getSession().getAttribute("user");
        if (ObjectUtil.isEmpty(user)) {
            throw new CustomException("-1", "登陆失效，请重新登陆");
        }

        List<CourseSelectInfo> list;
        if (user.getLevel() == 1) { // admin
            list = courseSelectInfoDao.findAll();
        }
        else if (user.getLevel() == 2) { // teacher
            list = courseSelectInfoDao.findByCondition(user.getId(), null);
        }
        else { // stu
            list = courseSelectInfoDao.findByCondition(null, user.getId());
        }

        for (CourseSelectInfo courseSelectInfo : list) {
            TeacherInfo teacherInfo = teacherInfoDao.selectByPrimaryKey(courseSelectInfo.getTeacherId());
            StudentInfo studentInfo = studentInfoDao.selectByPrimaryKey(courseSelectInfo.getStudentId());
            courseSelectInfo.setTeacherName(teacherInfo.getName());
            courseSelectInfo.setStudentName(studentInfo.getName());
        }
        return list;
    }

    public void add(CourseSelectInfo courseSelectInfo) {
        courseSelectInfoDao.insertSelective(courseSelectInfo);
    }


    public CourseSelectInfo find(String name, Long teacherId, Long studentId) {
        return courseSelectInfoDao.find(name, teacherId, studentId);
    }

}









