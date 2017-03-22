package com.headkeeper.service;

import com.headkeeper.bean.User;

import java.util.Collection;

/**
 * Created by User on 21.03.2017.
 */
public interface UserService {
    void removeUser(int id);
    void setUserActiveStatus(int id, boolean status);
    void registration(User user);
    void updateUserInfo(int id, User user);
    User getUser(int id);
    Collection<User> getAllUsers();
}
