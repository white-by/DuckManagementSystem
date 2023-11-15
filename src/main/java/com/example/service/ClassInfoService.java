package com.example.service;

import com.example.dao.ClassInfoDao;
import com.example.entity.ClassInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClassInfoService {
    @Resource
    private ClassInfoDao classInfoDao;

    public void add(ClassInfo classInfo) {
        classInfoDao.insertSelective(classInfo);
    }

    public List<ClassInfo> findAll() {
        return classInfoDao.findAll();
    }

    public void update(ClassInfo classInfo) {
        classInfoDao.updateByPrimaryKeySelective(classInfo);
    }

    public void deleteById(Long id) {
        classInfoDao.deleteByPrimaryKey(id);
    }

    public List<ClassInfo> findSearch(String search) {
        return classInfoDao.findSearch(search);
    }
}









