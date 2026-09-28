package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.pojo.PageResult;
import org.example.pojo.Result;
import org.example.pojo.Student;
import org.example.pojo.StudentQueryParam;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 学员管理Controller
 */
@Slf4j
@RequestMapping("/students")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 分页条件查询学员
     */
    @GetMapping
    public Result page(StudentQueryParam studentQueryParam) {
        log.info("学员分页查询参数：{}", studentQueryParam);
        PageResult<Student> pageResult = studentService.page(studentQueryParam);
        return Result.success(pageResult);
    }

    /**
     * 新增学员
     */
    @PostMapping
    public Result save(@RequestBody Student student) {
        log.info("新增学员信息：{}", student);
        studentService.save(student);
        return Result.success();
    }

    /**
     * 批量删除学员
     */
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids) {
        log.info("批量删除学员ids：{}", ids);
        studentService.delete(ids);
        return Result.success();
    }

    /**
     * 根据ID查询学员详情（回显）
     */
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
        log.info("根据id查询学员详情，id={}", id);
        Student student = studentService.getInfo(id);
        return Result.success(student);
    }

    /**
     * 修改学员信息
     */
    @PutMapping
    public Result update(@RequestBody Student student) {
        log.info("修改学员信息：{}", student);
        studentService.update(student);
        return Result.success();
    }
}
