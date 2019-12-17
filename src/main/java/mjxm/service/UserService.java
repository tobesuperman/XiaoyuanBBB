package mjxm.service;

import mjxm.pojo.User;

import java.util.List;

public interface UserService {
    public int login(User user);

    public int logout(int userId);

    public User findById(int userId);
}
