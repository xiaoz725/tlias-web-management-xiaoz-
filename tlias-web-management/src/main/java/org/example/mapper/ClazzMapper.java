package org.example.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.pojo.Clazz;
import java.util.List;

public interface ClazzMapper {
    //分页查询
    List<Clazz> selectPage(@Param("name") String name,
                           @Param("begin") String begin,
                           @Param("end") String end,
                           @Param("start") Integer start,
                           @Param("pageSize") Integer pageSize);
    //统计总条数
    Long count(@Param("name") String name,
               @Param("begin") String begin,
               @Param("end") String end);

    Clazz selectById(Integer id);
    void insert(Clazz clazz);
    void update(Clazz clazz);
    void delete(Integer id);
    List<Clazz> selectAll();
}
