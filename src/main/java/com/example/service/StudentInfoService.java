package com.example.service;

import cn.hutool.core.util.ObjectUtil;
import com.example.dao.CourseSelectInfoDao;
import com.example.dao.StudentInfoDao;
import com.example.entity.Account;
import com.example.entity.StudentInfo;
import com.example.exception.CustomException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentInfoService {

    @Resource
    private StudentInfoDao studentInfoDao;
    @Resource
    private CourseSelectInfoDao courseSelectInfoDao;

    public Account login(String name, String password) {
        // 去数据库查信息
        StudentInfo studentInfo = studentInfoDao.findByNameAndPassword(name, password);
        if (ObjectUtil.isEmpty(studentInfo)) {
            throw new CustomException("-1", "您的用户名字或密码有误");
        }
        return studentInfo;
    }

    public StudentInfo findById(Long id) {
        return studentInfoDao.findById(id);
    }

    public void update(StudentInfo studentInfo) {
        studentInfoDao.updateByPrimaryKey(studentInfo);
    }

    public void add(StudentInfo studentInfo) {
        // 初始密码123
        if (ObjectUtil.isEmpty(studentInfo.getPassword())) {
            studentInfo.setPassword("123");
        }
        studentInfoDao.insertSelective(studentInfo);
    }

    public List<StudentInfo> findAll() {
        return studentInfoDao.selectAll();
    }

    public void deleteById(Long id) {
        studentInfoDao.deleteByPrimaryKey(id);
        courseSelectInfoDao.deleteCourseSelectByStudentId(id);
    }

    public List<StudentInfo> findSearch(String search) {
        return studentInfoDao.findSearch(search);
    }

    public StudentInfo findByName(String name) {
        return studentInfoDao.findByName(name);
    }
}









