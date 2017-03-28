package com.headkeeper.service.impl;

import com.headkeeper.bean.entity.User;
import com.headkeeper.bean.view.UserView;
import com.headkeeper.dao.UserDAO;
import com.headkeeper.dao.exception.DAOException;
import com.headkeeper.service.UserService;
import com.headkeeper.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void removeUser(int id) throws ServiceException {
        try {
            userDAO.deleteUser(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void setUserActiveStatus(int id, boolean status) throws ServiceException {
        try {
            userDAO.updateUser(id, status);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }


    public void registration(User user) throws ServiceException {
        user.setIsActive(true);
        user.setCreationDate(new Timestamp(System.currentTimeMillis()));
        try {
            userDAO.addNewUser(user);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void updateUserInfo(int id, User user) throws ServiceException {
        try {
            userDAO.updateUser(id, user);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public UserView getUser(int id) throws ServiceException {
        User userEntity = null;

        try {
            userEntity = (User) userDAO.getUserById(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        UserView userView = new UserView();

        userView.setId(userEntity.getId());
        userView.setEmail(userEntity.getEmail());
        userView.setPassword(userEntity.getPassword());
        userView.setNickname(userEntity.getNickname());
        userView.setCreationDate(userEntity.getCreationDate());
        userView.setActive(userEntity.getIsActive());

        return userView;
    }

    public Collection<User> getAllUsers() throws ServiceException {
        return null;
    }
}
