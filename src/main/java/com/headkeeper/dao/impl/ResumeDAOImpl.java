package com.headkeeper.dao.impl;

import com.headkeeper.bean.entity.*;
import com.headkeeper.dao.ResumeDAO;
import com.headkeeper.dao.exception.DAOException;
import org.hibernate.Session;
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
        Session session = sessionFactory.getCurrentSession();
        session.save(resume);
    }

    public void addResumeAchievement(ResumeAchievement achievement, int resumeId) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        UserResume userResume = session.load(UserResume.class, resumeId);
        userResume.getResumeAchievements().add(achievement);
        session.update(userResume);
    }

    public void addAdditionalEducation(ResumeAdditionalEducation additionalEducation, int resumeId) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        UserResume userResume = session.load(UserResume.class, resumeId);
        userResume.getResumeAdditionalEducations().add(additionalEducation);
        session.update(userResume);
    }

    public void addContactInfo(ResumeContactInfo contactInfo, int resumeId) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        UserResume userResume = session.load(UserResume.class, resumeId);
        userResume.getResumeContactInfos().add(contactInfo);
        session.update(userResume);
    }

    public void addEducation(ResumeEducation education, int resumeId) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        UserResume userResume = session.load(UserResume.class, resumeId);
        userResume.getResumeEducations().add(education);
        session.update(userResume);
    }

    public void addLanguage(ResumeLanguage language, int resumeId) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        UserResume userResume = session.load(UserResume.class, resumeId);
        userResume.getResumeLanguages().add(language);
        session.update(userResume);
    }

    public void addPhoto(ResumePhoto photo, int resumeId) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        UserResume userResume = session.load(UserResume.class, resumeId);
        userResume.getResumePhotos().add(photo);
        session.update(userResume);
    }

    public void addWorkExpirience(ResumeWorkExperience workExperience, int resumeId) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        UserResume userResume = session.load(UserResume.class, resumeId);
        userResume.getResumeWorkExperiences().add(workExperience);
        session.update(userResume);
    }

    // -------------------------------- READ ---------------------------------------------

    public UserResume getResumeById(int id) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        UserResume userResume = session.get(UserResume.class, id);
        return userResume;
    }

    public List<ResumeAchievement> getResumeAchievements(int id) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        UserResume resume = session.get(UserResume.class, id);
        List<ResumeAchievement> achievements = new ArrayList<ResumeAchievement>();
        achievements.addAll(resume.getResumeAchievements());
        return achievements;
    }

    public List<ResumeAdditionalEducation> getAdditionalEducations(int id) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        UserResume resume = session.get(UserResume.class, id);
        List<ResumeAdditionalEducation> additionalEducations = new ArrayList<ResumeAdditionalEducation>();
        additionalEducations.addAll(resume.getResumeAdditionalEducations());
        return additionalEducations;
    }

    public List<ResumeContactInfo> getContactInfo(int id) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        UserResume resume = session.get(UserResume.class, id);
        List<ResumeContactInfo> contactInfos = new ArrayList<ResumeContactInfo>();
        contactInfos.addAll(resume.getResumeContactInfos());
        return contactInfos;
    }

    public List<ResumeEducation> getResumeEducations(int id) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        UserResume resume = session.get(UserResume.class, id);
        List<ResumeEducation> educations = new ArrayList<ResumeEducation>();
        educations.addAll(resume.getResumeEducations());
        return educations;
    }

    public List<ResumeLanguage> getResumeLanguages(int id) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        UserResume resume = session.get(UserResume.class, id);
        List<ResumeLanguage> languages = new ArrayList<ResumeLanguage>();
        languages.addAll(resume.getResumeLanguages());
        return languages;
    }

    public List<ResumePhoto> getResumePhotos(int id) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        UserResume resume = session.get(UserResume.class, id);
        List<ResumePhoto> photos = new ArrayList<ResumePhoto>();
        photos.addAll(resume.getResumePhotos());
        return photos;
    }

    public List<ResumeWorkExperience> getResumeWorkExpirience(int id) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        UserResume resume = session.get(UserResume.class, id);
        List<ResumeWorkExperience> workExperiences = new ArrayList<ResumeWorkExperience>();
        workExperiences.addAll(resume.getResumeWorkExperiences());
        return workExperiences;
    }

    // -------------------------------- UPDATE -------------------------------------------

    public void updateResumeStatus(int id, boolean status) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        UserResume resume = session.load(UserResume.class, id);
        resume.setIsActive(status);
    }

    public void updateResume(int id, UserResume resume) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        UserResume oldResume = session.load(UserResume.class, id);
        replaceResumeData(oldResume, resume);
        session.update(oldResume);
    }

    // -------------------------------- DELETE -------------------------------------------

    public void deleteResume(int id) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        UserResume resume = session.load(UserResume.class, id);
        session.delete(resume);
    }

    public void deleteResumeAchievement(int achievementId, UserResume resume) throws DAOException {
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

    public void deleteAdditionalEducation(int additionalEducationId, UserResume resume) throws DAOException {
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

    public void deleteContactInfo(int contactInfoId, UserResume resume) throws DAOException {
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

    public void deleteEducation(int educationId, UserResume resume) throws DAOException {
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

    public void deleteLangugage(int languageId, UserResume resume) throws DAOException {
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

    public void deletePhoto(int photoId, UserResume resume) throws DAOException {
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

    public void deleteWorkExpirience(int workExpirienceId, UserResume resume) throws DAOException {
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


}
