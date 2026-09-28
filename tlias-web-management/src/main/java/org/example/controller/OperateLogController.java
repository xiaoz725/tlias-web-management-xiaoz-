package org.example.controller;

import org.example.pojo.OperateLog;
import org.example.pojo.PageResult;
import org.example.pojo.Result;
import org.example.service.OperateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class OperateLogController {
    @Autowired
    private OperateLogService operateLogService;

    @GetMapping("/page")
    public Result page(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer pageSize
    ){
        PageResult<OperateLog> pageResult = operateLogService.page(page, pageSize);
        return Result.success(pageResult);
    }
}
