package org.jdbc.app.dao;

import org.jdbc.app.model.User;

import java.util.List;

/**
 * Интерфейс для модели User
 *
 * @author John Lovecraft
 * @version 1.0
 * */
public interface UserDAO {
    void cleanUserTable();

    void insertUser(User user);

    void updateUser(User user);

    void deleteUser(User user);

    User getUserByID(int id);

    List<User> getUsers();
}
