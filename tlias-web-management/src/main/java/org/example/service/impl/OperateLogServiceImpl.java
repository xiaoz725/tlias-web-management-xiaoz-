package org.example.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.mapper.OperateLogMapper;
import org.example.pojo.OperateLog;
import org.example.pojo.PageResult;
import org.example.service.OperateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperateLogServiceImpl implements OperateLogService {

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Override
    public PageResult<OperateLog> page(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<OperateLog> logList = operateLogMapper.selectLogPage();
        PageInfo<OperateLog> pageInfo = new PageInfo<>(logList);
        return new PageResult<>(pageInfo.getTotal(), logList);
    }
}
