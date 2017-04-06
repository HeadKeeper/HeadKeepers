package com.headkeeper.service.impl;

import com.headkeeper.bean.entity.User;
import com.headkeeper.bean.view.UserView;
import com.headkeeper.dao.UserDAO;
import com.headkeeper.dao.exception.DAOException;
import com.headkeeper.service.UserService;
import com.headkeeper.service.exception.ServiceException;
import com.headkeeper.service.util.Exchanger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

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

    public void registration(UserView user) throws ServiceException {
        user.setActive(true);
        //TODO: Set in the table
        user.setCreationDate(new Timestamp(System.currentTimeMillis()));
        int userId = user.getId();
        User userEntity = Exchanger.exchangeViewToEntity(user);
        try {
<<<<<<< HEAD
            userDAO.addNewUser(userEntity, 1);
=======
            userDAO.addNewUser(userEntity, userId);
>>>>>>> 93caf9f3015b0474344ee53ab3cad7a7b3634dfa
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void updateUserInfo(int id, UserView user) throws ServiceException {
        try {
            User userEntity = Exchanger.exchangeViewToEntity(user);

            userDAO.updateUser(id, userEntity);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public UserView getUser(int id) throws ServiceException {
        User userEntity;

        try {
            userEntity = (User) userDAO.getUserById(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return Exchanger.exchangeEntityToView(userEntity);
    }

    public List<UserView> getAllUsers() throws ServiceException {
        List<UserView> userViews = new LinkedList<UserView>();
        try {
            List<User> userEntities = userDAO.getUsers();

            for (User userEntity : userEntities) {
                UserView userView = Exchanger.exchangeEntityToView(userEntity);
                userViews.add(userView);
            }

            return userViews;
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
