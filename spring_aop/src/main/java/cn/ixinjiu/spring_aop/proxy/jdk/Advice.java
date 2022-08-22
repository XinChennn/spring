package cn.ixinjiu.spring_aop.proxy.jdk;

/**
 * Created by XinChen on 2022/8/22
 *
 * @Description : TODO  增强类
 */
public class Advice {
    public void before(){
        System.out.println("before()....");
    }

    public void after(){
        System.out.println("after()....");
    }
}
