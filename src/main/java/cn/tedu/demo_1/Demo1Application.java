package cn.tedu.demo_1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Spring核心注解，开启自动配置
//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) //启动类中配置数据源，也可以在properties中配置
@SpringBootApplication
@RestController
@MapperScan(basePackages = "cn.tedu.demo_1.repository")
//@ServletComponentScan
public class Demo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }
    @RequestMapping(value="/")
    public String index(){
        return "Hello Spring Boot! 嘻嘻xi！";
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }

}

