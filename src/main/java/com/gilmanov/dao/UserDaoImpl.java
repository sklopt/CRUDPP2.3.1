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

    @Override
    public List<User> getAllUsers() {
        return getEntityManager().createQuery("From User order by 1").getResultList();
    }

    @Override
    public void saveUser(User user) {
        getEntityManager().persist(user);
    }

    @Override
    public void removeUserById(long id) {
        getEntityManager()
                .createQuery("delete from User where id=: id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public void changeUser(User user) {
        getEntityManager().merge(user);
    }

    @Override
    public User getUserById(long id) {
        return getEntityManager().find(User.class, id);
    }
}
