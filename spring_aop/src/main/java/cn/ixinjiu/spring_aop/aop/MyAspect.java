package cn.ixinjiu.spring_aop.aop;

/**
 * Created by XinChen on 2022/8/22
 *
 * @Description : TODO  切面类
 */
public class MyAspect {
    public void before(){
        System.out.println("MyAspect -> before()...");
    }

    public void after(){
        System.out.println("MyAspect -> after()...");
    }

    public void around(){
        System.out.println("MyAspect -> around()...");
    }

    public void throwing(){
        System.out.println("MyAspect -> throwing()...");
    }

    public void end(){
        System.out.println("MyAspect -> end()...");
    }
}
