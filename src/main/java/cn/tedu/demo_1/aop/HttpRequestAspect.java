package cn.tedu.demo_1.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpRequestAspect {
    @Autowired
    private ServletContext servletContext;

    private static final Logger log = LoggerFactory.getLogger(HttpRequestAspect.class);

    public static long startTime;
    public static long endTime;

    /**
     * @Pointcut 横切点，表示哪些方法需要被横切
     * 下面是切点表达式
     */
    //@Around("execution(* cn.tedu.store.service.impl.*.*(..))")
    @Pointcut("execution(public * cn.tedu.demo_1.controller.HelloController.*(..))")
    //切点签名
    public void print(){
        System.out.println("切点签名 print");
    }

    /*@Before注解表示在具体的方法之前执行*/
    @Before("print()")
    public void before(JoinPoint joinPoint) {
        log.info("前置切面before……");
        startTime = System.currentTimeMillis();
        //获取request对象
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        String requestURI = request.getRequestURI();
        String remoteAddr = request.getRemoteAddr();   //这个方法取客户端ip"不够好"
        String requestMethod = request.getMethod();
        String declaringTypeName = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        log.info("请求url=" + requestURI + ",客户端ip=" + remoteAddr + ",请求方式=" + requestMethod + ",请求的类名=" + declaringTypeName + ",方法名=" + methodName + ",入参=" + args);

        //hello请求的访问次数
        Integer accessCount = (Integer) servletContext.getAttribute("accessCount");
        if(accessCount == null){
            servletContext.setAttribute("accessCount",1);
        }else{
            servletContext.setAttribute("accessCount",accessCount+1);
        }

    }

    /*@After注解表示在方法执行之后执行*/
    @After("print()")
    public void after() {
        endTime = System.currentTimeMillis() - startTime;
        log.info("后置切面after……");
    }

    /*@AfterReturning注解用于获取方法的返回值*/
    @AfterReturning(pointcut = "print()", returning = "object")
    public void getAfterReturn(Object object) {
        log.info("本次接口耗时={}ms", endTime); //日志输出{}占位符
        log.info("afterReturning={}", object.toString());
    }


}
