package com.springbootweb1.demo.service;

import com.springbootweb1.demo.entity.User;

import java.util.List;

/**
 * @author Yang TanYing
 * @Description:
 * @create 2020-11-28 9:15
 */
public interface UserService {
    //查询所有
    public List<User> findList();

    //更新
    public boolean update(User user);

    //删除
    public boolean delete(int id);

    //添加
    public boolean add(User user);

    //根据id查询
    public User findById(int id);

    //用户登陆
    public User userLogin(String name,String password);

    //用户注册
    public boolean userRegister(String name,String password);

    //用户名校验
    public User userCheck(String name);

}
