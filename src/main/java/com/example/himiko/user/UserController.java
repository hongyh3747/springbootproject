package com.example.himiko.user;

import com.example.himiko.dao.UserDao;
import com.example.himiko.pojo.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private static final Logger log= LoggerFactory.getLogger(UserController.class);

    @Resource(name="userDao")
    private UserDao userDao;

    @GetMapping("/delete")
    public String deleteUserById(@RequestParam String userId){
        System.out.println("删除用户"+userId);
        log.info("delete user");
        userDao.deleteUserById(userId);
        return "redirect:/users/getAll";
    }

    @PostMapping("/addUser")
    public String addUsers(UserInfo userInfo){
        log.info("新增用户");
        System.out.println("开始新增用户");
        userDao.addUser(userInfo);
        return "redirect:/users/getAll";
    }

    @GetMapping("/form")
    public String addUser(){
        return "addUser";
    }

    @GetMapping(value = "/hello")
    public String hello(){
        return "index";
    }

    @GetMapping(value = "/getAll")
    public String getAllUsers(Model model){
        List<UserInfo> users = userDao.findUserAll();
        model.addAttribute("userList",users);
        model.addAttribute("title","用户管理");
        return "index";
    }

    @GetMapping(value = "/list")
    public String userList(Model model){
        List<UserInfo> list = new ArrayList<>();
        UserInfo userInfo=new UserInfo();
        userInfo.setUserId(1);
        userInfo.setUserName("lina");
        userInfo.setPhone("123456");
        userInfo.setSex("men");
        list.add(userInfo);
        UserInfo userInfo2=new UserInfo();
        userInfo2.setUserId(2);
        userInfo2.setUserName("axe");
        userInfo2.setPhone("777777");
        userInfo2.setSex("women");
        list.add(userInfo2);
//        System.out.println(list);
        model.addAttribute("userList",list);
        model.addAttribute("title","用户管理");
        return "index";
    }
}
