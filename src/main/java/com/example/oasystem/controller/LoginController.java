package com.example.oasystem.controller;

import com.alibaba.fastjson.JSON;
import com.example.oasystem.bean.User;
import com.example.oasystem.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class LoginController {

    @Autowired
    UserDao userDao;

    @RequestMapping("/login")
    public String login(@RequestBody User user){
        String flag = "error";
        User us = userDao.getUserByMessage(user.getUsername(), user.getPassword());
        HashMap<String, Object> res = new HashMap<>();
        if (us!=null){
            flag = "ok";
        }
        res.put("flag",flag);
        res.put("user",us);
        String res_json = JSON.toJSONString(res);
        return res_json;
    }
}
