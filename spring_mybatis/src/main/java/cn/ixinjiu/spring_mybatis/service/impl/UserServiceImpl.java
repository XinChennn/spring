package cn.ixinjiu.spring_mybatis.service.impl;

import cn.ixinjiu.spring_mybatis.dao.UserDao;
import cn.ixinjiu.spring_mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by XinChen on 2022/8/21
 *
 * @Description : TODO  使用构造器方式注入userDao对象
 */
@Service
public class UserServiceImpl implements UserService {
//    @Autowired
    private UserDao userDao;

    /**
     * TODO     使用构造器直接注入UserDao，并打印信息
     * @param userDao
     * @return
     */
    @Autowired // 构造器注入 注入的就是id="userDao"这个bean
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
        System.out.println("this.userDao = " + this.userDao);
    }
}
