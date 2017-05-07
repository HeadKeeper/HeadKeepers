package com.headkeeper.dao.impl;

import com.headkeeper.bean.entity.CompanyInfo;
import com.headkeeper.bean.entity.EmployerInfo;
import com.headkeeper.bean.entity.Role;
import com.headkeeper.bean.entity.User;
import com.headkeeper.dao.UserDAO;
import com.headkeeper.dao.exception.DAOException;
import com.headkeeper.dao.util.DataExchanger;
import com.headkeeper.dao.util.EntityPreprocessor;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;


@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    // TODO Add logging for all operations
    private final SessionFactory sessionFactory;

    @Autowired
    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private static final String USER_ENTITY_NAME = "UserEntity";
    private static final String COMPANY_INFO_ENTITY_NAME = "CompanyInfo";
    private static final String EMPLOYER_INFO_ENTITY_NAME = "EmployerInfo";

    /* CRUD OPERATIONS */

    // ------------------------------- CREATE -------------------------------

    public void addNewUser(User user, int roleId) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            Role role = session.load(Role.class, roleId);
            user.setRole(role);
            session.save(user);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't add user to database. This user already exist.");
        }
    }

    public void addCompanyInfo(CompanyInfo companyInfo, int ownerId) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            User user = session.load(User.class, ownerId);
            EntityPreprocessor.checkEntityOnExist(USER_ENTITY_NAME, ownerId, session);
            companyInfo.setUser(user);
            session.save(companyInfo);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't add company info to database. This company already exist.");
        }
    }

    public void addEmployerInfo(EmployerInfo employerInfo, int userId) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            User user = session.load(User.class, userId);
            EntityPreprocessor.checkEntityOnExist(USER_ENTITY_NAME, userId, session);
            employerInfo.setUser(user);
            session.save(employerInfo);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't add employer info to database. This employer already exist.");
        }
    }

    // ------------------------------- READ -------------------------------

    public User getUserById(int id) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            User user = session.get(User.class, id);
            if (user == null) {
                throw new DAOException("User with id = " + id +" not found.");
            }
            return user;
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
    }


    public CompanyInfo getCompanyInfoById(int id) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            CompanyInfo companyInfo = session.get(CompanyInfo.class, id);
            if (companyInfo == null) {
                throw new DAOException("Can't find company info with id = " + id);
            }
            return companyInfo;
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
    }


    public EmployerInfo getEmployerInfoById(int id) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            EmployerInfo employerInfo = session.get(EmployerInfo.class, id);
            if (employerInfo == null) {
                throw new DAOException("Can't find employer info with id = " + id);
            }
            return employerInfo;
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
    }

    public List<User> getUsers() throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            List<User> users = (List<User>) session.createQuery("from User").list();
            return users;
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session");
        }
        catch (HibernateException exception) {
            throw new DAOException("Error in HQL query execution.");
        }
    }

    @Override
    public User getUserByEmail(String email) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.createQuery("from User where email = :inputEmail");
            query.setParameter("inputEmail", email);
            User user = (User) query.getSingleResult();
            if (user.getIsActive()) {
                return user;
            }
            return null;
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session");
        }
        catch (HibernateException exception) {
            throw new DAOException("Error in HQL query execution.");
        }
    }


    // ------------------------------- UPDATE -------------------------------

    public void updateUser(int id, boolean status) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            User oldUser = (User) session.load(User.class, id);
            EntityPreprocessor.checkEntityOnExist(USER_ENTITY_NAME, id, session);
            oldUser.setIsActive(status);
            session.update(oldUser);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("User with id = " + id +" not found.");
        }
    }

    public void updateUser(int id, User user) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            User oldUser = (User) session.load(User.class, id);
            DataExchanger.replaceUserData(user, oldUser);
            session.merge(oldUser);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("User with id = " + id +" not found.");
        }
    }

    public void updateCompanyInfo(int id, CompanyInfo companyInfo) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            CompanyInfo oldCompanyInfo = session.load(CompanyInfo.class, id);
            EntityPreprocessor.checkEntityOnExist(COMPANY_INFO_ENTITY_NAME, id, session);
            DataExchanger.replaceCompanyInfo(companyInfo, oldCompanyInfo);
            session.merge(oldCompanyInfo);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("Company with id = " + id +" not found.");
        }
    }

    public void updateEmployerInfo(int id, EmployerInfo employerInfo) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            EmployerInfo oldEmployerInfo = session.load(EmployerInfo.class, id);
            EntityPreprocessor.checkEntityOnExist(EMPLOYER_INFO_ENTITY_NAME, id, session);
            DataExchanger.replaceEmployerInfo(employerInfo, oldEmployerInfo);
            session.merge(oldEmployerInfo);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("Employer with id = " + id +" not found.");
        }
    }


    // ------------------------------- DELETE -------------------------------

    public void deleteUser(int id) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            User user = session.load(User.class, id);
            EntityPreprocessor.checkEntityOnExist(USER_ENTITY_NAME, 1, session);
            session.delete(user);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("User with id = " + id +" not found.");
        }
    }

    public void deleteCompanyInfo(int id) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            CompanyInfo companyInfo = session.load(CompanyInfo.class, id);
            EntityPreprocessor.checkEntityOnExist(COMPANY_INFO_ENTITY_NAME, id, session);
            session.delete(companyInfo);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("Company with id = " + id +" not found.");
        }
    }

    public void deleteEmployerInfo(int id) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            EmployerInfo employerInfo = session.load(EmployerInfo.class, id);
            EntityPreprocessor.checkEntityOnExist(EMPLOYER_INFO_ENTITY_NAME, id, session);
            session.delete(employerInfo);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("Employer with id = " + id +" not found.");
        }
    }

}
