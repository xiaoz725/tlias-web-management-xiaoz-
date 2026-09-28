package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.pojo.JobOption;
import org.example.pojo.Result;
import org.example.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/report")
@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    /**
     * 统计各个职位的员工人数
     */
    @GetMapping("/empJobData")
    public Result getEmpJobData(){
        log.info("统计各个职位的员工人数");
        JobOption jobOption = reportService.getEmpJobData();
        return Result.success(jobOption);
    }

    /**
     * 统计员工性别信息
     */
    @GetMapping("/empGenderData")
    public Result getEmpGenderData(){
        log.info("统计员工性别信息");
        List<Map> genderList = reportService.getEmpGenderData();
        return Result.success(genderList);
    }

    /**
     * 统计班级学员人数（柱状图，返回JobOption）
     */
    @GetMapping("/studentCountData")
    public Result getClazzStudentData(){
        log.info("统计班级学员人数");
        JobOption jobOption = reportService.getClazzStudentData();
        return Result.success(jobOption);
    }

    /**
     * 统计学员学历信息（饼图，返回List<Map>）
     */
    @GetMapping("/studentDegreeData")
    public Result getStudentDegreeData(){
        log.info("统计学员学历信息");
        List<Map> degreeList = reportService.getStudentDegreeData();
        return Result.success(degreeList);
    }

}
