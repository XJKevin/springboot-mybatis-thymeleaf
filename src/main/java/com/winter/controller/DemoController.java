package com.winter.controller;

import com.winter.model.User;
import com.winter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class DemoController {

    @Autowired
    private UserService userService;

    @RequestMapping("")
    public String home(@RequestParam Integer pageNum, @RequestParam Integer pageSize, Model model){
        List<User> userList = userService.getUserList(pageNum, pageSize);
        model.addAttribute("userList", userList);
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public String register(User user){
        userService.addUser(user);
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "get-user-list", produces = {"application/json;charset=UTF-8"})
    public List<User> getUserList(Integer pageNum, Integer pageSize){
        return userService.getUserList(pageNum, pageSize);
    }
}
