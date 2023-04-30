package com.gilmanov.service;

import com.gilmanov.dao.DaoException;
import com.gilmanov.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers() throws DaoException;

    void saveUser(User user) throws DaoException;

    void removeUserById(long id) throws DaoException;

    void changeUser(User user) throws DaoException;

    User getUserById(long id) throws DaoException;
}
