package crudd.dao;

import crudd.model.User;

import java.util.List;

/**
 * Created by Елена on 27.09.2017.
 */
public interface UserDao {
    void addUser(User user);
    void updateUser(User user);
    void removeUser(int id);
    User getUserById(int id);
    List<User> listUser();
}
