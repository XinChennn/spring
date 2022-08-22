package cn.ixinjiu.spring_aop.proxy.jdk;

/**
 * Created by XinChen on 2022/8/22
 *
 * @Description : TODO
 */
public class Target implements TargetInterface{
    @Override
    public void save() {
        System.out.println("save() running...");
    }
}
