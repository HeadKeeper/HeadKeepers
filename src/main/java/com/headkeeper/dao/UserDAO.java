package com.headkeeper.dao;

import com.headkeeper.bean.User;

public interface UserDAO {
    static final int USER_ROLE_ID = 1;
    /* CRUD operations */

    // CREATE
    void addNewUser(User user);

    // READ
    Object getUserById(int id);

    // UPDATE
    void updateUser(int id, User user);
    void updateUser(int id, boolean status);

    // DELETE
    void deleteUser(int id);

}
