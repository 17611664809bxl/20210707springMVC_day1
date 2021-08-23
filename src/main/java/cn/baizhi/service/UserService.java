package cn.baizhi.service;

import cn.baizhi.entity.User;

import java.util.List;

public interface UserService {

    void insertUser(User user);

    List<User> selectAll(User user);

}
