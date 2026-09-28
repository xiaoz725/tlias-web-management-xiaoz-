package org.example.service.impl;

import org.example.mapper.EmpMapper;
import org.example.mapper.StudentMapper;
import org.example.pojo.JobOption;
import org.example.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;
    // 新增：注入StudentMapper
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public JobOption getEmpJobData() {
        List<Map<String,Object>> list = empMapper.countEmpJobData();
        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("total")).toList();
        return new JobOption(jobList, dataList);
    }

    @Override
    public List<Map> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }

    @Override
    public JobOption getClazzStudentData() {
        // 查询所有班级名称、人数，返回List<Map>
        List<Map> list = studentMapper.countClazzStudentData();
        // 取出班级名称放到jobList
        List<Object> jobList = list.stream().map(map -> map.get("name")).toList();
        // 取出人数放到dataList
        List<Object> dataList = list.stream().map(map -> map.get("value")).toList();
        // 封装JobOption返回
        return new JobOption(jobList, dataList);
    }

    @Override
    public List<Map> getStudentDegreeData() {
        return studentMapper.countStudentDegreeData();
    }

}