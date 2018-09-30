package com.winter.service;

import com.github.pagehelper.PageHelper;
import com.winter.mapper.UserMapper;
import com.winter.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userService")
public class UserService {
    @Autowired
    UserMapper userMapper;

    public int delByUserId(User user){
        return userMapper.deleteByPrimaryKey(user.getUserId());
    }

    public int addUser(User user){
        return userMapper.insert(user);
    }

    public int addUserSelective(User user){
        return userMapper.insertSelective(user);
    }

    public int updateUserById(User user){
        return userMapper.updateByPrimaryKey(user);
    }

    public int updateUserByIdSelective(User user){
        return userMapper.updateByPrimaryKeySelective(user);
    }

    public User getUserByUserId(Integer userId){
        return userMapper.selectByPrimaryKey(userId);
    }

    public List<User> getUserList(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.selectUserList();
    }
}
