package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.pojo.Dept;

import java.util.List;

@Mapper
public interface DeptMapper {
    @Select("select id, name, create_time, update_time from dept order by update_time desc;")
    public List<Dept> findAll();

    /**
     * *根据ID删除部门
     */
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    /**
     * *新增部门
     */
    @Insert("insert into dept(name, create_time, update_time) values(#{name},#{createTime},#{updateTime}) ")
    void insert(Dept dept);

    /**
     * 根据ID查询部门
     */
    @Select("select id, name, create_time, update_time from dept where id = #{id}")
    Dept getById(Integer id);

    /**
     * 更新部门
     */
    @Update("update dept set name = #{name},update_time = #{updateTime} where id =#{id};")
    void update(Dept dept);
}