package crudd.service;

import crudd.dao.UserDao;
import crudd.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Елена on 27.09.2017.
 */
@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }
    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
    @Transactional
    public void removeUser(int id) {
        userDao.removeUser(id);
    }

    @Transactional
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }
    @Transactional
    public List<User> listUser() {
        return userDao.listUser();
    }
}
