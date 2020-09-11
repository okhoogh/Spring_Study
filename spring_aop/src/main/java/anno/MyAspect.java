package anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect     // 标注当前MyAspect类是切面类
public class MyAspect {

    // 定义切点表达式
    @Pointcut("execution(* anno.*.*(..))")
    public void pCut() {}

    // 配置前置通知
    @Before("pCut()")
    public void before() {
        System.out.println("前置增强...");
    }

    @AfterReturning("pCut()")
    public void afterRunning() {
        System.out.println("后置增强...");
    }

    // Proceeding JoinPoint 正在执行的连接点
    @Around("pCut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前增强...");
        Object proceed = pjp.proceed();// 切点方法
        System.out.println("环绕后增强...");
        return proceed;
    }

    @AfterThrowing("pCut()")
    public void afterThrowing() {
        System.out.println("异常抛出增强...");
    }

    @After("pCut()")
    public void after() {
        System.out.println("最终增强...");
    }
}
