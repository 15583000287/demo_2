package cn.tedu.demo_1.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


@Configuration
@EnableScheduling
@Async //支持异步(需要自己配置)
public class SchedulingConfig {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    //@Scheduled(cron = "0 0/10 * * * ?") // 每10分钟执行一次
    @Scheduled(fixedRate = 200)
    public void getToken() {
        logger.info("getToken定时任务启动》》》》》》1");
    }

    @Scheduled(fixedRate = 200)
    public void otherToken() {
        logger.info("otherToken定时任务启动》》》》》2");
    }

    @Scheduled(fixedRate = 200)
    public void otherToken2() {
        logger.info("otherToken定时任务启动》》》》》3");
       System.out.println("-------------------------------------------------------------------------------------------------------------------------");
    }
}
