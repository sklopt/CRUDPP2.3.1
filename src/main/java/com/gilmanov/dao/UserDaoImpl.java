package com.gilmanov.dao;

import com.gilmanov.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@SuppressWarnings("unchecked")
@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    protected EntityManager getEntityManager() {
        return this.entityManager;
    }


//    static {
//        listUsers.add(new User("Shamil", "Gilmanov", 37));
//        listUsers.add(new User("Timur", "Gilmanov", 15));
//    }

    @Override
    public List<User> getAllUsers() throws DaoException {
        return getEntityManager().createQuery("From User").getResultList();
    }

    @Override
    public void saveUser(User user) throws DaoException {
        getEntityManager().persist(user);
    }

    @Override
    public void removeUserById(long id) throws DaoException {
        getEntityManager()
                .createQuery("delete from User where id=: id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public void changeUser(User user) throws DaoException {
        getEntityManager().merge(user);
    }

    @Override
    public User getUserById(long id) throws DaoException {
        return getEntityManager().find(User.class, id);
    }
}
