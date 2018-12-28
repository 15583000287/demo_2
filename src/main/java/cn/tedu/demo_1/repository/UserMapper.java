package cn.tedu.demo_1.repository;

import cn.tedu.demo_1.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//@Mapper
public interface UserMapper {
    @Select("select * from user")
    List<User> findAll();

    @Select("select * from user where username=#{value}")
    List<User> findByUserName(String username);
}
