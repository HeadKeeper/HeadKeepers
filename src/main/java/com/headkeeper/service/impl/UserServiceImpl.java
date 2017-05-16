package com.headkeeper.service.impl;

import com.headkeeper.bean.entity.User;
import com.headkeeper.bean.view.CompanyInfoView;
import com.headkeeper.bean.view.UserView;
import com.headkeeper.dao.UserDAO;
import com.headkeeper.dao.exception.DAOException;
import com.headkeeper.dao.exception.ExistsDAOException;
import com.headkeeper.dao.exception.NotFoundDAOException;
import com.headkeeper.service.UserService;
import com.headkeeper.service.exception.ExistsServiceException;
import com.headkeeper.service.exception.NotFoundServiceException;
import com.headkeeper.service.exception.ServiceException;
import com.headkeeper.service.util.Exchanger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private static final byte USER_ROLE_ID = 1;

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void addCompany(CompanyInfoView companyInfo, int userId) throws ServiceException {
        try {
            userDAO.addCompanyInfo(Exchanger.exchangeViewToEntity(companyInfo), userId);
        } catch (ExistsDAOException e) {
            throw new ExistsServiceException("Company already exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while creating company", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    public void removeUser(int id) throws ServiceException {
        try {
            userDAO.deleteUser(id);
        } catch (NotFoundDAOException e) {
            throw new NotFoundServiceException("User doesn't exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while deleting user", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    public void setUserActiveStatus(int id, boolean status) throws ServiceException {
        try {
            userDAO.updateUser(id, status);
        } catch (NotFoundDAOException e) {
            throw new NotFoundServiceException("User doesn't exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while changing user status", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    public void registration(UserView user) throws ServiceException {
        try {
            user.setActive(true);
            user.setCreationDate(new Timestamp(System.currentTimeMillis()));

            int userId = user.getId();
            User userEntity = Exchanger.exchangeViewToEntity(user);
            userDAO.addNewUser(userEntity, USER_ROLE_ID);
        } catch (ExistsDAOException e) {
            throw new ExistsServiceException("User already exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while creating company", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    public void updateUserInfo(int id, UserView user) throws ServiceException {
        try {
            user.setId(id);
            User userEntity = Exchanger.exchangeViewToEntity(user);
            userDAO.updateUser(id, userEntity);
        } catch (NotFoundDAOException e) {
            throw new NotFoundServiceException("User doesn't exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while updating user", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    public UserView getUser(int id) throws ServiceException {
        User userEntity;

        try {
            userEntity = (User) userDAO.getUserById(id);
            return Exchanger.exchangeEntityToView(userEntity);
        } catch (NotFoundDAOException e) {
            throw new NotFoundServiceException("User doesn't exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while getting user", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
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
            throw new ServiceException("Something went wrong while deleting user", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    public UserView getUserByEmail(String userEmail) throws ServiceException {
        try {
            return Exchanger.exchangeEntityToView(userDAO.getUserByEmail(userEmail));
        } catch (NotFoundDAOException e) {
            throw new NotFoundServiceException("User doesn't exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while deleting user", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }
}
