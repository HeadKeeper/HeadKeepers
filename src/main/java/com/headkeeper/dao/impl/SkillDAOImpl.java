package com.headkeeper.dao.impl;

import com.headkeeper.bean.entity.Skill;
import com.headkeeper.dao.SkillDAO;
import com.headkeeper.dao.exception.DAOException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by User on 13.04.2017.
 */

@Transactional
@Repository
public class SkillDAOImpl implements SkillDAO {
    @Override
    public void addSkillToUser(int userId, Skill skill) throws DAOException {

    }

    @Override
    public void addSkillToVacancy(int vacancyId, Skill skill) throws DAOException {

    }

    @Override
    public List<Skill> getSkillsForUser(int userId) throws DAOException {
        return null;
    }

    @Override
    public List<Skill> getSkillsForVacancy(int vacancyId) throws DAOException {
        return null;
    }

    @Override
    public void updateSkill(int skillId, Skill skill) throws DAOException {

    }

    @Override
    public void deleteSkill(int skillId) throws DAOException {

    }
}
