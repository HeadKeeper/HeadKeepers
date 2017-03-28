package com.headkeeper.service;

import com.headkeeper.bean.entity.User;
import com.headkeeper.bean.view.UserView;
import com.headkeeper.service.exception.ServiceException;

import java.util.Collection;

public interface UserService {
    void removeUser(int id) throws ServiceException;
    void setUserActiveStatus(int id, boolean status) throws ServiceException;
    void registration(User user) throws ServiceException;
    void updateUserInfo(int id, User user) throws ServiceException;
    UserView getUser(int id) throws ServiceException;
    Collection<User> getAllUsers() throws ServiceException;
}
