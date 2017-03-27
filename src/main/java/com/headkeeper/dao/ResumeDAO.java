package com.headkeeper.dao;

import com.headkeeper.bean.entity.*;

import java.util.List;

public interface ResumeDAO {
    /* CRUD OPERATIONS */

    // CREATE
    void addNewResume(UserResume resume);
    void addResumeAchievement(ResumeAchievement achievement, int resumeId);
    void addAdditionalEducation(ResumeAdditionalEducation additionalEducation, int resumeId);
    void addContactInfo(ResumeContactInfo contactInfo, int resumeId);
    void addEducation(ResumeEducation education, int resumeId);
    void addLanguage(ResumeLanguage language, int resumeId);
    void addPhoto(ResumePhoto photo, int resumeId);

    // READ
    UserResume getResumeById(int id);
    List<ResumeAchievement> getResumeAchievements(int id);
    List<ResumeAdditionalEducation> getAdditionalEducations(int id);
    List<ResumeContactInfo> getContactInfo(int id);
    List<ResumeEducation> getResumeEducations(int id);
    List<ResumeLanguage> getResumeLanguages(int id);
    List<ResumePhoto> getResumePhotos(int id);

    // UPDATE
    void updateResumeStatus(int id, boolean status);
    void updateResume(int id, UserResume resume);

    // DELETE
    void deleteResume(int id);
    void deleteResumeAchievemet(int achievementId, UserResume resume);
    void deleteAdditionalEducation(int additionalEducationId, UserResume resume);
    void deleteContactInfo(int contactInfoId, UserResume resume);
    void deleteEducation(int educationId, UserResume resume);
    void deleteLangugage(int languageId, UserResume resume);
    void deletePhoto(int photoId, UserResume resume);
}
