package com.headkeeper.dao.impl;

import com.headkeeper.bean.entity.*;
import com.headkeeper.dao.ResumeDAO;
import com.headkeeper.dao.exception.DAOException;
import com.headkeeper.dao.util.DataExchanger;
import com.headkeeper.dao.util.EntityPreprocessor;
import com.sun.javafx.binding.StringFormatter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.crypto.Data;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Set;

@Transactional
@Repository
public class ResumeDAOImpl implements ResumeDAO {

    private static final String USER_RESUME_ENTITY_NAME = "UserResume";
    private static final String LANGUAGE_ENTITY_NAME = "ResumeLanguage";
    private static final String EDUCATION_ENTITY_NAME = "ResumeEducation";
    private static final String CONTACT_INFO_ENTITY_NAME = "ResumeContactInfo";
    private static final String WORK_EXPERIENCE_ENTITY_NAME = "ResumeWorkExperience";
    private static final String ADDITIONAL_EDUCATION_ENTITY_NAME = "ResumeAdditionalEducation";
    private static final String PHOTO_ENTITY_NAME = "ResumePhoto";
    private static final String ACHIEVEMENT_ENTITY_NAME = "ResumeAchievement";



    private final SessionFactory sessionFactory;

    @Autowired
    public ResumeDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /* CRUD OPERATIONS */

    // -------------------------------- CREATE -------------------------------------------

    public void addNewResume(UserResume resume) throws DAOException {
        /* USER_ID FK (resume.userId) it should be packed on the user side */
        try {
            Session session = sessionFactory.getCurrentSession();
            session.save(resume);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("This user already exist.");
        }
    }

