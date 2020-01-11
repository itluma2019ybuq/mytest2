package com.springboot.user.mapper;

import com.springboot.user.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author 飞鸟
 * @create 2019-11-26 9:08
 */
public interface UserMapper extends Mapper<User> {

    @Select("SELECT u.*, d.dep_name from tb_user u INNER JOIN tb_dep d ON u.dep_id = d.id WHERE u.name LIKE '%${keyword}%' or u.name is null ORDER BY u.id ASC")
    public List<User> list(@Param("keyword") String keyword);
}
