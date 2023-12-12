package com.example.controller;

import cn.hutool.core.util.ObjectUtil;
import com.example.common.Result;
import com.example.entity.AdminInfo;
import com.example.service.AdminInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/adminInfo")
public class AdminInfoController {

    @Resource
    private AdminInfoService adminInfoService;

    @PostMapping
    public Result add(@RequestBody AdminInfo adminInfo) {
        // 检查数据是否空白
        if (ObjectUtil.isEmpty(adminInfo.getName()) || ObjectUtil.isEmpty(adminInfo.getPhone()) || ObjectUtil.isEmpty(adminInfo.getAge()) || ObjectUtil.isEmpty(adminInfo.getSex())) {
            return Result.error("-1", "请输入完整信息");
        }
        adminInfoService.add(adminInfo);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody AdminInfo adminInfo) {
        // 检查数据是否空白
        if (ObjectUtil.isEmpty(adminInfo.getName()) || ObjectUtil.isEmpty(adminInfo.getPhone()) || ObjectUtil.isEmpty(adminInfo.getAge()) || ObjectUtil.isEmpty(adminInfo.getSex())) {
            return Result.error("-1", "请输入完整信息");
        }
        adminInfoService.update(adminInfo);
        return Result.success();
    }

    @GetMapping
    public Result findAll() {
        List<AdminInfo> list = adminInfoService.findAll();
        return Result.success(list);
    }

    @GetMapping("/{search}")
    public Result findSearch(@PathVariable String search) {
        List<AdminInfo> list = adminInfoService.findSearch(search);
        return Result.success(list);
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Long id) {
        adminInfoService.deleteById(id);
        return Result.success();
    }
}