    public void addResumeAchievement(ResumeAchievement achievement, int resumeId) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            UserResume userResume = session.load(UserResume.class, resumeId);
            EntityPreprocessor.checkEntityOnExist(USER_RESUME_ENTITY_NAME, resumeId, session);
            userResume.getResumeAchievements().add(achievement);
            session.update(userResume);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find resume with id = " + resumeId);
        }
    }

    public void addAdditionalEducation(ResumeAdditionalEducation additionalEducation, int resumeId) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            UserResume userResume = session.load(UserResume.class, resumeId);
            EntityPreprocessor.checkEntityOnExist(USER_RESUME_ENTITY_NAME, resumeId, session);
            userResume.getResumeAdditionalEducations().add(additionalEducation);
            session.update(userResume);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find resume with id = " + resumeId);
        }
    }

    public void addContactInfo(ResumeContactInfo contactInfo, int resumeId) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            UserResume userResume = session.load(UserResume.class, resumeId);
            EntityPreprocessor.checkEntityOnExist(USER_RESUME_ENTITY_NAME, resumeId, session);
            userResume.getResumeContactInfos().add(contactInfo);
            session.update(userResume);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find resume with id = " + resumeId);
        }
    }

    public void addEducation(ResumeEducation education, int resumeId) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            UserResume userResume = session.load(UserResume.class, resumeId);
            EntityPreprocessor.checkEntityOnExist(USER_RESUME_ENTITY_NAME, resumeId, session);
            userResume.getResumeEducations().add(education);
            session.update(userResume);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find resume with id = " + resumeId);
        }
    }

    public void addLanguage(ResumeLanguage language, int resumeId) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            UserResume userResume = session.load(UserResume.class, resumeId);
            EntityPreprocessor.checkEntityOnExist(USER_RESUME_ENTITY_NAME, resumeId, session);
            userResume.getResumeLanguages().add(language);
            session.update(userResume);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find resume with id = " + resumeId);
        }
    }

    public void addPhoto(ResumePhoto photo, int resumeId) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            UserResume userResume = session.load(UserResume.class, resumeId);
            EntityPreprocessor.checkEntityOnExist(USER_RESUME_ENTITY_NAME, resumeId, session);
            userResume.getResumePhotos().add(photo);
            session.update(userResume);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find resume with id = " + resumeId);
        }
    }

    public void addWorkExperience(ResumeWorkExperience workExperience, int resumeId) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            UserResume userResume = session.load(UserResume.class, resumeId);
            EntityPreprocessor.checkEntityOnExist(USER_RESUME_ENTITY_NAME, resumeId, session);
            userResume.getResumeWorkExperiences().add(workExperience);
            session.update(userResume);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find resume with id = " + resumeId);
        }
    }

    // -------------------------------- READ ---------------------------------------------

    public UserResume getResumeById(int id) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            UserResume userResume = session.get(UserResume.class, id);
            if (userResume == null) {
                throw new DAOException("Can't find resume with id = " + id);
            }
            return userResume;
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
    }

    public List<ResumeAchievement> getResumeAchievements(int id) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            UserResume resume = session.get(UserResume.class, id);
            if (resume == null) {
                throw new DAOException("Can't find resume with id = " + id);
            }
            List<ResumeAchievement> achievements = new ArrayList<ResumeAchievement>();
            achievements.addAll(resume.getResumeAchievements());
            return achievements;
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
    }

    public List<ResumeAdditionalEducation> getAdditionalEducations(int id) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            UserResume resume = session.get(UserResume.class, id);
            if (resume == null) {
                throw new DAOException("Can't find resume with id = " + id);
            }
            List<ResumeAdditionalEducation> additionalEducations = new ArrayList<ResumeAdditionalEducation>();
            additionalEducations.addAll(resume.getResumeAdditionalEducations());
            return additionalEducations;
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
    }

    public List<ResumeContactInfo> getContactInfo(int id) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            UserResume resume = session.get(UserResume.class, id);
            if (resume == null) {
                throw new DAOException("Can't find resume with id = " + id);
            }
            List<ResumeContactInfo> contactInfos = new ArrayList<ResumeContactInfo>();
            contactInfos.addAll(resume.getResumeContactInfos());
            return contactInfos;
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
    }

    public List<ResumeEducation> getResumeEducations(int id) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            UserResume resume = session.get(UserResume.class, id);
            if (resume == null) {
                throw new DAOException("Can't find resume with id = " + id);
            }
            List<ResumeEducation> educations = new ArrayList<ResumeEducation>();
            educations.addAll(resume.getResumeEducations());
            return educations;
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
    }

    public List<ResumeLanguage> getResumeLanguages(int id) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            UserResume resume = session.get(UserResume.class, id);
            if (resume == null) {
                throw new DAOException("Can't find resume with id = " + id);
            }
            List<ResumeLanguage> languages = new ArrayList<ResumeLanguage>();
            languages.addAll(resume.getResumeLanguages());
            return languages;
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
    }

    public List<ResumePhoto> getResumePhotos(int id) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            UserResume resume = session.get(UserResume.class, id);
            if (resume == null) {
                throw new DAOException("Can't find resume with id = " + id);
            }
            List<ResumePhoto> photos = new ArrayList<ResumePhoto>();
            photos.addAll(resume.getResumePhotos());
            return photos;
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
    }

    public List<ResumeWorkExperience> getResumeWorkExperience(int id) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            List<ResumeWorkExperience> workExperiences = session.createQuery(
                    "from ResumeWorkExperience where ResumeWorkExperience.userResumeByUserResumeId.id = " + id
            ).list();
            return workExperiences;
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find user with id = " + id);
        }
    }

    @Override
    public List<UserResume> getResumeForUser(int userId) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            List<UserResume> userResumes = session.createQuery(
                    "from UserResume where UserResume.user.id = " + userId
            ).list();
            return userResumes;
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find user with id = " + userId);
        }
    }

    public List<ResumeWorkExperience> getResumeWorkExperiences(int id) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            UserResume resume = session.get(UserResume.class, id);
            if (resume == null) {
                throw new DAOException("Can't find resume with id = " + id);
            }
            List<ResumeWorkExperience> workExperiences = new ArrayList<ResumeWorkExperience>();
            workExperiences.addAll(resume.getResumeWorkExperiences());
            return workExperiences;
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
    }

    // -------------------------------- UPDATE -------------------------------------------

    public void updateResumeStatus(int resumeId, boolean status) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            UserResume resume = session.load(UserResume.class, resumeId);
            EntityPreprocessor.checkEntityOnExist(USER_RESUME_ENTITY_NAME, resumeId, session);
            resume.setIsActive(status);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find resume with id = " + resumeId);
        }
    }

    public void updateResume(int resumeId, UserResume resume) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            UserResume oldResume = session.load(UserResume.class, resumeId);
            EntityPreprocessor.checkEntityOnExist(USER_RESUME_ENTITY_NAME, resumeId, session);;
            DataExchanger.replaceResumeData(oldResume, resume);
            session.merge(oldResume);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find resume with id = " + resumeId);
        }
    }

    public void updateLanguage(int languageId, ResumeLanguage language) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            ResumeLanguage oldLanguage = session.load(ResumeLanguage.class, languageId);
            EntityPreprocessor.checkEntityOnExist(LANGUAGE_ENTITY_NAME, languageId, session);
            oldLanguage.setLanguage(language.getLanguage());
            oldLanguage.setLevel(language.getLevel());
            session.merge(oldLanguage);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find language with id = " + languageId);
        }
    }

    public void updateWorkExperience(int workExperienceId, ResumeWorkExperience workExperience) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            ResumeWorkExperience oldWorkExperience = session.load(ResumeWorkExperience.class, workExperienceId);
            EntityPreprocessor.checkEntityOnExist(WORK_EXPERIENCE_ENTITY_NAME, workExperienceId, session);
            DataExchanger.replaceWorkExperienceData(oldWorkExperience, workExperience);
            session.merge(oldWorkExperience);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find work experience with id = " + workExperienceId);
        }
    }

    public void updateResumeAchievement(int achievementId, ResumeAchievement resumeAchievement) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            ResumeAchievement oldResumeAchievement = session.load(ResumeAchievement.class, achievementId);
            EntityPreprocessor.checkEntityOnExist(WORK_EXPERIENCE_ENTITY_NAME, achievementId, session);
            DataExchanger.replaceResumeAchievementData(oldResumeAchievement, resumeAchievement);
            session.merge(oldResumeAchievement);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find achievement with id = " + achievementId);
        }
    }

    public void updateAdditionalEducation(int additionalEducationId, ResumeAdditionalEducation additionalEducation) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            ResumeAdditionalEducation oldAdditionalEducation = session.load(
                    ResumeAdditionalEducation.class,
                    additionalEducationId
            );
            EntityPreprocessor.checkEntityOnExist(ADDITIONAL_EDUCATION_ENTITY_NAME, additionalEducationId, session);
            DataExchanger.replaceAdditionalEducation(oldAdditionalEducation, additionalEducation);
            session.merge(oldAdditionalEducation);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find additional education with id = " + additionalEducationId);
        }
    }


    public void updateContactInfo(int contactInfoId, ResumeContactInfo contactInfo) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            ResumeContactInfo oldContactInfo = session.load(ResumeContactInfo.class, contactInfoId);
            EntityPreprocessor.checkEntityOnExist(CONTACT_INFO_ENTITY_NAME, contactInfoId, session);
            DataExchanger.replaceContactInfo(oldContactInfo, contactInfo);
            session.merge(oldContactInfo);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find contact info with id = " + contactInfoId);
        }
    }


    public void updateEducation(int educationId, ResumeEducation education) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            ResumeEducation oldEducation = session.load(ResumeEducation.class, educationId);
            EntityPreprocessor.checkEntityOnExist(EDUCATION_ENTITY_NAME, educationId, session);
            DataExchanger.replaceEducation(oldEducation, education);
            session.merge(oldEducation);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find education with id = " + educationId);
        }
    }


    public void updatePhoto(int photoId, ResumePhoto photo) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            ResumePhoto oldPhoto = session.load(ResumePhoto.class, photoId);
            EntityPreprocessor.checkEntityOnExist(PHOTO_ENTITY_NAME, photoId, session);
            DataExchanger.replacePhoto(oldPhoto, photo);
            session.merge(oldPhoto);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find photo with id = " + photoId);
        }
    }

    // -------------------------------- DELETE -------------------------------------------

    public void deleteResume(int id) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            EntityPreprocessor.checkEntityOnExist(USER_RESUME_ENTITY_NAME, id, session);
            UserResume resume = session.load(UserResume.class, id);
            session.delete(resume);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find resume with id = " + id);
        }
    }

    public void deleteResumeAchievement(int achievementId) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            EntityPreprocessor.checkEntityOnExist(ACHIEVEMENT_ENTITY_NAME, achievementId, session);
            ResumeAchievement resumeAchievement = session.load(ResumeAchievement.class, achievementId);
            session.delete(resumeAchievement);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find achivement with id = " + achievementId);
        }
    }

    public void deleteAdditionalEducation(int additionalEducationId) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            EntityPreprocessor.checkEntityOnExist(ADDITIONAL_EDUCATION_ENTITY_NAME, additionalEducationId, session);
            ResumeAdditionalEducation additionalEducation = session.load(
                    ResumeAdditionalEducation.class,
                    additionalEducationId
            );
            session.delete(additionalEducation);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find additioncal education with id = " + additionalEducationId);
        }
    }

    public void deleteContactInfo(int contactInfoId) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            EntityPreprocessor.checkEntityOnExist(CONTACT_INFO_ENTITY_NAME, contactInfoId, session);
            ResumeContactInfo contactInfo = session.load(ResumeContactInfo.class, contactInfoId);
            session.delete(contactInfo);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find contact info with id = " + contactInfoId);
        }
     }

    public void deleteEducation(int educationId) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            EntityPreprocessor.checkEntityOnExist(EDUCATION_ENTITY_NAME, educationId, session);
            ResumeEducation education = session.load(ResumeEducation.class, educationId);
            session.delete(education);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find education with id = " + educationId);
        }
    }

    public void deleteLanguage(int languageId) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            EntityPreprocessor.checkEntityOnExist(LANGUAGE_ENTITY_NAME, languageId, session);
            ResumeLanguage language = session.load(ResumeLanguage.class, languageId);
            session.delete(language);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find language with id = " + languageId);
        }
    }

    public void deletePhoto(int photoId) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            EntityPreprocessor.checkEntityOnExist(PHOTO_ENTITY_NAME, photoId, session);
            ResumePhoto photo = session.load(ResumePhoto.class, photoId);
            session.delete(photo);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find photo with id = " + photoId);
        }
    }

    public void deleteWorkExperience(int workExperienceId) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            EntityPreprocessor.checkEntityOnExist(WORK_EXPERIENCE_ENTITY_NAME, workExperienceId, session);
            ResumeWorkExperience workExperience = session.load(ResumeWorkExperience.class, workExperienceId);
            session.delete(workExperience);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find work expirience with id = " + workExperienceId);
        }
    }


}
