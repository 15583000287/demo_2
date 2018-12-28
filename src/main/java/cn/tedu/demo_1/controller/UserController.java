package cn.tedu.demo_1.controller;

import cn.tedu.demo_1.entity.User;
import cn.tedu.demo_1.service.IUserService;
import cn.tedu.demo_1.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("find_user")
    public Result<List<User>> findAllUser(){
       Result<List<User>> result = new Result<List<User>>(1,"成功");
       result.setData(userService.findAllUser());
       return  result;
    }

    @GetMapping("find_by_username")
    public Result<List<User>> findByUsername(@RequestParam("username") String username){
        Result<List<User>> result = new Result<List<User>>(1,"成功");
        result.setData(userService.findByUsername(username));
        return  result;
    }

    @GetMapping("login")
    public Result<Void> login(@RequestParam("username") String username,@RequestParam("password")String password,HttpServletRequest request){
        System.out.println("登录！");
        if("root".equals("root") && "123".equals(password)){
            HttpSession session = request.getSession();
            session.setAttribute("username","root");
            return new Result<Void>(1,"login success !");
        }
        return  new Result<Void>(1,"login faild !");
    }


}
