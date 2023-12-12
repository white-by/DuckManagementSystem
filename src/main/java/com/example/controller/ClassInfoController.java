package com.example.controller;

import cn.hutool.core.util.ObjectUtil;
import com.example.common.Result;
import com.example.entity.Account;
import com.example.entity.AdminInfo;
import com.example.entity.ClassInfo;
import com.example.entity.CourseSelectInfo;
import com.example.exception.CustomException;
import com.example.service.ClassInfoService;
import com.example.service.CourseSelectInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/classInfo")
public class ClassInfoController {

    @Resource
    private ClassInfoService classInfoService;
    @Resource
    private CourseSelectInfoService courseSelectInfoService;

    @PostMapping
    public Result add(@RequestBody ClassInfo classInfo) {
        // 检查数据是否空白
        if (ObjectUtil.isEmpty(classInfo.getName()) || ObjectUtil.isEmpty(classInfo.getMajor()) || ObjectUtil.isEmpty(classInfo.getClassOpen()) || ObjectUtil.isEmpty(classInfo.getDescription()) || ObjectUtil.isEmpty(classInfo.getScore()) || ObjectUtil.isEmpty(classInfo.getTeacherId())  || ObjectUtil.isEmpty(classInfo.getLocation()) || ObjectUtil.isEmpty(classInfo.getTime())) {
            return Result.error("-1", "请输入完整信息");
        }
        classInfoService.add(classInfo);
        return Result.success();
    }

    @PostMapping("/courseSelectInfo")
    public Result courseSelect(@RequestBody ClassInfo classInfo, HttpServletRequest request) {
        // 以防万一，user的session被浏览器清掉而导致空指针异常
        Account user = (Account) request.getSession().getAttribute("user");
        if (ObjectUtil.isEmpty(user)) {
            throw new CustomException("-1", "登陆失效，请重新登陆");
        }
        // 0. 判断学生有无选过课
        CourseSelectInfo info = courseSelectInfoService.find(classInfo.getName(), classInfo.getTeacherId(), user.getId());
        if (ObjectUtil.isNotEmpty(info)) {
            throw new CustomException("-1", "您已经选过此门课程，请勿操作");
        }

        // 1. 判断课程是否还有空位（后端实现，前台弹窗提示用户）
//        if (classInfo.getClassOpen().equals(classInfo.getClassChoose())) {
//            throw new CustomException("-1", "人数已满");
//        }

        // 2. 把课程信息传到选课界面
        CourseSelectInfo courseSelectInfo = new CourseSelectInfo();
        BeanUtils.copyProperties(classInfo, courseSelectInfo);
        courseSelectInfo.setId(null);

        // 3. 补全选课信息表
        courseSelectInfo.setStudentId(user.getId());
        courseSelectInfoService.add(courseSelectInfo);

        // 4. 已选人数加一
        classInfo.setClassChoose(classInfo.getClassChoose() + 1);
        classInfoService.update(classInfo);

        return Result.success();
    }

    @GetMapping
    public Result findAll() {
        List<ClassInfo> list = classInfoService.findAll();
        return Result.success(list);
    }

    @GetMapping("/{search}")
    public Result findSearch(@PathVariable String search) {
        List<ClassInfo> list = classInfoService.findSearch(search);
        return Result.success(list);
    }

    @PutMapping
    public Result update(@RequestBody ClassInfo classInfo) {
        if (ObjectUtil.isEmpty(classInfo.getName()) || ObjectUtil.isEmpty(classInfo.getMajor()) || ObjectUtil.isEmpty(classInfo.getClassOpen()) || ObjectUtil.isEmpty(classInfo.getDescription()) || ObjectUtil.isEmpty(classInfo.getScore()) || ObjectUtil.isEmpty(classInfo.getTeacherId())  || ObjectUtil.isEmpty(classInfo.getLocation()) || ObjectUtil.isEmpty(classInfo.getTime())) {
            return Result.error("-1", "请输入完整信息");
        }
        classInfoService.update(classInfo);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Long id) {
        classInfoService.deleteById(id);
        return Result.success();
    }

}
