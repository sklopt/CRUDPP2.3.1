package com.gilmanov.service;

import com.gilmanov.dao.DaoException;
import com.gilmanov.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers() throws DaoException;

    void saveUser(String name, String surname, int age) throws DaoException;

    void removeUserById(long id) throws DaoException;

    void changeUser() throws DaoException;
}
