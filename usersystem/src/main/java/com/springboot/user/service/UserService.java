package com.springboot.user.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.user.mapper.UserMapper;
import com.springboot.user.pojo.User;
import com.springboot.user.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author 飞鸟
 * @create 2019-11-26 9:09
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User get(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }


    //增加 or 修改
    public User saveOrUpdate(User user) {
        if (user != null) {
            if (user.getId() != null) {
                userMapper.updateByPrimaryKeySelective(user);
            } else {
                userMapper.insertSelective(user);
            }
        }
        return user;
    }

    //删除
    public boolean delete(Integer id) {
        return userMapper.deleteByPrimaryKey(id) > 0;
    }

    //查询
    public Page list(int currentPage, int size, String keywords) {
        PageHelper.startPage(currentPage, size);
        //设置查询条件
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("name", "%" + keywords + "%");
        List<User> list = userMapper.selectByExample(example);//Page

        //获取分页信息
        PageInfo<User> pageInfo = new PageInfo<>(list);

        Page<User> page = new Page<>();
        page.setDatas(list);
        page.setCurrentPage(currentPage);
        page.setTotalNum(pageInfo.getTotal());
        page.setTotalPage(pageInfo.getPages());
        page.setSize(size);
        return page;
    }

    //查询
    public Page list2(int currentPage, int size, String keywords) {
        PageHelper.startPage(currentPage, size);
        List<User> list = userMapper.list(keywords);

        list.stream().forEach(System.out::println);

        //获取分页信息
        PageInfo<User> pageInfo = new PageInfo<>(list);

        Page<User> page = new Page<>();
        page.setDatas(list);
        page.setCurrentPage(currentPage);
        page.setTotalNum(pageInfo.getTotal());
        page.setTotalPage(pageInfo.getPages());
        page.setSize(size);
        return page;
    }
}
