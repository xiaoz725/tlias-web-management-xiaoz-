package org.example.service;

import org.example.pojo.PageResult;
import org.example.pojo.Student;
import org.example.pojo.StudentQueryParam;

import java.util.List;

public interface StudentService {

    /**
     * 分页条件查询学员
     */
    PageResult<Student> page(StudentQueryParam studentQueryParam);

    /**
     * 新增学员
     */
    void save(Student student);

    /**
     * 批量删除学员
     */
    void delete(List<Integer> ids);

    /**
     * 根据ID查询学员详情
     */
    Student getInfo(Integer id);

    /**
     * 修改学员
     */
    void update(Student student);
}
