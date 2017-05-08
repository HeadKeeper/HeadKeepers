package com.headkeeper.service.impl;

import com.headkeeper.bean.entity.*;
import com.headkeeper.bean.view.*;
import com.headkeeper.dao.CertificateDAO;
import com.headkeeper.dao.ResumeDAO;
import com.headkeeper.dao.SkillDAO;
import com.headkeeper.dao.VacancyDAO;
import com.headkeeper.dao.exception.DAOException;
import com.headkeeper.service.LaborExchangeService;
import com.headkeeper.service.exception.ServiceException;
import com.headkeeper.service.util.Exchanger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
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
        }
        catch (DAOException e) {
            throw new ServiceException(e);
        }
        catch (Exception e) {
            try {
                vacancyDAO.addVacancy(new Vacancy(), 1);
            } catch (DAOException e1) {
                e1.printStackTrace();
            }
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
        try {
            UserResume resumeEntity = Exchanger.exchangeViewToEntity(resume);
            resumeDAO.addNewResume(resumeEntity);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void updateResume(int resumeId, UserResumeView resume) throws ServiceException {
        try {
            UserResume resumeEntity = Exchanger.exchangeViewToEntity(resume);
            resumeDAO.updateResume(resumeId, resumeEntity);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public UserResumeView getResume(int resumeId) throws ServiceException {
        try {
            UserResume resumeEntity = resumeDAO.getResumeById(resumeId);
            return Exchanger.exchangeEntityToView(resumeEntity);
        } catch (DAOException e) {
            throw new ServiceException(e);
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
            throw new ServiceException(e);
        }
    }

    public void setResumeStatus(int resumeId, boolean status) throws ServiceException {
        try {
            resumeDAO.updateResumeStatus(resumeId, status);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void deleteResume(int resumeId) throws ServiceException {
        try {
            resumeDAO.deleteResume(resumeId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    /* ------------------------------------------------- */


    /* --------------------- Skill --------------------- */

    public void createSkillForUser(int userId, SkillView skill) throws ServiceException {
        try {
            Skill skillEntity = Exchanger.exchangeViewToEntity(skill);
            skillDAO.addSkillToUser(userId, skillEntity);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void createSkillForVacancy(int vacancyId, SkillView skill) throws ServiceException {
        try {
            Skill skillEntity = Exchanger.exchangeViewToEntity(skill);
            skillDAO.addSkillToVacancy(vacancyId, skillEntity);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void updateSkill(int skillId, SkillView skill) throws ServiceException {
        try {
            Skill skillEntity = Exchanger.exchangeViewToEntity(skill);
            skillDAO.updateSkill(skillId, skillEntity);
        } catch (DAOException e) {
            throw new ServiceException(e);
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
            throw new ServiceException(e);
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
            throw new ServiceException(e);
        }
    }

    public void deleteSkill(int skillId) throws ServiceException {
        try {
            skillDAO.deleteSkill(skillId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    /* ------------------------------------------------- */


    /* ------------------ Certificate ------------------ */

    public void uploadCertificate(UserCertificateView certificate) throws ServiceException {
        try {
            int userId = certificate.getUser().getId();
            UserCertificate certificateEntity = Exchanger.exchangeViewToEntity(certificate);
            certificateDAO.addCertificate(userId, certificateEntity);
        } catch (DAOException e) {
            throw new ServiceException(e);
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
            throw new ServiceException(e);
        }
    }

    public void deleteCertificate(int certificateId) throws ServiceException {
        try {
            certificateDAO.deleteCertificate(certificateId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    /* ------------------------------------------------- */


    /* ------------------ Achievement ------------------ */

    public void addAchievement(ResumeAchievementView achievement) throws ServiceException {
        try {
            int resumeId = achievement.getUserResume().getId();
            ResumeAchievement achievementEntity = Exchanger.exchangeViewToEntity(achievement);
            resumeDAO.addResumeAchievement(achievementEntity, resumeId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void updateAchievement(int achievementId, ResumeAchievementView achievement) throws ServiceException {
        try {
            ResumeAchievement achievementEntity = Exchanger.exchangeViewToEntity(achievement);
            resumeDAO.updateResumeAchievement(achievementId, achievementEntity);
        } catch (DAOException e) {
            throw new ServiceException(e);
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
            throw new ServiceException(e);
        }
    }

    public void deleteAchievement(int achievementId) throws ServiceException {
        try {
            resumeDAO.deleteResumeAchievement(achievementId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    /* ------------------------------------------------- */


    /* ------------------- Education ------------------- */

    public void addEducation(ResumeEducationView education) throws ServiceException {
        try {
            int resumeId = education.getUserResume().getId();
            ResumeEducation educationEntity = Exchanger.exchangeViewToEntity(education);
            resumeDAO.addEducation(educationEntity, resumeId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void updateEducation(int educationId, ResumeEducationView education) throws ServiceException {
        try {
            ResumeEducation educationEntity = Exchanger.exchangeViewToEntity(education);
            resumeDAO.updateEducation(educationId, educationEntity);
        } catch (DAOException e) {
            throw new ServiceException(e);
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
            throw new ServiceException(e);
        }
    }

    public void deleteEducation(int educationId) throws ServiceException {
        try {
            resumeDAO.deleteEducation(educationId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    /* ------------------------------------------------- */


    /* ------------- Additional education -------------- */

    public void addAdditionalEducation(ResumeAdditionalEducationView education) throws ServiceException {
        try {
            int resumeId = education.getUserResume().getId();
            ResumeAdditionalEducation educationEntity = Exchanger.exchangeViewToEntity(education);
            resumeDAO.addAdditionalEducation(educationEntity, resumeId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void updateAdditionalEducation(int educationId, ResumeAdditionalEducationView education) throws ServiceException {
        try {
            ResumeAdditionalEducation educationEntity = Exchanger.exchangeViewToEntity(education);
            resumeDAO.updateAdditionalEducation(educationId, educationEntity);
        } catch (DAOException e) {
            throw new ServiceException(e);
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
            throw new ServiceException(e);
        }
    }

    public void deleteAdditionalEducation(int educationId) throws ServiceException {
        try {
            resumeDAO.deleteAdditionalEducation(educationId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    /* ------------------------------------------------- */


    /* ----------------- Contact info ------------------ */

    public void addContactInfo(ResumeContactInfoView contactInfo) throws ServiceException {
        try {
            int resumeId = contactInfo.getUserResume().getId();
            ResumeContactInfo contactInfoEntity = Exchanger.exchangeViewToEntity(contactInfo);
            resumeDAO.addContactInfo(contactInfoEntity, resumeId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void updateContactInfo(int contactInfoId, ResumeContactInfoView contactInfo) throws ServiceException {
        try {
            ResumeContactInfo contactInfoEntity = Exchanger.exchangeViewToEntity(contactInfo);
            resumeDAO.updateContactInfo(contactInfoId, contactInfoEntity);
        } catch (DAOException e) {
            throw new ServiceException(e);
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
            throw new ServiceException(e);
        }
    }

    public void deleteContactInfo(int contactInfoId) throws ServiceException {
        try {
            resumeDAO.deleteContactInfo(contactInfoId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    /* ------------------------------------------------- */


    /* ------------------- Language -------------------- */

    public void addLanguage(ResumeLanguageView language) throws ServiceException {
        try {
            int resumeId = language.getUserResume().getId();
            ResumeLanguage languageEntity = Exchanger.exchangeViewToEntity(language);
            resumeDAO.addLanguage(languageEntity, resumeId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void updateLanguage(int languageId, ResumeLanguageView language) throws ServiceException {
        try {
            ResumeLanguage languageEntity = Exchanger.exchangeViewToEntity(language);
            resumeDAO.updateLanguage(languageId, languageEntity);
        } catch (DAOException e) {
            throw new ServiceException(e);
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
            throw new ServiceException(e);
        }
    }

    public void deleteLanguage(int languageId) throws ServiceException {
        try {
            resumeDAO.deleteLanguage(languageId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    /* ------------------------------------------------- */


    /* --------------------- Photo --------------------- */

    public void uploadPhoto(ResumePhotoView photo) throws ServiceException {
        try {
            int resumeId = photo.getUserResume().getId();
            ResumePhoto resumePhotoEntity = Exchanger.exchangeViewToEntity(photo);
            resumeDAO.addPhoto(resumePhotoEntity, resumeId);
        } catch (DAOException e) {
            throw new ServiceException(e);
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
            throw new ServiceException(e);
        }
    }

    public void deletePhoto(int photoId) throws ServiceException {
        try {
            resumeDAO.deletePhoto(photoId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    /* ------------------------------------------------- */


    /* ---------------- Work experience ---------------- */

    public void addWorkExperience(ResumeWorkExperienceView workExperience) throws ServiceException {
        try {
            int resumeId = workExperience.getUserResume().getId();
            ResumeWorkExperience workExperienceEntity = Exchanger.exchangeViewToEntity(workExperience);
            resumeDAO.addWorkExperience(workExperienceEntity, resumeId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void updateWorkExperience(int workExperienceId, ResumeWorkExperienceView workExperience) throws ServiceException {
        try {
            ResumeWorkExperience workExperienceEntity = Exchanger.exchangeViewToEntity(workExperience);
            resumeDAO.updateWorkExperience(workExperienceId, workExperienceEntity);
        } catch (DAOException e) {
            throw new ServiceException(e);
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
            throw new ServiceException(e);
        }
    }

    public void deleteWorkExperience(int workExperienceId) throws ServiceException {
        try {
            resumeDAO.deleteWorkExperience(workExperienceId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    /* ------------------------------------------------- */
}

