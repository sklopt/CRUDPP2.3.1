package com.gilmanov.dao;

import com.gilmanov.entity.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers() throws DaoException;

    void saveUser(User user) throws DaoException;

    void removeUserById(long id) throws DaoException;

    void changeUser(User user) throws DaoException;

    User getUserById(long id) throws DaoException;
}
