package com.headkeeper.dao.impl;

import com.headkeeper.bean.entity.UserCertificate;
import com.headkeeper.dao.CertificateDAO;
import com.headkeeper.dao.exception.DAOException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by User on 13.04.2017.
 */

@Transactional
@Repository
public class CertificateDAOImpl implements CertificateDAO {
    @Override
    public void addCertificate(int userId, UserCertificate certificate) throws DAOException {

    }

    @Override
    public List<UserCertificate> getCertificatesForUser(int userId) throws DAOException {
        return null;
    }

    @Override
    public void deleteCertificate(int certificateId) throws DAOException {

    }
}
