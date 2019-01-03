package cn.tedu.demo_1.repository;

import cn.tedu.demo_1.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.INITIALIZE;
import org.omg.CORBA.ORB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMapperTest {
    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void findAllTest(){
        List<Order> orders = orderMapper.findAll();
        for(Order order: orders){
            System.out.println(order);
        }
    }

    @Test
    public void findByLimitTest(){
        List<Order> orders = orderMapper.findByLimit(1,2);
        for(Order order: orders){
            System.out.println(order);
        }
    }

    @Test
    public void insertTset(){
        Order order = new Order("1005","3333");
        Integer rows = orderMapper.insert(order);
        System.out.println(rows);
    }

    @Test
    public void findByIdTest(){
        Order order = orderMapper.findById(1);
        System.out.println(order);
    }
}
