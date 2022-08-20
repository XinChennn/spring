package cn.ixinjiu.spring_mybatis.dao;

import cn.ixinjiu.spring_mybatis.entity.User;

import java.util.List;

/**
 * Created by xinchen on 2022/8/20
 *
 * @Description : TODO
 */
public interface UserDao {
    // Select all user from table user.
    List<User> findAll();
}
