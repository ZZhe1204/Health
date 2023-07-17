package com.java.contoller;

import com.alibaba.fastjson.JSON;
import com.java.dao.UserDao;
import com.java.pojo.QueryInfo;
import com.java.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@RestController
public class UserController {
    
    @Autowired
    private UserDao userDao;

    @CrossOrigin
    @RequestMapping("/allUser")
    public String getUserList(QueryInfo queryInfo){
        int numbers = userDao.getUserCounts("%"+queryInfo.getQuery()+"%");// 获取数据总数
        int pageStart = (queryInfo.getPageNum()-1)*queryInfo.getPageSize();
        List<User> users = userDao.getAllUser("%"+queryInfo.getQuery()+"%",pageStart,queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("numbers",numbers);
        res.put("data",users);
        String users_json = JSON.toJSONString(res);
        return users_json;
    }

    @RequestMapping("/userState")
    public String updateUserState(@RequestParam("id") Integer  id,
                                  @RequestParam("state") Boolean state){
        int i = userDao.updateState(id, state);
        String str = i >0?"success":"error";
        return str;
    }

    @RequestMapping("/addUser")
    public String addUser(@RequestBody User user){
        user.setRole("普通用户");
        user.setState(false);
        int i = userDao.addUser(user);
        String str = i >0?"success":"error";
        return str;
    }

    @RequestMapping("/getUpdate")
    public String getUpdateUser(int id){
        User updateUser = userDao.getUpdateUser(id);
        String users_json = JSON.toJSONString(updateUser);
        return users_json;
    }

    @RequestMapping("/editUser")
    public String editUser(@RequestBody User user){
        int i = userDao.editUser(user);
        String str = i >0?"success":"error";
        return str;
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(int id){
        int i = userDao.deleteUser(id);
        String str = i >0?"success":"error";
        return str;
    }
}
