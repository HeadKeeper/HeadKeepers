package com.headkeeper.service;

import com.headkeeper.bean.entity.User;
import com.headkeeper.bean.view.UserView;

import java.util.Collection;

public interface UserService {
    void removeUser(int id);
    void setUserActiveStatus(int id, boolean status);
    void registration(User user);
    void updateUserInfo(int id, User user);
    UserView getUser(int id);
    Collection<User> getAllUsers();
}
