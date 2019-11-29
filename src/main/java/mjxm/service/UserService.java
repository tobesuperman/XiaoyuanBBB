package mjxm.service;

import mjxm.pojo.User;

import java.util.List;

public interface UserService {
    public int register(User user);

    public int checkUserName(String userName);

    public int login(String userName, String password);

    public int logout(int userId);

    public int weixinBinding(int userId, String wxName, String wxImg);

    public int identify(int userId, String number);

    public boolean exists(int userId);

    public User findById(int userId);

//    public Integer getCurrentRegisteredUserId()

    public List<User> findByName(String userName);
}
