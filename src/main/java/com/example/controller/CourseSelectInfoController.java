package com.example.controller;

import com.example.common.Result;
import com.example.entity.ClassInfo;
import com.example.entity.CourseSelectInfo;
import com.example.service.ClassInfoService;
import com.example.service.CourseSelectInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/courseSelectInfo")
public class CourseSelectInfoController {

    @Resource
    private CourseSelectInfoService courseSelectInfoService;

    @GetMapping
    public Result findAll(HttpServletRequest request) {
        List<CourseSelectInfo> list = courseSelectInfoService.findAll(request);
        return Result.success(list);
    }

}
