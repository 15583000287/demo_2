package cn.tedu.demo_1.service;

import cn.tedu.demo_1.entity.User;

import java.util.List;

public interface IUserService{
    List<User> findAllUser();

    List<User> findByUsername(String username);
}
