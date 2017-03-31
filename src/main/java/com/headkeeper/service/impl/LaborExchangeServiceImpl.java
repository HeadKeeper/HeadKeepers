package com.headkeeper.service.impl;

import com.headkeeper.bean.entity.*;
import com.headkeeper.bean.view.*;
import com.headkeeper.dao.ResumeDAO;
import com.headkeeper.dao.VacancyDAO;
import com.headkeeper.dao.exception.DAOException;
import com.headkeeper.service.LaborExchangeService;
import com.headkeeper.service.exception.ServiceException;
import com.headkeeper.service.util.Exchanger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class LaborExchangeServiceImpl implements LaborExchangeService {

    private final VacancyDAO vacancyDAO;
    private final ResumeDAO resumeDAO;

    @Autowired
    public LaborExchangeServiceImpl(VacancyDAO vacancyDAO, ResumeDAO resumeDAO) {
        this.vacancyDAO = vacancyDAO;
        this.resumeDAO = resumeDAO;
    }

    /* -------------------- Vacancy -------------------- */

    public void createVacancy(VacancyView vacancy) throws ServiceException {
        try {
            int userId = vacancy.getUser().getId();

            Vacancy vacancyEntity = Exchanger.exchangeViewToEntity(vacancy);
            vacancyDAO.addVacancy(vacancyEntity, userId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void updateVacancy(int id, VacancyView vacancy) throws ServiceException {
        try {
            Vacancy vacancyEntity = Exchanger.exchangeViewToEntity(vacancy);

            vacancyDAO.updateVacancy(id, vacancyEntity);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public VacancyView getVacancy(int id) throws ServiceException {
        try {
            Vacancy vacancyEntity = vacancyDAO.getVacancyById(id);

            return Exchanger.exchangeEntityToView(vacancyEntity);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public List<VacancyView> getAllVacancies() throws ServiceException {
        try {
            //TODO: Change to List
            List<Vacancy> vacancyEntities = (List<Vacancy>) vacancyDAO.getAllVacancies();
            List<VacancyView> vacancyViews = new LinkedList<VacancyView>();

            for (Vacancy vacancyEntity : vacancyEntities) {
                VacancyView vacancyView = Exchanger.exchangeEntityToView(vacancyEntity);
                vacancyViews.add(vacancyView);
            }

            return vacancyViews;
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public List<VacancyView> getVacanciesForEmployer(int employerId) throws ServiceException {
        try {
            //TODO: Change to List
            List<Vacancy> vacancyEntities = (List<Vacancy>) vacancyDAO.getVacanciesById(employerId);
            List<VacancyView> vacancyViews = new LinkedList<VacancyView>();

            for (Vacancy vacancyEntity : vacancyEntities) {
                VacancyView vacancyView = Exchanger.exchangeEntityToView(vacancyEntity);
                vacancyViews.add(vacancyView);
            }

            return vacancyViews;
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

    public void createResume(UserResumeView resume) throws ServiceException {

    }

    public void updateResume(int resumeId, UserResumeView resume) throws ServiceException {

    }

    public UserResumeView getResume(int resumeId) throws ServiceException {
        return null;
    }

    public List<UserResumeView> getResumesForUser(int userId) throws ServiceException {
        return null;
    }

    public void setResumeStatus(int resumeId, boolean status) throws ServiceException {

    }

    public void deleteResume(int resumeId) throws ServiceException {

    }

    /* ------------------------------------------------- */


    /* --------------------- Skill --------------------- */

    public void createSkill(SkillView skill) throws ServiceException {

    }

    public void updateSkill(int skillId, SkillView skill) throws ServiceException {

    }

    public List<SkillView> getSkillsForUser(int userId) throws ServiceException {
        return null;
    }

    public List<SkillView> getSkillsForVacancy(int vacancyId) throws ServiceException {
        return null;
    }

    public void deleteSkill(int skillId) throws ServiceException {

    }

    /* ------------------------------------------------- */


    /* ------------------ Certificate ------------------ */

    public void uploadCertificate(UserCertificateView certificate) throws ServiceException {

    }

    public List<UserCertificateView> getCetificatesForUser(int userId) throws ServiceException {
        return null;
    }

    public void deleteCertificate(int certificateId) throws ServiceException {

    }

    /* ------------------------------------------------- */


    /* ------------------ Achievement ------------------ */

    public void addAchievement(ResumeAchievementView achievement) throws ServiceException {

    }

    public void updateAchievement(int achievementId, ResumeAchievementView achievement) throws ServiceException {

    }

    public List<ResumeAchievementView> getAchievementsForResume(int resumeId) throws ServiceException {
        return null;
    }

    public void deleteAchievement(int achievementId) throws ServiceException {

    }

    /* ------------------------------------------------- */


    /* ------------------- Education ------------------- */

    public void addEducation(ResumeEducationView education) throws ServiceException {

    }

    public void updateEducation(int educationId, ResumeEducationView education) throws ServiceException {

    }

    public List<ResumeEducationView> getEducationsForResume(int resumeId) throws ServiceException {
        return null;
    }

    public void deleteEducation(int educationId) throws ServiceException {

    }

    /* ------------------------------------------------- */


    /* ------------- Additional education -------------- */

    public void addAdditionalEducation(ResumeAdditionalEducationView education) throws ServiceException {

    }

    public void updateAdditionalEducation(int educationId, ResumeAdditionalEducationView education) throws ServiceException {

    }

    public List<ResumeAdditionalEducationView> getAdditionalEducationsForResume(int resumeId) throws ServiceException {
        return null;
    }

    public void deleteAdditionalEducation(int educationId) throws ServiceException {

    }

    /* ------------------------------------------------- */


    /* ----------------- Contact info ------------------ */

    public void addContactInfo(ResumeContactInfoView contactInfo) throws ServiceException {

    }

    public void updateContactInfo(int contactInfoId, ResumeContactInfoView contactInfo) throws ServiceException {

    }

    public List<ResumeContactInfoView> getContactInfosForResume(int resumeId) throws ServiceException {
        return null;
    }

    public void deleteContactInfo(int contactInfoId) throws ServiceException {

    }

    /* ------------------------------------------------- */


    /* ------------------- Language -------------------- */

    public void addLanguage(ResumeLanguageView language) throws ServiceException {

    }

    public void updateLanguage(int languageId, ResumeLanguageView language) throws ServiceException {

    }

    public List<ResumeContactInfoView> getLanguagesForResume(int resumeId) throws ServiceException {
        return null;
    }

    public void deleteLanguage(int languageId) throws ServiceException {

    }

    /* ------------------------------------------------- */


    /* --------------------- Photo --------------------- */

    public void uploadPhoto(ResumePhotoView photo) throws ServiceException {

    }

    public List<ResumePhotoView> getPhotosForResume(int resumeId) throws ServiceException {
        return null;
    }

    public void deletePhoto(int photoId) throws ServiceException {

    }

    /* ------------------------------------------------- */


    /* ---------------- Work experience ---------------- */

    public void addWorkExperience(ResumeWorkExperienceView workExperience) throws ServiceException {

    }

    public void updateWorkExperience(int workExperienceId, ResumeWorkExperienceView workExperience) throws ServiceException {

    }

    public List<ResumeWorkExperienceView> getWorkExperiencesForResume(int resumeId) throws ServiceException {
        return null;
    }

    public void deleteWorkExperience(int workExperienceId) throws ServiceException {

    }

    /* ------------------------------------------------- */
}

