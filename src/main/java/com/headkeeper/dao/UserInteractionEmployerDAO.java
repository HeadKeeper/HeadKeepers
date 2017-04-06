package com.headkeeper.dao;


import com.headkeeper.dao.exception.DAOException;

public interface UserInteractionEmployerDAO {
    /* CRUD Operations */

    // CREATE
    void createEmployerRequestToResume() throws DAOException;
    void createRequestToVacancy() throws DAOException;

    // READ

    // UPDATE

    // DELETE
}
