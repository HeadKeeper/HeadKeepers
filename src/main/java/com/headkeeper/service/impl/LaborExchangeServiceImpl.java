package com.headkeeper.service.impl;

import com.headkeeper.bean.entity.*;
import com.headkeeper.bean.view.*;
import com.headkeeper.dao.CertificateDAO;
import com.headkeeper.dao.ResumeDAO;
import com.headkeeper.dao.SkillDAO;
import com.headkeeper.dao.VacancyDAO;
import com.headkeeper.dao.exception.DAOException;
import com.headkeeper.dao.exception.ExistsDAOException;
import com.headkeeper.dao.exception.NotFoundDAOException;
import com.headkeeper.dao.util.DataExchanger;
import com.headkeeper.service.LaborExchangeService;
import com.headkeeper.service.exception.ExistsServiceException;
import com.headkeeper.service.exception.NotFoundServiceException;
import com.headkeeper.service.exception.ServiceException;
import com.headkeeper.service.util.Exchanger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
public class LaborExchangeServiceImpl implements LaborExchangeService {

    private final VacancyDAO vacancyDAO;
    private final ResumeDAO resumeDAO;
    private final SkillDAO skillDAO;
    private final CertificateDAO certificateDAO;

    @Autowired
    public LaborExchangeServiceImpl(VacancyDAO vacancyDAO, ResumeDAO resumeDAO, SkillDAO skillDAO,
                                    CertificateDAO certificateDAO) {
        this.vacancyDAO = vacancyDAO;
        this.resumeDAO = resumeDAO;
        this.skillDAO = skillDAO;
        this.certificateDAO = certificateDAO;
    }

    /* -------------------- Vacancy -------------------- */

