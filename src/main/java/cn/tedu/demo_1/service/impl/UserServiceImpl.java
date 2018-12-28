package cn.tedu.demo_1.service.impl;

import cn.tedu.demo_1.entity.User;
import cn.tedu.demo_1.repository.UserMapper;
import cn.tedu.demo_1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements IUserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> findAllUser() {
        return userMapper.findAll();
    }

    @Override
    public List<User> findByUsername(String username){
        return userMapper.findByUserName(username);
    }
}
