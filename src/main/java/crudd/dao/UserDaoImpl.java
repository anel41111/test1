package crudd.dao;

import crudd.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Елена on 27.09.2017.
 */
@Repository
public class UserDaoImpl implements UserDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);

    }

    public void updateUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    public void removeUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));
        if (user != null) {
            session.delete(user);
        }
    }

    public User getUserById(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));
        return user;
    }
    @SuppressWarnings("unchecked")
    public List<User> listUser() {
        Session session = sessionFactory.getCurrentSession();
        //Query quer = sessionFactory.getCurrentSession().createQuery("from crudd.model.User");
        List<User> listUser = (List<User>) session.createQuery("from User").list();
        return listUser;
    }
}
