package cn.ixinjiu.spring_aop.anno;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by XinChen on 2022/8/22
 *
 * @Description : TODO  切面类
 */
@Component
@Aspect // 切面类
public class MyAspect {
    @Before("execution(* cn.ixinjiu.spring_aop.anno.*.*(..))")
    public void before(){
        System.out.println("MyAspect -> before()...");
    }

    @After("execution(public * *(..))")
    public void after(){
        System.out.println("MyAspect -> after()...");
    }

//    @Around("execution(* cn.ixinjiu.spring_aop.anno.*.*(..))")
    public void around(){
        System.out.println("MyAspect -> around()...");
    }

    @AfterThrowing("execution(* cn.ixinjiu.spring_aop.anno.*.*(..))")
    public void throwing(){
        System.out.println("MyAspect -> throwing()...");
    }

    @After("execution(public * save(..))")
    public void end(){
        System.out.println("MyAspect -> end()...");
    }
}
