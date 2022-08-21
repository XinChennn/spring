package cn.ixinjiu.spring_mybatis;

import cn.ixinjiu.spring_mybatis.dao.UserDao;
import cn.ixinjiu.spring_mybatis.entity.User;
import cn.ixinjiu.spring_mybatis.service.UserService;
import cn.ixinjiu.spring_mybatis.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by XinChen on 2022/8/20
 *
 * @Description : TODO
 * 1. 依赖版本号一定要好好对应，这个错误真是恶心，是最恶心的报错！！！！
 * 2. 要看好自己的包，配置的时候别配错了，细心一点
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringJUnitConfig(locations = "classpath:spring.xml")
public class MyTest {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService userServic;


    @Test
    public void test(){
        List<User> userList = userDao.findAll();
        userList.forEach(System.out::println);
    }

    @Test
    public void testServicee(){
        System.out.println("userServic = " + userServic);
    }
}
