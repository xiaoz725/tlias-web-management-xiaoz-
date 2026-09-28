package org.example.service;

import org.example.pojo.OperateLog;
import org.example.pojo.PageResult;

public interface OperateLogService {
    PageResult<OperateLog> page(Integer page, Integer pageSize);
}
