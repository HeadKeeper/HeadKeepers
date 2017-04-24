package com.headkeeper.dao;

import com.headkeeper.bean.entity.UserCertificate;
import com.headkeeper.dao.exception.DAOException;

import java.util.List;

/**
 * Created by User on 13.04.2017.
 */
public interface CertificateDAO {
    /* CRUD OPERATIONS */

    // CREATE
    void addCertificate(int userId, UserCertificate certificate) throws DAOException;

    // READ
    List<UserCertificate> getCertificatesForUser(int userId) throws DAOException;

    // UPDATE

    // DELETE
    void deleteCertificate(int certificateId) throws DAOException;
}
