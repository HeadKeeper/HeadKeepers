package com.headkeeper.service;

import com.headkeeper.bean.entity.ResumeLanguage;
import com.headkeeper.bean.view.*;
import com.headkeeper.service.exception.ServiceException;

import java.util.List;

public interface LaborExchangeService {

    /* -------------------- VacancyBase -------------------- */

    void createVacancy(int companyId, VacancyView vacancy) throws ServiceException;

    void updateVacancy(int vacancyId, VacancyView vacancy) throws ServiceException;

    VacancyView getVacancy(int vacancyId) throws ServiceException;

    List<VacancyView> getAllVacancies() throws ServiceException;
    List<VacancyView> getVacanciesForEmployer(int employerId) throws ServiceException;
    List<VacancyView> getVacanciesByTitle(String title) throws ServiceException;
    CompanyInfoView getCompanyByCompanyName(String companyName) throws ServiceException;

    void setVacancyActiveStatus(int id, boolean status) throws ServiceException;

    void deleteVacancy(int id) throws ServiceException;

    /* ------------------------------------------------- */


    /* -------------------- Resume --------------------- */

    void createResume(int userId, UserResumeView resume) throws ServiceException;

    void updateResume(int resumeId, UserResumeView resume) throws ServiceException;

    UserResumeView getResume(int resumeId) throws ServiceException;

    List<UserResumeView> getResumesForUser(int userId) throws ServiceException;

    List<UserResumeView> getAllResumes() throws ServiceException;

    void setResumeStatus(int resumeId, boolean status) throws ServiceException;

    void deleteResume(int resumeId) throws ServiceException;

    /* ------------------------------------------------- */


    /* --------------------- SkillBase --------------------- */

    void createSkillForUser(int userId, SkillView skill) throws ServiceException;
    void createSkillForVacancy(int vacancyId, SkillView skill) throws ServiceException;

    void updateSkill(int skillId, SkillView skill) throws ServiceException;

    List<SkillView> getSkillsForUser(int userId) throws ServiceException;
    List<SkillView> getSkillsForVacancy(int vacancyId) throws ServiceException;

    void deleteSkill(int skillId) throws ServiceException;

    /* ------------------------------------------------- */


    /* ------------------ Certificate ------------------ */

    void uploadCertificate(int userId, UserCertificateView certificate) throws ServiceException;

    List<UserCertificateView> getCetificatesForUser(int userId) throws ServiceException;

    void deleteCertificate(int certificateId) throws ServiceException;

    /* ------------------------------------------------- */


    /* ------------------ Achievement ------------------ */

    void addAchievement(int resumeId, ResumeAchievementView achievement) throws ServiceException;

    void updateAchievement(int achievementId, ResumeAchievementView achievement) throws ServiceException;

    List<ResumeAchievementView> getAchievementsForResume(int resumeId) throws ServiceException;

    void deleteAchievement(int achievementId) throws ServiceException;

    /* ------------------------------------------------- */


    /* ------------------- Education ------------------- */

    void addEducation(int resumeId, ResumeEducationView education) throws ServiceException;

    void updateEducation(int educationId, ResumeEducationView education) throws ServiceException;

    List<ResumeEducationView> getEducationsForResume(int resumeId) throws ServiceException;

    void deleteEducation(int educationId) throws ServiceException;

    /* ------------------------------------------------- */


    /* ------------- Additional education -------------- */

    void addAdditionalEducation(int resumeId, ResumeAdditionalEducationView education) throws ServiceException;

    void updateAdditionalEducation(int educationId, ResumeAdditionalEducationView education) throws ServiceException;

    List<ResumeAdditionalEducationView> getAdditionalEducationsForResume(int resumeId) throws ServiceException;

    void deleteAdditionalEducation(int educationId) throws ServiceException;

    /* ------------------------------------------------- */


    /* ----------------- Contact info ------------------ */

    void addContactInfo(int resumeId, ResumeContactInfoView contactInfo) throws ServiceException;

    void updateContactInfo(int contactInfoId, ResumeContactInfoView contactInfo) throws ServiceException;

    List<ResumeContactInfoView> getContactInfosForResume(int resumeId) throws ServiceException;

    void deleteContactInfo(int contactInfoId) throws ServiceException;

    /* ------------------------------------------------- */


    /* ------------------- Language -------------------- */

    void addLanguage(int resumeId, ResumeLanguageView language) throws ServiceException;

    void updateLanguage(int languageId, ResumeLanguageView language) throws ServiceException;

    List<ResumeLanguageView> getLanguagesForResume(int resumeId) throws ServiceException;

    void deleteLanguage(int languageId) throws ServiceException;

    /* ------------------------------------------------- */


    /* --------------------- Photo --------------------- */

    void uploadPhoto(int resumeId, ResumePhotoView photo) throws ServiceException;

    List<ResumePhotoView> getPhotosForResume(int resumeId) throws ServiceException;

    void deletePhoto(int photoId) throws ServiceException;

    /* ------------------------------------------------- */


    /* ---------------- Work experience ---------------- */

    void addWorkExperience(int resumeId, ResumeWorkExperienceView workExperience) throws ServiceException;

    void updateWorkExperience(int workExperienceId, ResumeWorkExperienceView workExperience) throws ServiceException;

    List<ResumeWorkExperienceView> getWorkExperiencesForResume(int resumeId) throws ServiceException;

    void deleteWorkExperience(int workExperienceId) throws ServiceException;

    /* ------------------------------------------------- */

}
