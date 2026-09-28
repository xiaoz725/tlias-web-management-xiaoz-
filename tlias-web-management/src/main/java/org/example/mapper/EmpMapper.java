package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.pojo.Emp;
import org.example.pojo.EmpQueryParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * 员工信息
 */
@Mapper
public interface EmpMapper {

    //----------------原始分页查询实现----------------------
    /**
     * 查询总记录数
     */
    //@Select("select count(*) from emp e left join dept d on e.dept_id = d.id ")
    //public Long count();

    /**
     * 查询所有的员工及其对应的部门名称
     */
    //@Select("select e.*, d.name deptName from emp as e left join dept as d on e.dept_id = d.id limit #{start}, #{pageSize}")
    //public List<Emp> list(Integer start , Integer pageSize);

    //@Select("select e.*, d.name deptName from emp as e left join dept as d on e.dept_id = d.id order by e.update_time desc")
    //public List<Emp> list(String name, Integer gender, LocalDate begin, LocalDate end);

    /**
     *条件查询员工信息的方法
     */
    public List<Emp> list(EmpQueryParam empQueryParam);

    /**
     * 新增员工数据
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time) " +
            "values (#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);

    /**
     * 根据ID批量删除员工的基本信息
     */
    void deleteByIds(List<Integer> ids);

    /**
     * 根据ID查询员工的详细信息
     */
    Emp getById(Integer id);

    /**
     * 更新员工基本信息
     */
    void updateById(Emp emp);

    /**
     * 统计各个职位的员工人数
     */
    @MapKey("pos")
    List<Map<String,Object>> countEmpJobData();

    /**
     * 统计员工性别信息
     */
    @MapKey("name")
    List<Map> countEmpGenderData();

    /**
     * 根据用户名和密码查询员工信息
     */
    @Select("select id,username,name from emp where username = #{username} and password = #{password}")
    Emp selectUsernameAndPassword(Emp emp);
}
