package cn.tedu.demo_1.repository;

import cn.tedu.demo_1.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void findAllTest(){
        List<User> users = userMapper.findAll();
        for(User user : users){
            System.err.println(user);
        }
    }
}
