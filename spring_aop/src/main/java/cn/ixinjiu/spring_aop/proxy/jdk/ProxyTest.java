package cn.ixinjiu.spring_aop.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by XinChen on 2022/8/22
 *
 * @Description : TODO
 */
public class ProxyTest {

    public static void main(String[] args) {

        Target target = new Target();

        Advice advice = new Advice();

        // 三个参数：class, interfaces, invocationHandler

        // 动态生成的代理对象  （兄弟关系，不可以用Target来接收，需要用Target的接口来接收）
        TargetInterface o = (TargetInterface) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),  // 目标对象类加载器
                target.getClass().getInterfaces(),   // 目标对象接口字节码数组
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        advice.before(); // 通知类的前置增强
                        Object invoke = method.invoke(target, args);// 调用目标方法
                        advice.after();  // 通知类的后置增强
                        return invoke;
                    }
                }
        );

        o.save();

    }

}