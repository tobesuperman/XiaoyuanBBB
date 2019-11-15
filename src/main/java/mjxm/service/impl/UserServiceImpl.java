package mjxm.service.impl;

import mjxm.pojo.User;
import mjxm.mapping.UserMapper;
import mjxm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(User user) {
        userMapper.insert(user);
    }

    @Override
    public boolean exists(int userId) {
        return userMapper.selectByPrimaryKey(userId) == null;
    }

    @Override
    public User find(int userId) {
//        if (exists(userId)) {
//            return userMapper.selectByPrimaryKey(userId);
//        }
//        return null;
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<User> findByName(String userName) {
        return userMapper.selectByUserName(userName);
    }
}