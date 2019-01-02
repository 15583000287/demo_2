package cn.tedu.demo_1.repository;

import cn.tedu.demo_1.entity.Person;
import cn.tedu.demo_1.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * MyBatis
 */

public interface UserMapper {
    @Select("select * from user")
    List<User> findAll();

    @Select("select * from user where username=#{value}")
    List<User> findByUserName(String username);

    @Select("select * from t_person order by age desc")
    List<Person> findAllOrderByAge();
}
