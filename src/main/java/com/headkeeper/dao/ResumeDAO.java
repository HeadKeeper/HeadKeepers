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
    void addWorkExperience(ResumeWorkExperience workExperience, int resumeId) throws DAOException;

    // READ
    UserResume getResumeById(int id) throws DAOException;
    List<ResumeAchievement> getResumeAchievements(int id) throws DAOException;
    List<ResumeAdditionalEducation> getAdditionalEducations(int id) throws DAOException;
    List<ResumeContactInfo> getContactInfo(int id) throws DAOException;
    List<ResumeEducation> getResumeEducations(int id) throws DAOException;
    List<ResumeLanguage> getResumeLanguages(int id) throws DAOException;
    List<ResumePhoto> getResumePhotos(int id) throws DAOException;
    List<ResumeWorkExperience> getResumeWorkExperience(int id) throws DAOException;
    List<UserResume> getResumeForUser(int userId) throws DAOException;
    List<ResumeWorkExperience> getResumeWorkExperiences(int id) throws DAOException;

    // UPDATE
    void updateResumeStatus(int id, boolean status) throws DAOException;
    void updateResume(int id, UserResume resume) throws DAOException;
    void updateLanguage(int languageId, ResumeLanguage language) throws DAOException;
    void updateWorkExperience(int workExpirienceId, ResumeWorkExperience workExperience) throws DAOException;
    void updateResumeAchievement(int achievementId, ResumeAchievement resumeAchievement) throws DAOException;
    void updateAdditionalEducation(int additionalEducationId, ResumeAdditionalEducation additionalEducation)
                                                                                        throws DAOException;
    void updateContactInfo(int contactInfoId, ResumeContactInfo contactInfo) throws DAOException;
    void updateEducation(int educationId, ResumeEducation education) throws DAOException;
    void updatePhoto(int photoId, ResumePhoto photo) throws DAOException;

    // DELETE
    void deleteResume(int id) throws DAOException;
    void deleteResumeAchievement(int achievementId) throws DAOException;
    void deleteAdditionalEducation(int additionalEducationId) throws DAOException;
    void deleteContactInfo(int contactInfoId) throws DAOException;
    void deleteEducation(int educationId) throws DAOException;
    void deleteLanguage(int languageId) throws DAOException;
    void deletePhoto(int photoId) throws DAOException;
    void deleteWorkExperience(int workExperienceId) throws DAOException;
}
