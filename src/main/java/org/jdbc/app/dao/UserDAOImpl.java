package org.jdbc.app.dao;

import org.jdbc.app.model.User;

import java.util.List;

/**
 * Логика CRUD операций с БД модели User
 *
 * @author John Lovecraft
 * @version 1.0
 */
public class UserDAOImpl implements UserDAO {
    //todo Реализовать методы DML операций

    @Override
    public void cleanUserTable() {

    }

    @Override
    public void insertUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public User getUserByID(int id) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }
}
