package mjxm.service.impl;

import mjxm.pojo.User;
import mjxm.mapping.UserMapper;
import mjxm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int login(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public int logout(int userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public User findById(int userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

}