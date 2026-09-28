package org.example.controller;

import org.example.pojo.Clazz;
import org.example.pojo.Result;
import org.example.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clazzs")
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    /**
     * 班级列表条件分页查询 GET /clazzs
     * 参数：name begin end page pageSize
     */
    @GetMapping
    public Result pageList(
            String name,
            String begin,
            String end,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer pageSize
    ){
        //调用service分页查询
        Map<String,Object> pageResult = clazzService.pageList(name,begin,end,page,pageSize);
        return Result.success(pageResult);
    }

    /**
     * 根据id查询班级 GET /clazzs/{id}
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Clazz clazz = clazzService.getById(id);
        return Result.success(clazz);
    }

    /**
     * 新增班级 POST /clazzs
     */
    @PostMapping
    public Result add(@RequestBody Clazz clazz){
        clazzService.add(clazz);
        return Result.success(null);
    }

    /**
     * 修改班级 PUT /clazzs
     */
    @PutMapping
    public Result update(@RequestBody Clazz clazz){
        clazzService.update(clazz);
        return Result.success(null);
    }

    /**
     * 删除班级 DELETE /clazzs/{id}
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        clazzService.delete(id);
        return Result.success(null);
    }

    /**
     * 查询所有班级（下拉框使用）GET /clazzs/list
     */
    @GetMapping("/list")
    public Result listAll(){
        List<Clazz> list = clazzService.listAll();
        return Result.success(list);
    }
}
