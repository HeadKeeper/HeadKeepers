package com.headkeeper.dao.impl;

import com.headkeeper.bean.entity.*;
import com.headkeeper.dao.ResumeDAO;
import com.headkeeper.dao.exception.DAOException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Transactional
@Repository
public class ResumeDAOImpl implements ResumeDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public ResumeDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private void replaceResumeData(UserResume oldResume, UserResume newResume) throws DAOException {
        oldResume.setAdditionalInformation(newResume.getAdditionalInformation());
        oldResume.setAddress(newResume.getAddress());
        oldResume.setBirthdayDate(newResume.getBirthdayDate());
        oldResume.setFirstName(newResume.getFirstName());
        oldResume.setLastName(newResume.getLastName());
        oldResume.setMiddleName(newResume.getMiddleName());
        oldResume.setReferences(newResume.getReferences());
        oldResume.setMartialStatus(newResume.getMartialStatus());
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

    public void addWorkExpirience(ResumeWorkExperience workExperience, int resumeId) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            UserResume userResume = session.load(UserResume.class, resumeId);
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
            return userResume;
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find resume with id = " + id);
        }
    }

    public List<ResumeAchievement> getResumeAchievements(int id) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            UserResume resume = session.get(UserResume.class, id);
            List<ResumeAchievement> achievements = new ArrayList<ResumeAchievement>();
            achievements.addAll(resume.getResumeAchievements());
            return achievements;
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find resume with id = " + id);
        }
    }

    public List<ResumeAdditionalEducation> getAdditionalEducations(int id) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            UserResume resume = session.get(UserResume.class, id);
            List<ResumeAdditionalEducation> additionalEducations = new ArrayList<ResumeAdditionalEducation>();
            additionalEducations.addAll(resume.getResumeAdditionalEducations());
            return additionalEducations;
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find resume with id = " + id);
        }
    }

    public List<ResumeContactInfo> getContactInfo(int id) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            UserResume resume = session.get(UserResume.class, id);
            List<ResumeContactInfo> contactInfos = new ArrayList<ResumeContactInfo>();
            contactInfos.addAll(resume.getResumeContactInfos());
            return contactInfos;
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find resume with id = " + id);
        }
    }

    public List<ResumeEducation> getResumeEducations(int id) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            UserResume resume = session.get(UserResume.class, id);
            List<ResumeEducation> educations = new ArrayList<ResumeEducation>();
            educations.addAll(resume.getResumeEducations());
            return educations;
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find resume with id = " + id);
        }
    }

    public List<ResumeLanguage> getResumeLanguages(int id) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            UserResume resume = session.get(UserResume.class, id);
            List<ResumeLanguage> languages = new ArrayList<ResumeLanguage>();
            languages.addAll(resume.getResumeLanguages());
            return languages;
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find resume with id = " + id);
        }
    }

    public List<ResumePhoto> getResumePhotos(int id) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            UserResume resume = session.get(UserResume.class, id);
            List<ResumePhoto> photos = new ArrayList<ResumePhoto>();
            photos.addAll(resume.getResumePhotos());
            return photos;
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find resume with id = " + id);
        }
    }

    public List<ResumeWorkExperience> getResumeWorkExpirience(int id) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            UserResume resume = session.get(UserResume.class, id);
            List<ResumeWorkExperience> workExperiences = new ArrayList<ResumeWorkExperience>();
            workExperiences.addAll(resume.getResumeWorkExperiences());
            return workExperiences;
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find resume with id = " + id);
        }
    }

    // -------------------------------- UPDATE -------------------------------------------

    public void updateResumeStatus(int id, boolean status) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            UserResume resume = session.load(UserResume.class, id);
            resume.setIsActive(status);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find resume with id = " + id);
        }
    }

    public void updateResume(int id, UserResume resume) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            UserResume oldResume = session.load(UserResume.class, id);
            replaceResumeData(oldResume, resume);
            session.update(oldResume);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find resume with id = " + id);
        }
    }

    // -------------------------------- DELETE -------------------------------------------

    public void deleteResume(int id) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
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

    public void deleteResumeAchievement(int achievementId, UserResume resume) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            UserResume userResume = session.load(UserResume.class, resume.getId());
            Set<ResumeAchievement> resumeAchievements = userResume.getResumeAchievements();
            ResumeAchievement deletingAchievement = null;
            for (ResumeAchievement achievement : resumeAchievements) {
                if (achievement.getId() == achievementId) {
                    deletingAchievement = achievement;
                    break;
                }
            }
            resumeAchievements.remove(deletingAchievement);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find achivement with id = " + achievementId);
        }
    }

    public void deleteAdditionalEducation(int additionalEducationId, UserResume resume) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            UserResume userResume = session.load(UserResume.class, resume.getId());
            Set<ResumeAdditionalEducation> additionalEducations = userResume.getResumeAdditionalEducations();
            ResumeAdditionalEducation deleteingAdditionalEducation = null;
            for (ResumeAdditionalEducation additionalEducation : additionalEducations) {
                if (additionalEducation.getId() == additionalEducationId) {
                    deleteingAdditionalEducation = additionalEducation;
                    break;
                }
            }
            additionalEducations.remove(deleteingAdditionalEducation);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find additioncal education with id = " + additionalEducationId);
        }
    }

    public void deleteContactInfo(int contactInfoId, UserResume resume) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            UserResume userResume = session.load(UserResume.class, resume.getId());
            Set<ResumeContactInfo> contactInfos = userResume.getResumeContactInfos();
            ResumeContactInfo deletingContactInfo = null;
            for (ResumeContactInfo contactInfo : contactInfos) {
                if (contactInfo.getId() == contactInfoId) {
                    deletingContactInfo = contactInfo;
                    break;
                }
            }
            contactInfos.remove(deletingContactInfo);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find contact info with id = " + contactInfoId);
        }
     }

    public void deleteEducation(int educationId, UserResume resume) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            UserResume userResume = session.load(UserResume.class, resume.getId());
            Set<ResumeEducation> educations = userResume.getResumeEducations();
            ResumeEducation deletingEducation = null;
            for (ResumeEducation education : educations) {
                if (education.getId() == educationId) {
                    deletingEducation = education;
                    break;
                }
            }
            educations.remove(deletingEducation);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find education with id = " + educationId);
        }
    }

    public void deleteLangugage(int languageId, UserResume resume) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            UserResume userResume = session.load(UserResume.class, resume.getId());
            Set<ResumeLanguage> languages = userResume.getResumeLanguages();
            ResumeLanguage deletingLanguage = null;
            for (ResumeLanguage language : languages) {
                if (language.getId() == languageId) {
                    deletingLanguage = language;
                    break;
                }
            }
            languages.remove(deletingLanguage);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find language with id = " + languageId);
        }
    }

    public void deletePhoto(int photoId, UserResume resume) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            UserResume userResume = session.load(UserResume.class, resume.getId());
            Set<ResumePhoto> photos = userResume.getResumePhotos();
            ResumePhoto deletingPhoto = null;
            for (ResumePhoto photo : photos) {
                if (photo.getId() == photoId) {
                    deletingPhoto = photo;
                    break;
                }
            }
            photos.remove(deletingPhoto);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find photo with id = " + photoId);
        }
    }

    public void deleteWorkExpirience(int workExpirienceId, UserResume resume) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            UserResume userResume = session.load(UserResume.class, resume.getId());
            Set<ResumeWorkExperience> workExperiences = userResume.getResumeWorkExperiences();
            ResumeWorkExperience deletingExpirience = null;
            for (ResumeWorkExperience workExperience : workExperiences) {
                if (workExperience.getId() == workExpirienceId) {
                    deletingExpirience = workExperience;
                    break;
                }
            }
            workExperiences.remove(deletingExpirience);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find work expirience with id = " + workExpirienceId);
        }
    }


}
