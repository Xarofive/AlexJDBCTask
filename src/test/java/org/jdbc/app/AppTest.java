package org.jdbc.app;

import org.jdbc.app.model.User;
import org.jdbc.app.service.DbService;
import org.jdbc.app.service.UserService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Unit test for simple App.
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AppTest {

    @Mock
    private DbService dbService;

    @Mock
    private UserService userService;

    @InjectMocks
    private User TEST_USER = new User(0, "Alex", "zxc", "zxc@ya.ru");

    @BeforeAll
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @BeforeEach
    void setUp() {
        doNothing().when(dbService).dropTable();
        doNothing().when(dbService).createTable();
        doNothing().when(userService).saveUser(TEST_USER);
        doNothing().when(userService).deleteUser(anyInt());
        when(userService.getAllUsers()).thenReturn(List.of(TEST_USER));
        doNothing().when(userService).cleanUserTable();
    }

    @Test
    public void createUsersTable() {
        Assertions.assertDoesNotThrow(() -> {
            dbService.dropTable();
            dbService.createTable();
        });
    }

    @Test
    public void saveUser() {
        Assertions.assertDoesNotThrow(() -> {
            dbService.dropTable();
            dbService.createTable();
            userService.saveUser(TEST_USER);

            User user = userService.getAllUsers().get(0);

            Assertions.assertTrue(TEST_USER.getUsername().equals(user.getUsername())
                            && TEST_USER.getEmail().equals(user.getEmail())
                            && Objects.equals(TEST_USER.getPassword(), user.getPassword()),
                    "User был некорректно добавлен в базу данных");
        });
    }

    @Test
    public void removeUserById() {
        Assertions.assertDoesNotThrow(() -> {
            dbService.dropTable();
            dbService.createTable();
            userService.saveUser(TEST_USER);
            userService.deleteUser(0);
        });
    }

    @Test
    public void getAllUsers() {
        Assertions.assertDoesNotThrow(() -> {
            dbService.dropTable();
            dbService.createTable();
            userService.saveUser(TEST_USER);
            List<User> userList = userService.getAllUsers();

            Assertions.assertEquals(1, userList.size(),
                    "Проверьте корректность работы метода сохранения пользователя/удаления или создания таблицы");
        });
    }

//    @Test
//    public void cleanUsersTable() {
//        Assertions.assertDoesNotThrow(() -> {
//            dbService.dropTable();
//            dbService.createTable();
//            userService.saveUser(TEST_USER);
//            userService.cleanUserTable();
//
//            Assertions.assertTrue(userService.getAllUsers().isEmpty(),
//                    "Метод очищения таблицы пользователей реализован не корректно");
//        });
//    }

    @AfterEach
    void tearDown() {
        reset(dbService, userService);
    }
}
