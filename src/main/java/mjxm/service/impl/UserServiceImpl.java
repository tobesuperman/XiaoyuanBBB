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
    public int register(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int checkUserName(String userName) {
        return userMapper.countByUserName(userName);
    }

    @Override
    public int login(String userName, String password) {
        return userMapper.selectByUserNameAndPassword(userName, password);
    }

    @Override
    public int logout(int userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int weixinBinding(int userId, String wxName, String wxImg) {
        return userMapper.updateWxNameAndWxImg(userId, wxName, wxImg);
    }

    @Override
    public int identify(int userId, String number) {
        return userMapper.updateIdentifiedAndNumber(userId, number);
    }

    @Override
    public boolean exists(int userId) {
        return userMapper.selectByPrimaryKey(userId) == null;
    }

    @Override
    public User findById(int userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<User> findByName(String userName) {
        return userMapper.selectByUserName(userName);
    }
}