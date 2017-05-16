package com.headkeeper.dao.impl;

import com.headkeeper.bean.entity.Skill;
import com.headkeeper.bean.entity.User;
import com.headkeeper.bean.entity.UserCertificate;
import com.headkeeper.bean.entity.Vacancy;
import com.headkeeper.dao.SkillDAO;
import com.headkeeper.dao.exception.DAOException;
import com.headkeeper.dao.util.DataExchanger;
import com.headkeeper.dao.util.EntityPreprocessor;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class SkillDAOImpl implements SkillDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public SkillDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addSkillToUser(int userId, Skill skill) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            User user = session.load(User.class, userId);
            EntityPreprocessor.checkEntityOnExist(User.class.getName(), userId, session);
            skill.getUsers().add(user);
            session.saveOrUpdate(skill);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't open session");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find user with id = " + userId);
        }
    }

    public void addSkillToVacancy(int vacancyId, Skill skill) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            Vacancy vacancy = session.load(Vacancy.class, vacancyId);
            EntityPreprocessor.checkEntityOnExist(Vacancy.class.getName(), vacancyId, session);
            skill.getVacancies().add(vacancy);
            session.saveOrUpdate(skill);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't open session");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find vacancy with id = " + vacancyId);
        }
    }

    public List<Skill> getSkillsForUser(int userId) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            EntityPreprocessor.checkEntityOnExist(User.class.getName(), userId, session);
            List<Skill> skills = session.createQuery(
                    "from User where User.skills = " + userId
            ).list();
            return skills;
        }
        catch (SessionException exception) {
            throw new DAOException("Can't open new session");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find user id = " + userId);
        }
    }

    public List<Skill> getSkillsForVacancy(int vacancyId) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            EntityPreprocessor.checkEntityOnExist(Vacancy.class.getName(), vacancyId, session);
            List<Skill> skills = session.createQuery(
                    "from Vacancy where Vacancy.skills = " + vacancyId
            ).list();
            return skills;
        }
        catch (SessionException exception) {
            throw new DAOException("Can't open new session");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find vacancy with id = " + vacancyId);
        }
    }

    public void updateSkill(int skillId, Skill skill) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            EntityPreprocessor.checkEntityOnExist(Skill.class.getName(), skillId, session);
            Skill oldSkill = session.load(Skill.class, skillId);
            DataExchanger.replaceSkillData(oldSkill, skill);
            session.update(oldSkill);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't open new session");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find skill with id = " + skillId);
        }
    }

    public void deleteSkill(int skillId) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            EntityPreprocessor.checkEntityOnExist(Skill.class.getName(), skillId, session);
            Skill skill = session.load(Skill.class, skillId);
            session.delete(skill);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't open new session");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find skill with id = " + skillId);
        }
    }
}
