package cn.tedu.demo_1.interceptor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置类
 */
@SpringBootConfiguration
public class MySpringMvcConfig implements WebMvcConfigurer {
    @Autowired
    private TestInterceptor testInterceptor; //拦截器对象

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // registry.addInterceptor(testInterceptor).addPathPatterns("/hello"); //黑名单
        //registry.addInterceptor(testInterceptor).excludePathPatterns("/zero"); //白名单
    }


}
