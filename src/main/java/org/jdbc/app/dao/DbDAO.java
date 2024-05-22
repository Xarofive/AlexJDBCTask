package org.jdbc.app.dao;

/**
 * Интерфейс для операций с БД
 *
 * @author John Lovecraft
 * @version 1.0
 * */
public interface DbDAO {
    void createTable();

    void dropTable();
}
