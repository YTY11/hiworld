package com.springbootweb1.demo.entity;

import lombok.Data;

/**
 * @author Yang TanYing
 * @Description:
 * @create 2020-11-28 8:33
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String password;
    private String phone;
}
