package cn.tedu.demo_1.controller;

import cn.tedu.demo_1.config.entity.CustomConfig;
import cn.tedu.demo_1.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloController {
    @Autowired
    private CustomConfig customConfig;

    @Autowired
    private ServletContext servletContext;


    @GetMapping("/hello")
    public  String  hello(){
        //System.out.println("自定义property: "+customConfig.getUsername()+","+customConfig.getPassword());
        //统计访问次数
        //ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //HttpServletRequest request = requestAttributes.getRequest();
        Integer accessCount = (Integer) servletContext.getAttribute("accessCount");
        return "Hello  Spring  Boot !  "+ accessCount;
    }

    @GetMapping("/zero")
    public Result<Void> zero(){
        System.out.print(3/0);
        return new Result<Void>(1,"success");
    }
}
