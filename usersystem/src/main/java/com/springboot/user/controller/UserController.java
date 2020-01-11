package com.springboot.user.controller;

import com.springboot.user.pojo.Dep;
import com.springboot.user.pojo.User;
import com.springboot.user.service.DepService;
import com.springboot.user.service.UserService;
import com.springboot.user.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

/**
 * @author 飞鸟
 * @create 2019-11-26 9:27
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private DepService depService;

    @GetMapping("/list")
    public String list(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size, @RequestParam(value = "keyword", defaultValue = "") String keyword, ModelMap map) {
        //对keyword进行转码
        try {
            keyword = URLDecoder.decode(keyword, "utf-8");
            System.out.println(keyword);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Page<User> pages = userService.list2(page, size, keyword);
        map.put("pages", pages);
        map.put("keyword", keyword);
        return "list";
    }

    @DeleteMapping("/delete")
    public String delete(Integer id){
        userService.delete(id);
        return "redirect:/user/list";
    }

    @GetMapping("/add")
    public String add(ModelMap map){
        //查询所有部门
        List<Dep> list = depService.list();
        map.put("depts", list);
        map.put("url", "/user/save");
        return "saveOrUpdate";
    }

    @PostMapping("/save")
    public String save(User user){
        userService.saveOrUpdate(user);
        return "redirect:/user/list";
    }

    @GetMapping("/edit")
    public String edit(Integer id, ModelMap map){
        //查询用户信息
        User user = userService.get(id);

        //查询所有部门
        List<Dep> list = depService.list();
        map.put("url","/user/update");
        map.put("depts", list);
        map.put("user", user);

        return "saveOrUpdate";
    }

    @PutMapping("/update")
    public String update(User user){
        //修改用户信息
        userService.saveOrUpdate(user);
        return "redirect:/user/list";
    }
}
