package cn.baizhi.service;

import cn.baizhi.dao.UserDao;
import cn.baizhi.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

    @Resource
    private UserDao userDao;

    @Override
    public void insertUser(User user) {
        userDao.insert(user);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<User> selectAll(User user) {
        List<User> users = userDao.selectAll(user);
        return users;
    }
}
