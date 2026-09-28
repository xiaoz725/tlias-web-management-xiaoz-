package org.example.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.example.mapper.StudentMapper;
import org.example.pojo.PageResult;
import org.example.pojo.Student;
import org.example.pojo.StudentQueryParam;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    /**
     * PageHelper分页查询学员
     */
    @Override
    public PageResult<Student> page(StudentQueryParam studentQueryParam) {
        //1.开启分页
        PageHelper.startPage(studentQueryParam.getPage(), studentQueryParam.getPageSize());
        //2.执行查询
        List<Student> studentList = studentMapper.list(studentQueryParam);
        Page<Student> p = (Page<Student>) studentList;
        //3.封装分页结果
        return new PageResult<>(p.getTotal(), p.getResult());
    }

    /**
     * 新增学员
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void save(Student student) {
        //补全创建时间、更新时间
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.insert(student);
    }

    /**
     * 批量删除学员
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(List<Integer> ids) {
        studentMapper.deleteByIds(ids);
    }

    /**
     * 根据id查询学员详情
     */
    @Override
    public Student getInfo(Integer id) {
        return studentMapper.getById(id);
    }

    /**
     * 修改学员信息
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(Student student) {
        //更新修改时间
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.updateById(student);
    }
}
