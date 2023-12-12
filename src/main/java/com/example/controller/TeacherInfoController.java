package com.example.controller;

import cn.hutool.core.util.ObjectUtil;
import com.example.common.Result;
import com.example.entity.TeacherInfo;
import com.example.service.TeacherInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/teacherInfo")
public class TeacherInfoController {

    @Resource
    private TeacherInfoService teacherInfoService;

    @PostMapping
    public Result add(@RequestBody TeacherInfo teacherInfo) {
        if (ObjectUtil.isEmpty(teacherInfo.getName()) || ObjectUtil.isEmpty(teacherInfo.getMajor()) || ObjectUtil.isEmpty(teacherInfo.getAge()) || ObjectUtil.isEmpty(teacherInfo.getSex()) || ObjectUtil.isEmpty(teacherInfo.getTitle())) {
            return Result.error("-1", "请输入完整信息");
        }
        teacherInfoService.add(teacherInfo);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody TeacherInfo teacherInfo) {
        if (ObjectUtil.isEmpty(teacherInfo.getName()) || ObjectUtil.isEmpty(teacherInfo.getMajor()) || ObjectUtil.isEmpty(teacherInfo.getAge()) || ObjectUtil.isEmpty(teacherInfo.getSex()) || ObjectUtil.isEmpty(teacherInfo.getTitle())) {
            return Result.error("-1", "请输入完整信息");
        }
        teacherInfoService.update(teacherInfo);
        return Result.success();
    }

    @GetMapping
    public Result findAll() {
        List<TeacherInfo> list = teacherInfoService.findAll();
        return Result.success(list);
    }

    @GetMapping("/{search}")
    public Result findSearch(@PathVariable String search) {
        List<TeacherInfo> list = teacherInfoService.findSearch(search);
        return Result.success(list);
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Long id) {
        teacherInfoService.deleteById(id);
        return Result.success();
    }
}