    public void createVacancy(VacancyView vacancy) throws ServiceException {
        try {
            Vacancy vacancyEntity = Exchanger.exchangeViewToEntity(vacancy);
            vacancyDAO.addVacancy(vacancyEntity, vacancy.getUser().getId());
        } catch (ExistsDAOException e) {
            throw new ExistsServiceException("Vacancy already exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while creating vacancy", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    public void updateVacancy(int id, VacancyView vacancy) throws ServiceException {
        try {
            Vacancy vacancyEntity = Exchanger.exchangeViewToEntity(vacancy);

            vacancyDAO.updateVacancy(id, vacancyEntity);
        } catch (NotFoundDAOException e) {
            throw new NotFoundServiceException("Vacancy doesn't exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while updating vacancy", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    public VacancyView getVacancy(int id) throws ServiceException {
        try {
            Vacancy vacancyEntity = vacancyDAO.getVacancyById(id);

            return Exchanger.exchangeEntityToView(vacancyEntity);
        } catch (NotFoundDAOException e) {
            throw new NotFoundServiceException("Vacancy doesn't exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while updating vacancy", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
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
            throw new ServiceException("Something went wrong while updating vacancy", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
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
            throw new ServiceException("Something went wrong while updating vacancy", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    public List<VacancyView> getVacanciesByTitle(String title) throws ServiceException {
        try {
            List<Vacancy> list = vacancyDAO.getVacanciesByTitle(title);
            List<VacancyView> viewList = new ArrayList<>();
            for (Vacancy vacancy : list) {
                viewList.add(Exchanger.exchangeEntityToView(vacancy));
            }
            return viewList;
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while updating vacancy", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    public CompanyInfoView getCompanyByCompanyName(String companyName) throws ServiceException {
        try {
            return Exchanger.exchangeViewToEntity(vacancyDAO.getCompanyByCompanyName(companyName));
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while updating vacancy", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    public void setVacancyActiveStatus(int id, boolean status) throws ServiceException {
        try {
            vacancyDAO.updateVacancy(id, status);
        } catch (NotFoundDAOException e) {
            throw new NotFoundServiceException("Vacancy doesn't exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while updating vacancy", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    public void deleteVacancy(int id) throws ServiceException {
        try {
            vacancyDAO.deleteVacancy(id);
        } catch (NotFoundDAOException e) {
            throw new NotFoundServiceException("Vacancy doesn't exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while updating vacancy", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    /* ------------------------------------------------- */


    /* -------------------- Resume --------------------- */

    public void createResume(UserResumeView resume) throws ServiceException {
        try {
            UserResume resumeEntity = Exchanger.exchangeViewToEntity(resume);
            resumeDAO.addNewResume(resumeEntity);
        } catch (ExistsDAOException e) {
            throw new ExistsServiceException("Resume already exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while creating resume", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    public void updateResume(int resumeId, UserResumeView resume) throws ServiceException {
        try {
            UserResume resumeEntity = Exchanger.exchangeViewToEntity(resume);
            resumeDAO.updateResume(resumeId, resumeEntity);
        } catch (NotFoundDAOException e) {
            throw new NotFoundServiceException("Resume doesn't exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while updating resume", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    public UserResumeView getResume(int resumeId) throws ServiceException {
        try {
            UserResume resumeEntity = resumeDAO.getResumeById(resumeId);
            return Exchanger.exchangeEntityToView(resumeEntity);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while updating resume", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    public List<UserResumeView> getResumesForUser(int userId) throws ServiceException {
        try {
            List<UserResume> resumes = resumeDAO.getResumeForUser(userId);
            List<UserResumeView> views = new ArrayList<UserResumeView>();

            for (UserResume resumeEntity : resumes) {
                UserResumeView resumeView = Exchanger.exchangeEntityToView(resumeEntity);
                views.add(resumeView);
            }

            return views;
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while updating resume", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    public void setResumeStatus(int resumeId, boolean status) throws ServiceException {
        try {
            resumeDAO.updateResumeStatus(resumeId, status);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while updating resume", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    public void deleteResume(int resumeId) throws ServiceException {
        try {
            resumeDAO.deleteResume(resumeId);
        } catch (NotFoundDAOException e) {
            throw new NotFoundServiceException("Resume doesn't exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while updating resume", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    /* ------------------------------------------------- */


    /* --------------------- Skill --------------------- */

    public void createSkillForUser(int userId, SkillView skill) throws ServiceException {
        try {
            Skill skillEntity = Exchanger.exchangeViewToEntity(skill);
            skillDAO.addSkillToUser(userId, skillEntity);
        } catch (ExistsDAOException e) {
            throw new ExistsServiceException("Skill already exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while adding skill to user", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    public void createSkillForVacancy(int vacancyId, SkillView skill) throws ServiceException {
        try {
            Skill skillEntity = Exchanger.exchangeViewToEntity(skill);
            skillDAO.addSkillToVacancy(vacancyId, skillEntity);
        } catch (ExistsDAOException e) {
            throw new ExistsServiceException("Skill already exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while adding skill to user", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    public void updateSkill(int skillId, SkillView skill) throws ServiceException {
        try {
            Skill skillEntity = Exchanger.exchangeViewToEntity(skill);
            skillDAO.updateSkill(skillId, skillEntity);
        } catch (NotFoundDAOException e) {
            throw new NotFoundServiceException("Skill doesn't exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while updating skill", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    public List<SkillView> getSkillsForUser(int userId) throws ServiceException {
        try {
            List<Skill> skillEntities = skillDAO.getSkillsForUser(userId);
            List<SkillView> skillViews = new ArrayList<SkillView>();

            for (Skill skillEntity : skillEntities) {
                SkillView skillView = Exchanger.exchangeEntityToView(skillEntity);
                skillViews.add(skillView);
            }

            return skillViews;
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while updating skill", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    public List<SkillView> getSkillsForVacancy(int vacancyId) throws ServiceException {
        try {
            List<Skill> skillEntities = skillDAO.getSkillsForVacancy(vacancyId);
            List<SkillView> skillViews = new ArrayList<SkillView>();

            for (Skill skillEntity : skillEntities) {
                SkillView skillView = Exchanger.exchangeEntityToView(skillEntity);
                skillViews.add(skillView);
            }

            return skillViews;
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while updating skill", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    public void deleteSkill(int skillId) throws ServiceException {
        try {
            skillDAO.deleteSkill(skillId);
        } catch (NotFoundDAOException e) {
            throw new NotFoundServiceException("Skill doesn't exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while updating skill", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    /* ------------------------------------------------- */


    /* ------------------ Certificate ------------------ */

    public void uploadCertificate(UserCertificateView certificate) throws ServiceException {
        try {
            int userId = certificate.getUser().getId();
            UserCertificate certificateEntity = Exchanger.exchangeViewToEntity(certificate);
            certificateDAO.addCertificate(userId, certificateEntity);
        } catch (ExistsDAOException e) {
            throw new ExistsServiceException("Certificate already exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while updating skill", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    public List<UserCertificateView> getCetificatesForUser(int userId) throws ServiceException {
        try {
            List<UserCertificate> entities = certificateDAO.getCertificatesForUser(userId);
            List<UserCertificateView> views = new ArrayList<UserCertificateView>();

            for (UserCertificate certificateEntity : entities) {
                UserCertificateView certificateView = Exchanger.exchangeEntityToView(certificateEntity);
                views.add(certificateView);
            }

            return views;
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while updating skill", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    public void deleteCertificate(int certificateId) throws ServiceException {
        try {
            certificateDAO.deleteCertificate(certificateId);
        } catch (NotFoundDAOException e) {
            throw new NotFoundServiceException("Skill doesn't exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while updating skill", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    /* ------------------------------------------------- */


    /* ------------------ Achievement ------------------ */

    public void addAchievement(ResumeAchievementView achievement) throws ServiceException {
        try {
            int resumeId = achievement.getUserResume().getId();
            ResumeAchievement achievementEntity = Exchanger.exchangeViewToEntity(achievement);
            resumeDAO.addResumeAchievement(achievementEntity, resumeId);
        } catch (ExistsDAOException e) {
            throw new ExistsServiceException("Achievement already exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while updating skill", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    public void updateAchievement(int achievementId, ResumeAchievementView achievement) throws ServiceException {
        try {
            ResumeAchievement achievementEntity = Exchanger.exchangeViewToEntity(achievement);
            resumeDAO.updateResumeAchievement(achievementId, achievementEntity);
        } catch (NotFoundDAOException e) {
            throw new NotFoundServiceException("Skill doesn't exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while updating skill", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    public List<ResumeAchievementView> getAchievementsForResume(int resumeId) throws ServiceException {
        try {
            List<ResumeAchievement> entities = resumeDAO.getResumeAchievements(resumeId);
            List<ResumeAchievementView> views = new ArrayList<ResumeAchievementView>();

            for (ResumeAchievement achievementEntity : entities) {
                ResumeAchievementView achievementView = Exchanger.exchangeEntityToView(achievementEntity);
                views.add(achievementView);
            }

            return views;
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while updating skill", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    public void deleteAchievement(int achievementId) throws ServiceException {
        try {
            resumeDAO.deleteResumeAchievement(achievementId);
        } catch (NotFoundDAOException e) {
            throw new NotFoundServiceException("Skill doesn't exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while updating skill", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    /* ------------------------------------------------- */


    /* ------------------- Education ------------------- */

    public void addEducation(ResumeEducationView education) throws ServiceException {
        try {
            int resumeId = education.getUserResume().getId();
            ResumeEducation educationEntity = Exchanger.exchangeViewToEntity(education);
            resumeDAO.addEducation(educationEntity, resumeId);
        } catch (ExistsDAOException e) {
            throw new ExistsServiceException("Education already exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while updating skill", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    public void updateEducation(int educationId, ResumeEducationView education) throws ServiceException {
        try {
            ResumeEducation educationEntity = Exchanger.exchangeViewToEntity(education);
            resumeDAO.updateEducation(educationId, educationEntity);
        } catch (NotFoundDAOException e) {
            throw new NotFoundServiceException("Skill doesn't exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while updating skill", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    public List<ResumeEducationView> getEducationsForResume(int resumeId) throws ServiceException {
        try {
            List<ResumeEducation> entities = resumeDAO.getResumeEducations(resumeId);
            List<ResumeEducationView> views = new ArrayList<ResumeEducationView>();

            for (ResumeEducation educationEntity : entities) {
                ResumeEducationView educationView = Exchanger.exchangeEntityToView(educationEntity);
                views.add(educationView);
            }

            return views;
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while updating skill", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    public void deleteEducation(int educationId) throws ServiceException {
        try {
            resumeDAO.deleteEducation(educationId);
        } catch (NotFoundDAOException e) {
            throw new NotFoundServiceException("Skill doesn't exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while updating skill", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    /* ------------------------------------------------- */


    /* ------------- Additional education -------------- */

    public void addAdditionalEducation(ResumeAdditionalEducationView education) throws ServiceException {
        try {
            int resumeId = education.getUserResume().getId();
            ResumeAdditionalEducation educationEntity = Exchanger.exchangeViewToEntity(education);
            resumeDAO.addAdditionalEducation(educationEntity, resumeId);
        } catch (ExistsDAOException e) {
            throw new ExistsServiceException("Additional education already exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while updating skill", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    public void updateAdditionalEducation(int educationId, ResumeAdditionalEducationView education) throws ServiceException {
        try {
            ResumeAdditionalEducation educationEntity = Exchanger.exchangeViewToEntity(education);
            resumeDAO.updateAdditionalEducation(educationId, educationEntity);
        } catch (NotFoundDAOException e) {
            throw new NotFoundServiceException("Skill doesn't exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while updating skill", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    public List<ResumeAdditionalEducationView> getAdditionalEducationsForResume(int resumeId) throws ServiceException {
        try {
            List<ResumeAdditionalEducation> entities = resumeDAO.getAdditionalEducations(resumeId);
            List<ResumeAdditionalEducationView> views = new ArrayList<ResumeAdditionalEducationView>();

            for (ResumeAdditionalEducation educationEntity : entities) {
                ResumeAdditionalEducationView educationView = Exchanger.exchangeEntityToView(educationEntity);
                views.add(educationView);
            }

            return views;
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while updating skill", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    public void deleteAdditionalEducation(int educationId) throws ServiceException {
        try {
            resumeDAO.deleteAdditionalEducation(educationId);
        } catch (NotFoundDAOException e) {
            throw new NotFoundServiceException("Skill doesn't exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while updating skill", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    /* ------------------------------------------------- */


    /* ----------------- Contact info ------------------ */

    public void addContactInfo(ResumeContactInfoView contactInfo) throws ServiceException {
        try {
            int resumeId = contactInfo.getUserResume().getId();
            ResumeContactInfo contactInfoEntity = Exchanger.exchangeViewToEntity(contactInfo);
            resumeDAO.addContactInfo(contactInfoEntity, resumeId);
        } catch (ExistsDAOException e) {
            throw new ExistsServiceException("This contact info already exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while updating skill", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    public void updateContactInfo(int contactInfoId, ResumeContactInfoView contactInfo) throws ServiceException {
        try {
            ResumeContactInfo contactInfoEntity = Exchanger.exchangeViewToEntity(contactInfo);
            resumeDAO.updateContactInfo(contactInfoId, contactInfoEntity);
        } catch (NotFoundDAOException e) {
            throw new NotFoundServiceException("Skill doesn't exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while updating skill", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    public List<ResumeContactInfoView> getContactInfosForResume(int resumeId) throws ServiceException {
        try {
            List<ResumeContactInfo> entities = resumeDAO.getContactInfo(resumeId);
            List<ResumeContactInfoView> views = new ArrayList<ResumeContactInfoView>();

            for (ResumeContactInfo contactInfoEntity : entities) {
                ResumeContactInfoView contactInfoView = Exchanger.exchangeEntityToView(contactInfoEntity);
                views.add(contactInfoView);
            }

            return views;
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while updating skill", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    public void deleteContactInfo(int contactInfoId) throws ServiceException {
        try {
            resumeDAO.deleteContactInfo(contactInfoId);
        } catch (NotFoundDAOException e) {
            throw new NotFoundServiceException("Skill doesn't exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while updating skill", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    /* ------------------------------------------------- */


    /* ------------------- Language -------------------- */

    public void addLanguage(ResumeLanguageView language) throws ServiceException {
        try {
            int resumeId = language.getUserResume().getId();
            ResumeLanguage languageEntity = Exchanger.exchangeViewToEntity(language);
            resumeDAO.addLanguage(languageEntity, resumeId);
        } catch (ExistsDAOException e) {
            throw new ExistsServiceException("Language already exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while updating skill", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    public void updateLanguage(int languageId, ResumeLanguageView language) throws ServiceException {
        try {
            ResumeLanguage languageEntity = Exchanger.exchangeViewToEntity(language);
            resumeDAO.updateLanguage(languageId, languageEntity);
        } catch (NotFoundDAOException e) {
            throw new NotFoundServiceException("Skill doesn't exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while updating skill", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    public List<ResumeLanguageView> getLanguagesForResume(int resumeId) throws ServiceException {
        try {
            List<ResumeLanguage> entities = resumeDAO.getResumeLanguages(resumeId);
            List<ResumeLanguageView> views = new ArrayList<ResumeLanguageView>();

            for (ResumeLanguage resumeLanguageEntity : entities) {
                ResumeLanguageView languageView = Exchanger.exchangeEntityToView(resumeLanguageEntity);
                views.add(languageView);
            }

            return views;
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while updating skill", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    public void deleteLanguage(int languageId) throws ServiceException {
        try {
            resumeDAO.deleteLanguage(languageId);
        } catch (NotFoundDAOException e) {
            throw new NotFoundServiceException("Skill doesn't exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while updating skill", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    /* ------------------------------------------------- */


    /* --------------------- Photo --------------------- */

    public void uploadPhoto(ResumePhotoView photo) throws ServiceException {
        try {
            int resumeId = photo.getUserResume().getId();
            ResumePhoto resumePhotoEntity = Exchanger.exchangeViewToEntity(photo);
            resumeDAO.addPhoto(resumePhotoEntity, resumeId);
        } catch (ExistsDAOException e) {
            throw new ExistsServiceException("Photo is already uploaded", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while updating skill", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    public List<ResumePhotoView> getPhotosForResume(int resumeId) throws ServiceException {
        try {
            List<ResumePhoto> entities = resumeDAO.getResumePhotos(resumeId);
            List<ResumePhotoView> views = new ArrayList<ResumePhotoView>();

            for (ResumePhoto photoEntity : entities) {
                ResumePhotoView photoView = Exchanger.exchangeEntityToView(photoEntity);
                views.add(photoView);
            }

            return views;
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while updating skill", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    public void deletePhoto(int photoId) throws ServiceException {
        try {
            resumeDAO.deletePhoto(photoId);
        } catch (NotFoundDAOException e) {
            throw new NotFoundServiceException("Skill doesn't exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while updating skill", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    /* ------------------------------------------------- */


    /* ---------------- Work experience ---------------- */

    public void addWorkExperience(ResumeWorkExperienceView workExperience) throws ServiceException {
        try {
            int resumeId = workExperience.getUserResume().getId();
            ResumeWorkExperience workExperienceEntity = Exchanger.exchangeViewToEntity(workExperience);
            resumeDAO.addWorkExperience(workExperienceEntity, resumeId);
        } catch (ExistsDAOException e) {
            throw new ExistsServiceException("This work experience is already added", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while updating skill", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    public void updateWorkExperience(int workExperienceId, ResumeWorkExperienceView workExperience) throws ServiceException {
        try {
            ResumeWorkExperience workExperienceEntity = Exchanger.exchangeViewToEntity(workExperience);
            resumeDAO.updateWorkExperience(workExperienceId, workExperienceEntity);
        } catch (NotFoundDAOException e) {
            throw new NotFoundServiceException("Skill doesn't exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while updating skill", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    public List<ResumeWorkExperienceView> getWorkExperiencesForResume(int resumeId) throws ServiceException {
        try {
            List<ResumeWorkExperience> entities = resumeDAO.getResumeWorkExperiences(resumeId);
            List<ResumeWorkExperienceView> views = new ArrayList<ResumeWorkExperienceView>();

            for (ResumeWorkExperience workExperienceEntity : entities) {
                ResumeWorkExperienceView workExperienceView = Exchanger.exchangeEntityToView(workExperienceEntity);
                views.add(workExperienceView);
            }

            return views;
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while updating skill", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    public void deleteWorkExperience(int workExperienceId) throws ServiceException {
        try {
            resumeDAO.deleteWorkExperience(workExperienceId);
        } catch (NotFoundDAOException e) {
            throw new NotFoundServiceException("Skill doesn't exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while updating skill", e);
        } catch (HibernateException e) {
            throw new ServiceException("Storage exception", e);
        }
    }

    /* ------------------------------------------------- */
}

