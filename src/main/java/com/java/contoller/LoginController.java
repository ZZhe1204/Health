package com.java.contoller;

import com.alibaba.fastjson.JSON;
import com.java.dao.UserDao;
import com.java.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private UserDao userDao;

    @CrossOrigin
    @RequestMapping("/login")
    public String userLogin(@RequestBody User user) {
        String str = "error";
        int count = userDao.getUserByMassage(user.getUsername(), user.getPassword());
        if (count > 0) {
            str = "ok";
        }
        return str;
    }
}
