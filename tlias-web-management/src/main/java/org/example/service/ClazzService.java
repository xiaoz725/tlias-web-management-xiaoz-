package org.example.service;

import org.example.pojo.Clazz;
import java.util.List;
import java.util.Map;

public interface ClazzService {
    //分页条件查询班级
    Map<String,Object> pageList(String name, String begin, String end, Integer page, Integer pageSize);
    //根据id查询
    Clazz getById(Integer id);
    //新增
    void add(Clazz clazz);
    //修改
    void update(Clazz clazz);
    //删除
    void delete(Integer id);
    //查询全部班级（下拉）
    List<Clazz> listAll();
}
