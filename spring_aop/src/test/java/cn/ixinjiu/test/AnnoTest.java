package cn.ixinjiu.test;

import cn.ixinjiu.spring_aop.anno.Target;
import cn.ixinjiu.spring_aop.anno.TargetInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by XinChen on 2022/8/22
 *
 * @Description : TODO
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-anno.xml")
public class AnnoTest {
    @Autowired
    private TargetInterface target;

    @Test
    public void test(){
        target.save();
    }
}
