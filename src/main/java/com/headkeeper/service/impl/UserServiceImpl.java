package com.headkeeper.service.impl;

import com.headkeeper.bean.User;
import com.headkeeper.dao.UserDAO;
import com.headkeeper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by User on 21.03.2017.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    public void removeUser(int id) {
        userDAO.deleteUser(id);
    }

    public void setUserActiveStatus(int id, boolean status) {
        userDAO.updateUser(id, status);
    }


    public void registration(User user) {
        user.setIsActive(true);
        user.setCreationDate(new Timestamp(System.currentTimeMillis()));
        userDAO.addNewUser(user);
    }

    public void updateUserInfo(int id, User user) {
        userDAO.updateUser(id, user);
    }

    public User getUser(int id) {
        return (User) userDAO.getUserById(id);
    }

    public Collection<User> getAllUsers() {
        return null;
    }
}
