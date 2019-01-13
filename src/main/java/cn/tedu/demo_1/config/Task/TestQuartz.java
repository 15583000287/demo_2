package cn.tedu.demo_1.config.Task;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * 自定义TestQuartz类实现定时任务
 */
public class TestQuartz extends QuartzJobBean {

    /**
     * 执行定时器任务
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Quartz Tast  " + new Date());
    }
}
