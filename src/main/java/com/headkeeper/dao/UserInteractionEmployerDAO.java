package com.headkeeper.dao;


import com.headkeeper.bean.entity.UserResume;
import com.headkeeper.dao.exception.DAOException;

public interface UserInteractionEmployerDAO {
    /* CRUD Operations */

    // CREATE
    void createEmployerRequestToResume(int employerId, int resumeId) throws DAOException;
    void createRequestToVacancy(int resumeId, int vacancyId) throws DAOException;

    // READ
    void readUserResume(int resumeId, String message) throws DAOException;
    void readEmployerRequest(int vacancyId, String message) throws DAOException;

    // UPDATE

    // DELETE
}
