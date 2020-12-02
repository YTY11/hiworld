package com.springbootweb1.demo.service.impl;

import com.springbootweb1.demo.entity.User;
import com.springbootweb1.demo.mapper.UserMapper;
import com.springbootweb1.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Yang TanYing
 * @Description:
 * @create 2020-11-28 9:19
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public List<User> findList() {
        return userMapper.findList();
    }

    @Override
    public boolean update(User user) {
        return userMapper.update(user);
    }

    @Override
    public boolean delete(int id) {
        return userMapper.delete(id);
    }

    @Override
    public boolean add(User user) {
        return userMapper.add(user);
    }

    @Override
    public User findById(int id) {
        return userMapper.findById(id);
    }

    @Override
    public User userLogin(String name,String password) {
        return userMapper.userLogin(name,password);
    }

    @Override
    public boolean userRegister(String name, String password) {
        return userMapper.userRegister(name,password);
    }

    @Override
    public User userCheck(String name) {
        return userMapper.userCheck(name);
    }
}
