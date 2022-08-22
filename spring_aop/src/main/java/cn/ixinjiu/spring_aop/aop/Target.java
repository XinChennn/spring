package cn.ixinjiu.spring_aop.aop;

/**
 * Created by XinChen on 2022/8/22
 *
 * @Description : TODO
 */
public class Target implements TargetInterface {
    @Override
    public void save() {
        // 手动异常，测试异常通知
//        System.out.println(10 / 0);

        System.err.println("Target -> save() running...");
    }
}
