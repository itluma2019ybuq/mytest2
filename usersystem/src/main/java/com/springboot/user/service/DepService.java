package com.springboot.user.service;

import com.springboot.user.mapper.DepMapper;
import com.springboot.user.pojo.Dep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 飞鸟
 * @create 2019-11-26 10:43
 */
@Service
public class DepService {
    @Autowired
    private DepMapper depMapper;

    public List<Dep> list(){
        return depMapper.selectAll();
    }
}
