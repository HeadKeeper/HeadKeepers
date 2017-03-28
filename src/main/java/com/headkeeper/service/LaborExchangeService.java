package com.headkeeper.service;

import com.headkeeper.bean.entity.Skill;
import com.headkeeper.bean.entity.*;
import com.headkeeper.service.exception.ServiceException;

import java.util.List;

public interface LaborExchangeService {

    /* -------------------- VacancyBase -------------------- */

    void createVacancy(Vacancy vacancy) throws ServiceException;

    void updateVacancy(int id, Vacancy vacancy) throws ServiceException;

    Vacancy getVacancy(int id) throws ServiceException;

    List<Vacancy> getAllVacancies() throws ServiceException;
    List<Vacancy> getVacanciesForEmployer(int employerId) throws ServiceException;

    void setVacancyActiveStatus(int id, boolean status) throws ServiceException;

    void deleteVacancy(int id) throws ServiceException;

    /* ------------------------------------------------- */


    /* -------------------- Resume --------------------- */

    void createResume(UserResume resume) throws ServiceException;

    void updateResume(int resumeId, UserResume resume) throws ServiceException;

    UserResume getResume(int resumeId) throws ServiceException;

    List<UserResume> getResumesForUser(int userId) throws ServiceException;

    void setResumeStatus(int resumeId, boolean status) throws ServiceException;

    void deleteResume(int resumeId) throws ServiceException;

    /* ------------------------------------------------- */


    /* --------------------- SkillBase --------------------- */

    void createSkill(Skill skill) throws ServiceException;

    void updateSkill(int skillId, Skill skill) throws ServiceException;

    List<Skill> getSkillsForUser(int userId) throws ServiceException;
    List<Skill> getSkillsForVacancy(int vacancyId) throws ServiceException;

    void deleteSkill(int skillId) throws ServiceException;

    /* ------------------------------------------------- */


    /* ------------------ Certificate ------------------ */

    void uploadCertificate(UserCertificate certificate) throws ServiceException;

    List<UserCertificate> getCetificatesForUser(int userId) throws ServiceException;

    void deleteCertificate(int certificateId) throws ServiceException;

    /* ------------------------------------------------- */


    /* ------------------ Achievement ------------------ */

    void addAchievement(ResumeAchievement achievement) throws ServiceException;

    void updateAchievement(int achievementId, ResumeAchievement achievement) throws ServiceException;

    List<ResumeAchievement> getAchievementsForResume(int resumeId) throws ServiceException;

    void deleteAchievement(int achievementId) throws ServiceException;

    /* ------------------------------------------------- */


    /* ------------------- Education ------------------- */

    void addEducation(ResumeEducation education) throws ServiceException;

    void updateEducation(int educationId, ResumeEducation education) throws ServiceException;

    List<ResumeEducation> getEducationsForResume(int resumeId) throws ServiceException;

    void deleteEducation(int educationId) throws ServiceException;

    /* ------------------------------------------------- */


    /* ------------- Additional education -------------- */

    void addAdditionalEducation(ResumeAdditionalEducation education) throws ServiceException;

    void updateAdditionalEducation(int educationId, ResumeAdditionalEducation education) throws ServiceException;

    List<ResumeAdditionalEducation> getAdditionalEducationsForResume(int resumeId) throws ServiceException;

    void deleteAdditionalEducation(int educationId) throws ServiceException;

    /* ------------------------------------------------- */


    /* ----------------- Contact info ------------------ */

    void addContactInfo(ResumeContactInfo contactInfo) throws ServiceException;

    void updateContactInfo(int contactInfoId, ResumeContactInfo contactInfo) throws ServiceException;

    List<ResumeContactInfo> getContactInfosForResume(int resumeId) throws ServiceException;

    void deleteContactInfo(int contactInfoId) throws ServiceException;

    /* ------------------------------------------------- */


    /* ------------------- Language -------------------- */

    void addLanguage(ResumeLanguage language) throws ServiceException;

    void updateLanguage(int languageId, ResumeLanguage language) throws ServiceException;

    List<ResumeContactInfo> getLanguagesForResume(int resumeId) throws ServiceException;

    void deleteLanguage(int languageId) throws ServiceException;

    /* ------------------------------------------------- */


    /* --------------------- Photo --------------------- */

    void uploadPhoto(ResumePhoto photo) throws ServiceException;

    List<ResumePhoto> getPhotosForResume(int resumeId) throws ServiceException;

    void deletePhoto(int photoId) throws ServiceException;

    /* ------------------------------------------------- */


    /* ---------------- Work experience ---------------- */

    void addWorkExperience(ResumeWorkExperience workExperience) throws ServiceException;

    void updateWorkExperience(int workExperienceId, ResumeWorkExperience workExperience) throws ServiceException;

    List<ResumeWorkExperience> getWorkExperiencesForResume(int resumeId) throws ServiceException;

    void deleteWorkExperience(int workExperienceId) throws ServiceException;

    /* ------------------------------------------------- */

}
