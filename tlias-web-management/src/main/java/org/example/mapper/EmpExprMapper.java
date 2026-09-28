package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.pojo.EmpExpr;

import java.util.List;

/**
 * 员工工作经历
 */
@Mapper
public interface EmpExprMapper {
    /**
     * 批量保存员工的工作经历信息
     */
    void insertBatch(List<EmpExpr> exprList);

    /**
     * 根据员工ID批量删除员工工作经历
     */
    void deleteByEmpIds(List<Integer> empIds);
}
