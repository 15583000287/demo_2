package cn.tedu.demo_1.fileter;
import cn.tedu.demo_1.config.entity.CustomConfig;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter(filterName = "UserLoginFilter",urlPatterns = {"/*"})
public class UserLoginFileter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter");
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        HttpSession session = request.getSession();
        //跳过过滤器
        session.setAttribute("username","root");
        if(session.getAttribute("username")  != null){
            //放行
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        //response.sendRedirect("xxx"); 重定向
        session.setAttribute("username","root");
    }

    @Override
    public void destroy() {
        System.out.println("destory");
    }
}
