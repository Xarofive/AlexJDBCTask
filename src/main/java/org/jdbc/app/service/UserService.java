package org.jdbc.app.service;

import org.jdbc.app.model.User;
import java.util.List;

/**
 * Интерфейс бизнеслогики модели User
 *
 * @author John Lovecraft
 * @version 1.0
 * */
public interface UserService {
    void cleanUserTable();

    void saveUser(User user);

    User getUser(int id);

    void deleteUser(int id);

    void updateUser(User user);

    List<User> getAllUsers();
}
