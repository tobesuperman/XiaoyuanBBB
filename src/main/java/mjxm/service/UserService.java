package mjxm.service;

import mjxm.pojo.User;

import java.util.List;

public interface UserService {
    public void register(User user);

    public boolean exists(int userId);

    public User find(int userId);

    public List<User> findByName(String userName);
}
