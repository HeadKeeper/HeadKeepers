package com.headkeeper.dao;

import com.headkeeper.bean.entity.CompanyInfo;
import com.headkeeper.bean.entity.EmployerInfo;
import com.headkeeper.bean.entity.User;
import com.headkeeper.dao.exception.DAOException;

import java.util.List;

public interface UserDAO {
    /* CRUD operations */


    // CREATE
    void addNewUser(User user, int roleId) throws DAOException;
    void addCompanyInfo(CompanyInfo companyInfo, int ownerId) throws DAOException;
    void addEmployerInfo(EmployerInfo employerInfo, int userId) throws DAOException;

    // READ
    Object getUserById(int id) throws DAOException;
    CompanyInfo getCompanyInfoById(int id) throws DAOException;
    EmployerInfo getEmployerInfoById(int id) throws DAOException;
    List<User> getUsers() throws DAOException;
    List<CompanyInfo> getAllCompanies() throws DAOException;
    User getUserByEmail(String email) throws DAOException;

    // UPDATE
    void updateUser(int id, User user) throws DAOException;
    void updateUser(int id, boolean status) throws DAOException;
    void updateCompanyInfo(int id, CompanyInfo companyInfo) throws DAOException;
    void updateEmployerInfo(int id, EmployerInfo employerInfo) throws DAOException;

    // DELETE
    void deleteUser(int id) throws DAOException;
    void deleteCompanyInfo(int id) throws DAOException;
    void deleteEmployerInfo(int id) throws DAOException;

}
