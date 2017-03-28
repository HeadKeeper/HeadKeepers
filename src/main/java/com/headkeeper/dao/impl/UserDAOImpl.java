package com.headkeeper.dao.impl;

import com.headkeeper.bean.entity.Role;
import com.headkeeper.bean.entity.User;
import com.headkeeper.dao.UserDAO;
import com.headkeeper.dao.exception.DAOException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class UserDAOImpl implements UserDAO {

    // TODO Add logging for all operations
    private final SessionFactory sessionFactory;

    @Autowired
    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /* CRUD OPERATIONS */

    // ------------------------------- CREATE -------------------------------

    public void addNewUser(User user) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        Role role = session.get(Role.class, USER_ROLE_ID);
        user.setRole(role);
        session.save(user);
    }

    // ------------------------------- READ -------------------------------

    public User getUserById(int id) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, id);
        if (user == null) {
            throw new DAOException("User not found");
        }
        return user;
    }

    // ------------------------------- UPDATE -------------------------------

    public void updateUser(int id, boolean status) {
        Session session = sessionFactory.getCurrentSession();
        User oldUser = (User) session.load(User.class, id);
        oldUser.setIsActive(status);
        session.update(oldUser);
    }

    public void updateUser(int id, User user) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        User oldUser = (User) session.load(User.class, id);
        oldUser.setEmail(user.getEmail());
        oldUser.setNickname(user.getNickname());
        oldUser.setPassword(user.getPassword());
        session.update(oldUser);
    }

    // ------------------------------- DELETE -------------------------------

    public void deleteUser(int id) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, id);
        session.delete(user);
    }

}
