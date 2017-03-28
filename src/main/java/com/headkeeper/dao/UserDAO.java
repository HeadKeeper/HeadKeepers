package com.headkeeper.dao;

import com.headkeeper.bean.entity.User;
import com.headkeeper.dao.exception.DAOException;

public interface UserDAO {
    static final int USER_ROLE_ID = 1;
    /* CRUD operations */

    // CREATE
    void addNewUser(User user) throws DAOException;

    // READ
    Object getUserById(int id) throws DAOException;

    // UPDATE
    void updateUser(int id, User user) throws DAOException;
    void updateUser(int id, boolean status) throws DAOException;

    // DELETE
    void deleteUser(int id) throws DAOException;

}
