package com.headkeeper.service;

import com.headkeeper.bean.entity.User;
import com.headkeeper.bean.view.CompanyInfoView;
import com.headkeeper.bean.view.UserView;
import com.headkeeper.service.exception.ServiceException;

import java.util.List;

public interface UserService {
    void addCompany(CompanyInfoView companyInfo, int userId) throws ServiceException;
    void removeUser(int id) throws ServiceException;
    void setUserActiveStatus(int id, boolean status) throws ServiceException;
    void registration(UserView user) throws ServiceException;
    void updateUserInfo(int id, UserView user) throws ServiceException;
    UserView getUser(int id) throws ServiceException;
    List<UserView> getAllUsers() throws ServiceException;
    List<CompanyInfoView> getAllCompanies() throws ServiceException;

    UserView getUserByEmail(String userEmail) throws ServiceException;
}
