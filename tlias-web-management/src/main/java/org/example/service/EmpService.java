package org.example.service;

import org.example.pojo.Emp;
import org.example.pojo.EmpQueryParam;
import org.example.pojo.LoginInfo;
import org.example.pojo.PageResult;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    /**
     * 分页查询
     */
    PageResult<Emp> page(EmpQueryParam empQueryParam);

    /**
     * 新增员工
     */
    void save(Emp emp);


    /**
     * 批量删除员工信息
     */
    void delete(List<Integer> ids);

    /**
     * 根据ID查询员工信息
     */
    Emp getInfo(Integer id);


    /**
     * 更新员工信息
     */
    void update(Emp emp);

    /**
     * 登录
     */
    LoginInfo login(Emp emp);
}
