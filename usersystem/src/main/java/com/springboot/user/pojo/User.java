package com.springboot.user.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author 飞鸟
 * @create 2019-11-21 14:31
 */
@Data
@Table(name = "tb_user")
public class User {
    @Id//指定主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//指定自增策略
    private Integer id;

    private String userName;

    private String password;
    private String name;
    private Integer age;
    private Integer sex;
    private Date birthday;
    private Date created;
    private Date updated;
    private String note;
    private Integer depId;

    @Transient
    private String depName;
}
