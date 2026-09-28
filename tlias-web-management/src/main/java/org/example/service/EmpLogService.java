package org.example.service;

import org.example.pojo.EmpLog;

public interface EmpLogService {
    //记录新增员工日志
    public void insertLog(EmpLog empLog);
}