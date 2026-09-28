package org.example.service.impl;

import org.example.mapper.ClazzMapper;
import org.example.pojo.Clazz;
import org.example.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;

    @Override
    public Map<String, Object> pageList(String name, String begin, String end, Integer page, Integer pageSize) {
        //MyBatis分页，先设置分页参数
        int start = (page - 1) * pageSize;
        List<Clazz> rows = clazzMapper.selectPage(name,begin,end,start,pageSize);
        Long total = clazzMapper.count(name,begin,end);

        Map<String,Object> map = new HashMap<>();
        map.put("total",total);
        map.put("rows",rows);
        return map;
    }

    @Override
    public Clazz getById(Integer id) {
        return clazzMapper.selectById(id);
    }

    @Override
    public void add(Clazz clazz) {
        clazzMapper.insert(clazz);
    }

    @Override
    public void update(Clazz clazz) {
        clazzMapper.update(clazz);
    }

    @Override
    public void delete(Integer id) {
        clazzMapper.delete(id);
    }

    @Override
    public List<Clazz> listAll() {
        return clazzMapper.selectAll();
    }
}
