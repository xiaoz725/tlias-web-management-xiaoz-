package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.pojo.Student;
import org.example.pojo.StudentQueryParam;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {

    //原有方法
    List<Student> list(StudentQueryParam studentQueryParam);

    void insert(Student student);

    void deleteByIds(List<Integer> ids);

    Student getById(Integer id);

    void updateById(Student student);

    //====新增报表统计方法====
    /**
     * 统计各个班级学员人数
     */
    List<Map> countClazzStudentData();

    /**
     * 统计学员学历信息
     */
    List<Map> countStudentDegreeData();
}
