package com.headkeeper.service.impl;

import com.headkeeper.bean.*;
import com.headkeeper.dao.VacancyDAO;
import com.headkeeper.service.LaborExchangeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LaborExchangeServiceImpl implements LaborExchangeService {

    /* -------------------- Vacancy -------------------- */

    @Autowired
    private VacancyDAO vacancyDAO;

    public void createVacancy(Vacancy vacancy) {
        vacancyDAO.addVacancy(vacancy,vacancy.getUserByUserId().getId());
    }

    public void updateVacancy(int id, Vacancy vacancy) {
        vacancyDAO.updateVacancy(id, vacancy);
    }

    public Vacancy getVacancy(int id) {
        return vacancyDAO.getVacancyById(id);
    }

    public List<Vacancy> getAllVacancies() {
        return (List<Vacancy>) vacancyDAO.getAllVacancies();
    }

    public List<Vacancy> getVacanciesForEmployer(int employerId) {
        return (List<Vacancy>) vacancyDAO.getVacanciesById(employerId);
    }

    public void setVacancyActiveStatus(int id, boolean status) {
        vacancyDAO.updateVacancy(id, status);
    }

    public void deleteVacancy(int id) {
        vacancyDAO.deleteVacancy(id);
    }

    /* ------------------------------------------------- */


    /* -------------------- Resume --------------------- */

    public void createResume(UserResume resume) {

    }

    public void updateResume(int resumeId, UserResume resume) {

    }

    public UserResume getResume(int resumeId) {
        return null;
    }

    public List<UserResume> getResumesForUser(int userId) {
        return null;
    }

    public void setResumeStatus(int resumeId, boolean status) {

    }

    public void deleteResume(int resumeId) {

    }

    /* ------------------------------------------------- */


    /* --------------------- Skill --------------------- */

    public void createSkill(Skill skill) {

    }

    public void updateSkill(int skillId, Skill skill) {

    }

    public List<Skill> getSkillsForUser(int userId) {
        return null;
    }

    public List<Skill> getSkillsForVacancy(int vacancyId) {
        return null;
    }

    public void deleteSkill(int skillId) {

    }

    /* ------------------------------------------------- */


    /* ------------------ Certificate ------------------ */

    public void uploadCertificate(UserCertificate certificate) {

    }

    public List<UserCertificate> getCetificatesForUser(int userId) {
        return null;
    }

    public void deleteCertificate(int certificateId) {

    }

    /* ------------------------------------------------- */


    /* ------------------ Achievement ------------------ */

    public void addAchievement(ResumeAchievement achievement) {

    }

    public void updateAchievement(int achievementId, ResumeAchievement achievement) {

    }

    public List<ResumeAchievement> getAchievementsForResume(int resumeId) {
        return null;
    }

    public void deleteAchievement(int achievementId) {

    }

    /* ------------------------------------------------- */


    /* ------------------- Education ------------------- */

    public void addEducation(ResumeEducation education) {

    }

    public void updateEducation(int educationId, ResumeEducation education) {

    }

    public List<ResumeEducation> getEducationsForResume(int resumeId) {
        return null;
    }

    public void deleteEducation(int educationId) {

    }

    /* ------------------------------------------------- */


    /* ------------- Additional education -------------- */

    public void addAdditionalEducation(ResumeAdditionalEducation education) {

    }

    public void updateAdditionalEducation(int educationId, ResumeAdditionalEducation education) {

    }

    public List<ResumeAdditionalEducation> getAdditionalEducationsForResume(int resumeId) {
        return null;
    }

    public void deleteAdditionalEducation(int educationId) {

    }

    /* ------------------------------------------------- */


    /* ----------------- Contact info ------------------ */

    public void addContactInfo(ResumeContactInfo contactInfo) {

    }

    public void updateContactInfo(int contactInfoId, ResumeContactInfo contactInfo) {

    }

    public List<ResumeContactInfo> getContactInfosForResume(int resumeId) {
        return null;
    }

    public void deleteContactInfo(int contactInfoId) {

    }

    /* ------------------------------------------------- */


    /* ------------------- Language -------------------- */

    public void addLanguage(ResumeLanguage language) {

    }

    public void updateLanguage(int languageId, ResumeLanguage language) {

    }

    public List<ResumeContactInfo> getLanguagesForResume(int resumeId) {
        return null;
    }

    public void deleteLanguage(int languageId) {

    }

    /* ------------------------------------------------- */


    /* --------------------- Photo --------------------- */

    public void uploadPhoto(ResumePhoto photo) {

    }

    public List<ResumePhoto> getPhotosForResume(int resumeId) {
        return null;
    }

    public void deletePhoto(int photoId) {

    }

    /* ------------------------------------------------- */


    /* ---------------- Work experience ---------------- */

    public void addWorkExperience(ResumeWorkExperience workExperience) {

    }

    public void updateWorkExperience(int workExperienceId, ResumeWorkExperience workExperience) {

    }

    public List<ResumeWorkExperience> getWorkExperiencesForResume(int resumeId) {
        return null;
    }

    public void deleteWorkExperience(int workExperienceId) {

    }

    /* ------------------------------------------------- */
}

