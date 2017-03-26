package com.headkeeper.service;

import com.headkeeper.bean.entity.Skill;
import com.headkeeper.bean.entity.*;

import java.util.List;

public interface LaborExchangeService {

    /* -------------------- VacancyBase -------------------- */

    void createVacancy(Vacancy vacancy);

    void updateVacancy(int id, Vacancy vacancy);

    Vacancy getVacancy(int id);

    List<Vacancy> getAllVacancies();
    List<Vacancy> getVacanciesForEmployer(int employerId);

    void setVacancyActiveStatus(int id, boolean status);

    void deleteVacancy(int id);

    /* ------------------------------------------------- */


    /* -------------------- Resume --------------------- */

    void createResume(UserResume resume);

    void updateResume(int resumeId, UserResume resume);

    UserResume getResume(int resumeId);

    List<UserResume> getResumesForUser(int userId);

    void setResumeStatus(int resumeId, boolean status);

    void deleteResume(int resumeId);

    /* ------------------------------------------------- */


    /* --------------------- SkillBase --------------------- */

    void createSkill(Skill skill);

    void updateSkill(int skillId, Skill skill);

    List<Skill> getSkillsForUser(int userId);
    List<Skill> getSkillsForVacancy(int vacancyId);

    void deleteSkill(int skillId);

    /* ------------------------------------------------- */


    /* ------------------ Certificate ------------------ */

    void uploadCertificate(UserCertificate certificate);

    List<UserCertificate> getCetificatesForUser(int userId);

    void deleteCertificate(int certificateId);

    /* ------------------------------------------------- */


    /* ------------------ Achievement ------------------ */

    void addAchievement(ResumeAchievement achievement);

    void updateAchievement(int achievementId, ResumeAchievement achievement);

    List<ResumeAchievement> getAchievementsForResume(int resumeId);

    void deleteAchievement(int achievementId);

    /* ------------------------------------------------- */


    /* ------------------- Education ------------------- */

    void addEducation(ResumeEducation education);

    void updateEducation(int educationId, ResumeEducation education);

    List<ResumeEducation> getEducationsForResume(int resumeId);

    void deleteEducation(int educationId);

    /* ------------------------------------------------- */


    /* ------------- Additional education -------------- */

    void addAdditionalEducation(ResumeAdditionalEducation education);

    void updateAdditionalEducation(int educationId, ResumeAdditionalEducation education);

    List<ResumeAdditionalEducation> getAdditionalEducationsForResume(int resumeId);

    void deleteAdditionalEducation(int educationId);

    /* ------------------------------------------------- */


    /* ----------------- Contact info ------------------ */

    void addContactInfo(ResumeContactInfo contactInfo);

    void updateContactInfo(int contactInfoId, ResumeContactInfo contactInfo);

    List<ResumeContactInfo> getContactInfosForResume(int resumeId);

    void deleteContactInfo(int contactInfoId);

    /* ------------------------------------------------- */


    /* ------------------- Language -------------------- */

    void addLanguage(ResumeLanguage language);

    void updateLanguage(int languageId, ResumeLanguage language);

    List<ResumeContactInfo> getLanguagesForResume(int resumeId);

    void deleteLanguage(int languageId);

    /* ------------------------------------------------- */


    /* --------------------- Photo --------------------- */

    void uploadPhoto(ResumePhoto photo);

    List<ResumePhoto> getPhotosForResume(int resumeId);

    void deletePhoto(int photoId);

    /* ------------------------------------------------- */


    /* ---------------- Work experience ---------------- */

    void addWorkExperience(ResumeWorkExperience workExperience);

    void updateWorkExperience(int workExperienceId, ResumeWorkExperience workExperience);

    List<ResumeWorkExperience> getWorkExperiencesForResume(int resumeId);

    void deleteWorkExperience(int workExperienceId);

    /* ------------------------------------------------- */

}
