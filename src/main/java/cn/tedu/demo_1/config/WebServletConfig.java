package cn.tedu.demo_1.config;

import cn.tedu.demo_1.servlet.HelloServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebServletConfig {
    @Bean
    public ServletRegistrationBean getServletRegistrationBean(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new HelloServlet());
        bean.addUrlMappings("/helloworld"); //相当于urlPatterns = "/helloworld"
        return bean;
    }
}
