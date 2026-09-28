package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.anno.Log;
import org.example.pojo.Dept;
import org.example.pojo.Result;
import org.example.service.DeptService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理控制器
 */
@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {

    //private static final Logger log = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private DeptService deptService;

    /**
     * 查询部门列表
     */
    @GetMapping
    //@RequestMapping(value="/depts",method = RequestMethod.GET)
    public Result list(){
        log.info("查询全部的部门数据");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    /**
     * 删除部门
     */
    @Log
    @DeleteMapping
    public Result delete(Integer id){
        //System.out.println("根据ID删除部门: " + id);
        log.info("根据ID删除部门:{}",id);
        deptService.deleteById(id);
        return Result.success();
    }

    /**
     * 新增部门
     */
    @Log
    @PostMapping
    public Result add(@RequestBody Dept dept){
        //System.out.println("新增部门：" + dept);
        log.info("新增部门, dept: {}" , dept);
        deptService.add(dept);
        return Result.success();
    }
    /**
     * 根据ID查询部门
     */
    @Log
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        //System.out.println("根据ID查询, id=" + id);
        log.info("根据ID查询, id: {}" , id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    /**
     * 修改部门 - PUT http://localhost:8080/depts  请求参数：{"id":1,"name":"研发部"}
     */
    @Log
    @PutMapping
    public Result update(@RequestBody Dept dept){
        //System.out.println("修改部门, dept=" + dept);
        log.info("修改部门, dept: {}" , dept);
        deptService.update(dept);
        return Result.success();
    }
}