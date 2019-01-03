package cn.tedu.demo_1.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * SpringBoot整合Listener
 * 不需要设置注解属性值，因为在传统xml中也只是配置
 * <listener>
 *     <listener-class>listener类完全限定名</listener-class>
 * </listener>
 */
//@WebListener
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("MyListtener ... init ....");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("MyListener...Destoryed....");
    }
}
