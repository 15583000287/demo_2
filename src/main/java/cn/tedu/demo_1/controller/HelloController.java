package cn.tedu.demo_1.controller;

import cn.tedu.demo_1.config.entity.CustomConfig;
import cn.tedu.demo_1.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private CustomConfig customConfig;


    @GetMapping("/hello")
    public  String  hello(){
        System.out.println("自定义property: "+customConfig.getUsername()+","+customConfig.getPassword());
        System.out.print("进来了！");
        return "Hello  Spring  Boot !";
    }

    @GetMapping("/zero")
    public Result<Void> zero(){
        System.out.print(3/0);
        return new Result<Void>(1,"success");
    }
}
