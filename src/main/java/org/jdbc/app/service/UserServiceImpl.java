package org.jdbc.app.service;

import org.jdbc.app.model.User;

import java.util.List;

/**
 * реализация бизнеслогики модели User
 *
 * @author John Lovecraft
 * @version 1.0
 * */
public class UserServiceImpl implements UserService {
    //todo Реализовать каждый метод исходя из полученных данных из DAO слоя

    @Override
    public void cleanUserTable() {

    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public User getUser(int id) {
        return null;
    }

    @Override
    public void deleteUser(int id) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}
