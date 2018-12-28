package cn.tedu.demo_1.config;

import cn.tedu.demo_1.fileter.UserLoginFileter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置过滤器
 */
@Configuration
public class WebFilterConfig {
    @Bean
    public FilterRegistrationBean FilterRegistrationBean(){
        //新建过滤器注册类
        FilterRegistrationBean registration = new FilterRegistrationBean();
        //添加写好的过滤器
        registration.setFilter(new UserLoginFileter());
        //设置过滤器的URL模式
        registration.addUrlPatterns("/*");
        //设置过滤器顺序(值越小执行优先级越高)
        registration.setOrder(1);
        //返回过滤器注册类
        return registration;
    }
}
