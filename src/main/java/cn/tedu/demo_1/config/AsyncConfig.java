package cn.tedu.demo_1.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.validation.constraints.Max;
import java.util.concurrent.Executor;

/**
 * Spring Tast异步任务配置
 * 注： Tast类加上@Async注解 表明支持异步任务
 */
@Configuration //表明该类是一个配置类
@EnableAsync //开启异步任务的支持
public class AsyncConfig {
    /*
        此处成员变量应该使用@Value从配置中读取
    */
    @Value(value = "${asyncconfig.corepoolsize:5}") // "${asyncconfig.corepoolsize:10}" 设置默认值，没有在properties文件中设置属性则读取默认值
    private int corePoolSize;
    @Value("${asyncconfig.maxpoolsize:100}")
    private int maxPoolSize;
    @Value("${asyncconfig.queuecapacity:5}")
    private int queueCapacity;

    @Bean
    public Executor tastExecutor(){
        System.out.println(corePoolSize+","+maxPoolSize+"，"+queueCapacity);
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.initialize();
        return executor;
    }
}
