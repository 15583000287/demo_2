package cn.tedu.demo_1.repository;


import cn.tedu.demo_1.entity.Order;
import cn.tedu.demo_1.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.aspectj.weaver.ast.Or;

import java.util.List;

public interface OrderMapper {
    @Select("select * from t_order")
//    @Results({
//        @Result(property = "orderNO", column = "order_no"),  配置实体属性与数据库字段映射
//        @Result(property = "orderPrice", column = "order_price")
//    })
    List<Order> findAll();

    @Select("select * from t_order limit ${startIndex},${offSet}")   //$()中名字与参数名一致
    List<Order> findByLimit(Integer startIndex, Integer offSet);

    @Insert("insert into t_order(order_no,order_price) values(#{orderNO},#{orderPrice})")
    Integer insert(Order order);

    //xml配置
    Order findById(Integer id);
}
