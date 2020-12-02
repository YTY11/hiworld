package com.springbootweb1.demo.controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springbootweb1.demo.entity.User;
import com.springbootweb1.demo.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Yang TanYing
 * @Description:
 * @create 2020-11-28 9:21
 */
@Controller
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/index")
    public String index(Model model, @RequestParam(value = "start", defaultValue = "1") int start){
        PageHelper.startPage(start,5);
        List<User> userlist = userService.findList();
        PageInfo<User> list = new PageInfo<>(userlist);
        model.addAttribute("userList",list);
        return "index";
    }
    @RequestMapping("/update/{id}")
    public String update(Model model, @PathVariable int id){
        User user = userService.findById(id);
        if(user != null){
            model.addAttribute("user",user);
            return "update";
        }
        model.addAttribute("err","没找到！");
        return "err";
    }
    @RequestMapping("/update")
    public String update(HttpServletRequest request, User user){
        System.out.println(user);
        boolean update = userService.update(user);
        if(update){

            return "redirect:index";
        }
        else{

            return "index";
        }
    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id,HttpServletResponse response) throws Exception{
        boolean delete = userService.delete(id);
        if(delete){

            response.sendRedirect("/index");
            return null;
        }

        return "redirect:index";
    }
    @RequestMapping("/saveUser")
    public String saveUser(User user){
        boolean add = userService.add(user);
        return "redirect:index";
    }
    @RequestMapping("/add")
    public String addUser(){
        return "add";
    }

    @RequestMapping("/userLogin")
    public String userLogin(HttpServletRequest request,HttpServletResponse response) throws Exception{
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        User user = userService.userLogin(name, password);
        if(user != null){
            response.sendRedirect("/index");
        }
        return "register";
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/userRegister")
    public String userRegister(HttpServletRequest request,HttpServletResponse response,Model model) throws IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        boolean b = userService.userRegister(name, password);
        if(b){
            response.sendRedirect("/login");
        }
        model.addAttribute("err","注册失败！");
        return "err";
    }
    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    @RequestMapping("/check")
    public void check(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String name = request.getParameter("username");
        User user = userService.userCheck(name);
        System.out.println(user);
        if (user == null){
            response.getWriter().write("true");
        }else{
            response.getWriter().write("false");
        }
        
    }

}
