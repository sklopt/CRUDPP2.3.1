package com.gilmanov.dao;

import com.gilmanov.entity.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers() throws DaoException;

    void saveUser(String name, String surname, int age) throws DaoException;

    void removeUserById(long id) throws DaoException;

    void changeUser() throws DaoException;
}
