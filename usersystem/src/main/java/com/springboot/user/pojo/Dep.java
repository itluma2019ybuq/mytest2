package com.springboot.user.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 飞鸟
 * @create 2019-11-26 10:39
 */
@Data
@Table(name="tb_dep")
public class Dep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String depName;
}
