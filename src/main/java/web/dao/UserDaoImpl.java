package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> allUsers() {
        try {
            return entityManager.createQuery("from User").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public void add(User user) {
        try {
            entityManager.persist(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public User findUser(int id) {
        try {
            return entityManager.find(User.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    @Override
    public void delete(User user) {
        try {
            User emp = findUser(user.getId());
            if (emp != null) {
                entityManager.remove(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public void edit(User user) {
        try {
            entityManager.merge(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public User getById(int id) {
        try {
            return entityManager.find(User.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
