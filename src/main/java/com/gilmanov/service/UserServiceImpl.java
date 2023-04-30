package com.gilmanov.service;

import com.gilmanov.dao.DaoException;
import com.gilmanov.dao.UserDao;
import com.gilmanov.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
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
    public void saveUser(User user) throws DaoException {
        userDao.saveUser(user);
    }

    @Override
    public void removeUserById(long id) throws DaoException {
        userDao.removeUserById(id);
    }

    @Override
    public void changeUser(User user) throws DaoException {
        userDao.changeUser(user);
    }

    @Override
    public User getUserById(long id) throws DaoException {
        return userDao.getUserById(id);
    }
}
