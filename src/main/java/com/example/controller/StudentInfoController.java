package com.example.controller;

import cn.hutool.core.util.ObjectUtil;
import com.example.common.Result;
import com.example.common.ResultCode;
import com.example.entity.StudentInfo;
import com.example.exception.CustomException;
import com.example.service.StudentInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/studentInfo")
public class StudentInfoController {

    @Resource
    private StudentInfoService studentInfoService;

    @PostMapping
    public Result add(@RequestBody StudentInfo studentInfo) {
        // 检查数据是否空白
        if (ObjectUtil.isEmpty(studentInfo.getName()) || ObjectUtil.isEmpty(studentInfo.getMajor()) || ObjectUtil.isEmpty(studentInfo.getAge()) || ObjectUtil.isEmpty(studentInfo.getSex()) || ObjectUtil.isEmpty(studentInfo.getUid())) {
            return Result.error("-1", "请输入完整信息");
        }
//        AdminInfo admin = adminInfoService.findByName(adminInfo.getName());
//        if (ObjectUtil.isNotEmpty(admin)) {
//            throw new CustomException(ResultCode.USER_EXIST_ERROR);
//        }
        StudentInfo student = studentInfoService.findByName(studentInfo.getName());
        if (ObjectUtil.isNotEmpty(student)) {
            throw new CustomException(ResultCode.USER_EXIST_ERROR);
        }
        studentInfoService.add(studentInfo);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody StudentInfo studentInfo) {
        if (ObjectUtil.isEmpty(studentInfo.getName()) || ObjectUtil.isEmpty(studentInfo.getMajor()) || ObjectUtil.isEmpty(studentInfo.getAge()) || ObjectUtil.isEmpty(studentInfo.getSex()) || ObjectUtil.isEmpty(studentInfo.getUid())) {
            return Result.error("-1", "请输入完整信息");
        }
        studentInfoService.update(studentInfo);
        return Result.success();
    }

    @GetMapping
    public Result findAll() {
        List<StudentInfo> list = studentInfoService.findAll();
        return Result.success(list);
    }

    @GetMapping("/{search}")
    public Result findSearch(@PathVariable String search) {
        List<StudentInfo> list = studentInfoService.findSearch(search);
        return Result.success(list);
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Long id) {
        studentInfoService.deleteById(id);
        return Result.success();
    }
}
