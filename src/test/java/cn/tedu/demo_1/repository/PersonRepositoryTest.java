package cn.tedu.demo_1.repository;

import cn.tedu.demo_1.entity.Person;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonRepositoryTest {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void  saveTest(){
        personRepository.save(new Person("zhangsan","21","1"));
        personRepository.save(new Person("lisi","25","1"));
        personRepository.save(new Person("wangwu","28","2"));
    }

    @Test
    public void findAllTest(){
        Assert.assertEquals("28",userMapper.findAllOrderByAge().get(0).getAge());
    }
}
