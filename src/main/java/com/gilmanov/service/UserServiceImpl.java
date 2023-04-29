package com.gilmanov.service;

import com.gilmanov.dao.DaoException;
import com.gilmanov.dao.UserDao;
import com.gilmanov.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAllUsers() throws DaoException {
        return userDao.getAllUsers();
    }

    @Override
    public void saveUser(String name, String surname, int age) throws DaoException {
        userDao.saveUser(name, surname, age);
    }

    @Override
    public void removeUserById(long id) throws DaoException {
        userDao.removeUserById(id);
    }

    @Override
    public void changeUser() throws DaoException {
        userDao.changeUser();
    }
}
