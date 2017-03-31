package com.headkeeper.dao;

import com.headkeeper.bean.entity.*;
import com.headkeeper.dao.exception.DAOException;

import java.util.List;

public interface ResumeDAO {
    /* CRUD OPERATIONS */

    // CREATE
    void addNewResume(UserResume resume) throws DAOException;
    void addResumeAchievement(ResumeAchievement achievement, int resumeId) throws DAOException;
    void addAdditionalEducation(ResumeAdditionalEducation additionalEducation, int resumeId) throws DAOException;
    void addContactInfo(ResumeContactInfo contactInfo, int resumeId) throws DAOException;
    void addEducation(ResumeEducation education, int resumeId) throws DAOException;
    void addLanguage(ResumeLanguage language, int resumeId) throws DAOException;
    void addPhoto(ResumePhoto photo, int resumeId) throws DAOException;

    // READ
    UserResume getResumeById(int id) throws DAOException;
    List<ResumeAchievement> getResumeAchievements(int id) throws DAOException;
    List<ResumeAdditionalEducation> getAdditionalEducations(int id) throws DAOException;
    List<ResumeContactInfo> getContactInfo(int id) throws DAOException;
    List<ResumeEducation> getResumeEducations(int id) throws DAOException;
    List<ResumeLanguage> getResumeLanguages(int id) throws DAOException;
    List<ResumePhoto> getResumePhotos(int id) throws DAOException;

    // UPDATE
    void updateResumeStatus(int id, boolean status) throws DAOException;
    void updateResume(int id, UserResume resume) throws DAOException;

    // DELETE
    void deleteResume(int id) throws DAOException;
    void deleteResumeAchievement(int achievementId, UserResume resume) throws DAOException;
    void deleteAdditionalEducation(int additionalEducationId, UserResume resume) throws DAOException;
    void deleteContactInfo(int contactInfoId, UserResume resume) throws DAOException;
    void deleteEducation(int educationId, UserResume resume) throws DAOException;
    void deleteLangugage(int languageId, UserResume resume) throws DAOException;
    void deletePhoto(int photoId, UserResume resume) throws DAOException;
    void deleteWorkExpirience(int workExpirienceId, UserResume resume) throws DAOException;
}
