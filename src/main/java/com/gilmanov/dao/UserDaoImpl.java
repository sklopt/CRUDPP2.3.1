package com.gilmanov.dao;

import com.gilmanov.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {


//    static {
//        listUsers.add(new User("Shamil", "Gilmanov", 37));
//        listUsers.add(new User("Timur", "Gilmanov", 15));
//    }
    EntityManager em;
    @Override
    public List<User> getAllUsers() throws DaoException {
        List<User> listUser = null;
        Query q = em.createNativeQuery("SELECT * FROM users", User.class);
        listUser = (List<User>) q.getResultList();
        return listUser;
    }

    @Override
    public void saveUser(String name, String surname, int age) throws DaoException {

    }

    @Override
    public void removeUserById(long id) throws DaoException {

    }

    @Override
    public void changeUser() throws DaoException {

    }
}
