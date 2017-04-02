package com.headkeeper.dao.impl;

import com.headkeeper.bean.entity.Role;
import com.headkeeper.bean.entity.User;
import com.headkeeper.dao.UserDAO;
import com.headkeeper.dao.exception.DAOException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

    private void checkUserOnExist(User user, Session session) throws HibernateException {
        /*
            Here we make a request to database through proxy, which we get from session.load
            If User doesn't exist, hibernate throw exception
            If User exist - hibernate execute query
        */
        String query = "from User where id = " + user.getId();
        List resultList = session.createQuery(query).list();
        if (resultList.size() == 0) {
            throw new HibernateException("Can't find user with id = " + user.getId());
        }
    }

    /* CRUD OPERATIONS */

    // ------------------------------- CREATE -------------------------------

    public void addNewUser(User user) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            Role role = session.load(Role.class, USER_ROLE_ID);
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

    // ------------------------------- UPDATE -------------------------------

    public void updateUser(int id, boolean status) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            User oldUser = (User) session.load(User.class, id);
            checkUserOnExist(oldUser, session);
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
            checkUserOnExist(user, session);
            oldUser.setEmail(user.getEmail());
            oldUser.setNickname(user.getNickname());
            oldUser.setPassword(user.getPassword());
            session.update(oldUser);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("User with id = " + id +" not found.");
        }
    }

    // ------------------------------- DELETE -------------------------------

    public void deleteUser(int id) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            User user = (User) session.load(User.class, id);
            checkUserOnExist(user, session);
            session.delete(user);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("User with id = " + id +" not found.");
        }
    }

}
