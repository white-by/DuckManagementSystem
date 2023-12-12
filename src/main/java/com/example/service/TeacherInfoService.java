package com.example.service;

import cn.hutool.core.util.ObjectUtil;
import com.example.dao.ClassInfoDao;
import com.example.dao.CourseSelectInfoDao;
import com.example.dao.TeacherInfoDao;
import com.example.entity.Account;
import com.example.entity.TeacherInfo;
import com.example.exception.CustomException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeacherInfoService {

    @Resource
    private TeacherInfoDao teacherInfoDao;
    @Resource
    private CourseSelectInfoDao courseSelectInfoDao;
    @Resource
    private ClassInfoDao classInfoDao;


    public Account login(String name, String password) {
        // 去数据库查信息
        TeacherInfo teacherInfo = teacherInfoDao.findByNameAndPassword(name, password);
        if (ObjectUtil.isEmpty(teacherInfo)) {
            throw new CustomException("-1", "您的用户名字或密码有误");
        }
        return teacherInfo;
    }

    public TeacherInfo findById(Long id) {
        return teacherInfoDao.findById(id);
    }

    public void update(TeacherInfo teacherInfo) {
        teacherInfoDao.updateByPrimaryKey(teacherInfo);
    }

    public void add(TeacherInfo teacherInfo) {
        // 初始密码123
        if (ObjectUtil.isEmpty(teacherInfo.getPassword())) {
            teacherInfo.setPassword("123");
        }
        teacherInfoDao.insertSelective(teacherInfo);
    }

    public List<TeacherInfo> findAll() {
        return teacherInfoDao.selectAll();
    }

    public void deleteById(Long id) {
        teacherInfoDao.deleteByPrimaryKey(id);
        courseSelectInfoDao.deleteCourseSelectByTeacherId(id);
        classInfoDao.deleteByTeacherId(id);
    }

    public List<TeacherInfo> findSearch(String search) {
        return teacherInfoDao.findSearch(search);
    }
}









