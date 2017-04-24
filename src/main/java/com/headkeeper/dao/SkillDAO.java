package com.headkeeper.dao;

import com.headkeeper.bean.entity.Skill;
import com.headkeeper.dao.exception.DAOException;

import java.util.List;

/**
 * Created by User on 13.04.2017.
 */
public interface SkillDAO {
    /* CRUD OPERATION */

    // CREATE
    void addSkillToUser(int userId, Skill skill) throws DAOException;
    void addSkillToVacancy(int vacancyId, Skill skill) throws DAOException;

    // READ
    List<Skill> getSkillsForUser(int userId) throws DAOException;
    List<Skill> getSkillsForVacancy(int vacancyId) throws DAOException;

    // UPDATE
    void updateSkill(int skillId, Skill skill) throws DAOException;

    // DELETE
    void deleteSkill(int skillId) throws DAOException;
}
