package com.springbootweb1.demo.mapper;

import com.springbootweb1.demo.entity.User;
import org.apache.ibatis.annotations.*;


import java.util.List;

/**
 * @author Yang TanYing
 * @Description:
 * @create 2020-11-28 9:05
 */
@Mapper
public interface UserMapper {
    //查询所有
    @Select("select * from tb_user")
    public List<User> findList();

    //跟新
    @Update("update tb_user set name=#{name},password=#{password},phone=#{phone} where id=#{id}")
    public boolean update(User uesr);

    //添加
    @Insert("insert into tb_user (name,password,phone) values(#{name},#{password},#{phone})")
    public boolean add(User user);

    //根据id删除
    @Delete("delete from tb_user where id=#{id}")
    public boolean delete(int id);

    //根据id查询
    @Select("select * from tb_user where id = #{id}")
    public User findById(int id);

    //用户登陆
    @Select("select * from tb_admin where name=#{name} and password=#{password}")
    public User userLogin(String name,String password);

    //用户注册
    @Insert("insert into tb_admin (name,password) values (#{name},#{password})")
    public boolean userRegister(String name,String password);

    //用户名校验
    @Select("select * from tb_admin where name = #{name}")
    public User userCheck(String name);


}
