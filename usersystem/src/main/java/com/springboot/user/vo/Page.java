package com.springboot.user.vo;

import lombok.Data;

import java.util.List;

/**
 * @author 飞鸟
 * @create 2019-11-26 9:12
 */
@Data
public class Page<T> {
    //当前页的数据
    private List<T> datas;

    //总页数
    private Integer totalPage;

    //总记录数
    private Long totalNum;

    //当前页
    private Integer currentPage;

    //每页的大小
    private Integer size;
}
