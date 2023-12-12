package com.example.service;

import cn.hutool.core.util.ObjectUtil;
import com.example.dao.AdminInfoDao;
import com.example.entity.Account;
import com.example.entity.AdminInfo;
import com.example.exception.CustomException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminInfoService {

    @Resource
    private AdminInfoDao adminInfoDao;

    public Account login(String name, String password) {
        // 去数据库查信息
        AdminInfo adminInfo = adminInfoDao.findByNameAndPassword(name, password);
        if (ObjectUtil.isEmpty(adminInfo)) {
            throw new CustomException("-1", "您的用户名字或密码有误");
        }

        return adminInfo;
    }

    public AdminInfo findById(Long id) {
        return adminInfoDao.findById(id);
    }

    public void update(AdminInfo adminInfo) {
        adminInfoDao.updateByPrimaryKey(adminInfo);
    }

    public void add(AdminInfo adminInfo) {
        // 初始密码123
        if (ObjectUtil.isEmpty(adminInfo.getPassword())) {
            adminInfo.setPassword("123");
        }
        adminInfoDao.insertSelective(adminInfo);
    }

    public List<AdminInfo> findAll() {
        return adminInfoDao.selectAll();
    }

    public void deleteById(Long id) {
        adminInfoDao.deleteByPrimaryKey(id);
    }

    public List<AdminInfo> findSearch(String search) {
        return adminInfoDao.findSearch(search);
    }
}









