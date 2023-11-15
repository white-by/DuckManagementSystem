package com.example.controller;

import cn.hutool.core.util.ObjectUtil;
import com.example.common.Result;
import com.example.entity.Account;
import com.example.entity.AdminInfo;
import com.example.entity.StudentInfo;
import com.example.entity.TeacherInfo;
import com.example.service.AdminInfoService;
import com.example.service.StudentInfoService;
import com.example.service.TeacherInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping
public class AccountController {

    @Resource
    private AdminInfoService adminInfoService;
    @Resource
    private TeacherInfoService teacherInfoService;
    @Resource
    private StudentInfoService studentInfoService;

    @PostMapping("/login")
    public Result login(@RequestBody Account user, HttpServletRequest request) {
        // 检查数据是否空白
        if (ObjectUtil.isEmpty(user.getName()) || ObjectUtil.isEmpty(user.getPassword()) || ObjectUtil.isEmpty(user.getLevel())) {
            return Result.error("-1", "请输入完整信息");
        }

        // 登陆
        Integer level = user.getLevel();
        Account loginUser = new Account();
        // 管理员登陆
        if (level == 1) {
            loginUser = adminInfoService.login(user.getName(), user.getPassword());
        }
        // 教师
        if (level == 2) {
            loginUser = teacherInfoService.login(user.getName(), user.getPassword());
        }
        // 学生
        if (level == 3) {
            loginUser = studentInfoService.login(user.getName(), user.getPassword());
        }

        // session存用户信息
        request.getSession().setAttribute("user", loginUser);

        return Result.success(loginUser);
    }

    @GetMapping("/getUser")
    public Result getUser(HttpServletRequest request) {
        // 从session里获取信息
        Account user = (Account) request.getSession().getAttribute("user");

        Integer level = user.getLevel();
        // 管理员登陆
        if (level == 1) {
            AdminInfo adminInfo = adminInfoService.findById(user.getId());
            return Result.success(adminInfo);
        }
        // 教师
        if (level == 2) {
            TeacherInfo teacherInfo = teacherInfoService.findById(user.getId());
            return Result.success(teacherInfo);
        }
        // 学生
        if (level == 3) {
            StudentInfo studentInfo = studentInfoService.findById(user.getId());
            return Result.success(studentInfo);
        }

        return Result.success(new Account());
    }

    @GetMapping("/logout")
    public Result logout(HttpServletRequest request) {
//        Account user = (Account) request.getSession().getAttribute("user");
        request.getSession().setAttribute("user", null);
        return Result.success();
    }
}
