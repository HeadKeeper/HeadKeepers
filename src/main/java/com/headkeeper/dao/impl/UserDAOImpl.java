package com.headkeeper.dao.impl;

import com.headkeeper.bean.entity.Role;
import com.headkeeper.bean.entity.User;
import com.headkeeper.dao.UserDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class UserDAOImpl implements UserDAO {

    // TODO Add logging for all operations
    @Autowired
    private SessionFactory sessionFactory;

    /* CRUD OPERATIONS */

    // ------------------------------- CREATE -------------------------------

    public void addNewUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        Role role = session.get(Role.class, USER_ROLE_ID);
        user.setRole(role);
        session.save(user);
    }

    // ------------------------------- READ -------------------------------

    public User getUserById(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, id);
        return user;
    }

    // ------------------------------- UPDATE -------------------------------

    public void updateUser(int id, boolean status) {
        Session session = sessionFactory.getCurrentSession();
        User oldUser = (User) session.load(User.class, id);
        oldUser.setIsActive(status);
        session.update(oldUser);
    }

    public void updateUser(int id, User user) {
        Session session = sessionFactory.getCurrentSession();
        User oldUser = (User) session.load(User.class, id);
        oldUser.setEmail(user.getEmail());
        oldUser.setNickname(user.getNickname());
        oldUser.setPassword(user.getPassword());
        session.update(oldUser);
    }

    // ------------------------------- DELETE -------------------------------

    public void deleteUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, id);
        session.delete(user);
    }

}
