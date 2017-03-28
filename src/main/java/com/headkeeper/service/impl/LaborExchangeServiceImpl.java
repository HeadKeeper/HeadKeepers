package com.headkeeper.service.impl;

import com.headkeeper.bean.entity.Skill;
import com.headkeeper.bean.entity.*;
import com.headkeeper.dao.VacancyDAO;
import com.headkeeper.dao.exception.DAOException;
import com.headkeeper.service.LaborExchangeService;
import com.headkeeper.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaborExchangeServiceImpl implements LaborExchangeService {

    /* -------------------- Vacancy -------------------- */

    private final VacancyDAO vacancyDAO;

    @Autowired
    public LaborExchangeServiceImpl(VacancyDAO vacancyDAO) {
        this.vacancyDAO = vacancyDAO;
    }

    public void createVacancy(Vacancy vacancy) throws ServiceException {
        try {
            int userId = vacancy.getUserByUserId().getId();
            vacancyDAO.addVacancy(vacancy, userId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void updateVacancy(int id, Vacancy vacancy) throws ServiceException {
        try {
            vacancyDAO.updateVacancy(id, vacancy);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public Vacancy getVacancy(int id) throws ServiceException {
        try {
            return vacancyDAO.getVacancyById(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public List<Vacancy> getAllVacancies() throws ServiceException {
        try {
            return (List<Vacancy>) vacancyDAO.getAllVacancies();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public List<Vacancy> getVacanciesForEmployer(int employerId) throws ServiceException {
        try {
            return (List<Vacancy>) vacancyDAO.getVacanciesById(employerId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void setVacancyActiveStatus(int id, boolean status) throws ServiceException {
        try {
            vacancyDAO.updateVacancy(id, status);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void deleteVacancy(int id) throws ServiceException {
        try {
            vacancyDAO.deleteVacancy(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    /* ------------------------------------------------- */


    /* -------------------- Resume --------------------- */

    public void createResume(UserResume resume) throws ServiceException {

    }

    public void updateResume(int resumeId, UserResume resume) throws ServiceException {

    }

    public UserResume getResume(int resumeId) throws ServiceException {
        return null;
    }

    public List<UserResume> getResumesForUser(int userId) throws ServiceException {
        return null;
    }

    public void setResumeStatus(int resumeId, boolean status) throws ServiceException {

    }

    public void deleteResume(int resumeId) throws ServiceException {

    }

    /* ------------------------------------------------- */


    /* --------------------- Skill --------------------- */

    public void createSkill(Skill skill) throws ServiceException {

    }

    public void updateSkill(int skillId, Skill skill) throws ServiceException {

    }

    public List<Skill> getSkillsForUser(int userId) throws ServiceException {
        return null;
    }

    public List<Skill> getSkillsForVacancy(int vacancyId) throws ServiceException {
        return null;
    }

    public void deleteSkill(int skillId) throws ServiceException {

    }

    /* ------------------------------------------------- */


    /* ------------------ Certificate ------------------ */

    public void uploadCertificate(UserCertificate certificate) throws ServiceException {

    }

    public List<UserCertificate> getCetificatesForUser(int userId) throws ServiceException {
        return null;
    }

    public void deleteCertificate(int certificateId) throws ServiceException {

    }

    /* ------------------------------------------------- */


    /* ------------------ Achievement ------------------ */

    public void addAchievement(ResumeAchievement achievement) throws ServiceException {

    }

    public void updateAchievement(int achievementId, ResumeAchievement achievement) throws ServiceException {

    }

    public List<ResumeAchievement> getAchievementsForResume(int resumeId) throws ServiceException {
        return null;
    }

    public void deleteAchievement(int achievementId) throws ServiceException {

    }

    /* ------------------------------------------------- */


    /* ------------------- Education ------------------- */

    public void addEducation(ResumeEducation education) throws ServiceException {

    }

    public void updateEducation(int educationId, ResumeEducation education) throws ServiceException {

    }

    public List<ResumeEducation> getEducationsForResume(int resumeId) throws ServiceException {
        return null;
    }

    public void deleteEducation(int educationId) throws ServiceException {

    }

    /* ------------------------------------------------- */


    /* ------------- Additional education -------------- */

    public void addAdditionalEducation(ResumeAdditionalEducation education) throws ServiceException {

    }

    public void updateAdditionalEducation(int educationId, ResumeAdditionalEducation education) throws ServiceException {

    }

    public List<ResumeAdditionalEducation> getAdditionalEducationsForResume(int resumeId) throws ServiceException {
        return null;
    }

    public void deleteAdditionalEducation(int educationId) throws ServiceException {

    }

    /* ------------------------------------------------- */


    /* ----------------- Contact info ------------------ */

    public void addContactInfo(ResumeContactInfo contactInfo) throws ServiceException {

    }

    public void updateContactInfo(int contactInfoId, ResumeContactInfo contactInfo) throws ServiceException {

    }

    public List<ResumeContactInfo> getContactInfosForResume(int resumeId) throws ServiceException {
        return null;
    }

    public void deleteContactInfo(int contactInfoId) throws ServiceException {

    }

    /* ------------------------------------------------- */


    /* ------------------- Language -------------------- */

    public void addLanguage(ResumeLanguage language) throws ServiceException {

    }

    public void updateLanguage(int languageId, ResumeLanguage language) throws ServiceException {

    }

    public List<ResumeContactInfo> getLanguagesForResume(int resumeId) throws ServiceException {
        return null;
    }

    public void deleteLanguage(int languageId) throws ServiceException {

    }

    /* ------------------------------------------------- */


    /* --------------------- Photo --------------------- */

    public void uploadPhoto(ResumePhoto photo) throws ServiceException {

    }

    public List<ResumePhoto> getPhotosForResume(int resumeId) throws ServiceException {
        return null;
    }

    public void deletePhoto(int photoId) throws ServiceException {

    }

    /* ------------------------------------------------- */


    /* ---------------- Work experience ---------------- */

    public void addWorkExperience(ResumeWorkExperience workExperience) throws ServiceException {

    }

    public void updateWorkExperience(int workExperienceId, ResumeWorkExperience workExperience) throws ServiceException {

    }

    public List<ResumeWorkExperience> getWorkExperiencesForResume(int resumeId) throws ServiceException {
        return null;
    }

    public void deleteWorkExperience(int workExperienceId) throws ServiceException {

    }

    /* ------------------------------------------------- */
}

