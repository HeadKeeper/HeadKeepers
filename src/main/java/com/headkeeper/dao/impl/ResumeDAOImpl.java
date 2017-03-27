package com.headkeeper.dao.impl;

import com.headkeeper.bean.entity.*;
import com.headkeeper.dao.ResumeDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository
public class ResumeDAOImpl implements ResumeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private void replaceResumeData(UserResume oldResume, UserResume newResume) {
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

    public void addNewResume(UserResume resume) {
        /* USER_ID FK (resume.userId) it should be packed on the user side */
        Session session = sessionFactory.getCurrentSession();
        session.save(resume);
    }

    public void addResumeAchievement(ResumeAchievement achievement, int resumeId) {
        Session session = sessionFactory.getCurrentSession();
        UserResume userResume = session.load(UserResume.class, resumeId);
        userResume.getResumeAchievements().add(achievement);
        session.update(userResume);
    }

    public void addAdditionalEducation(ResumeAdditionalEducation additionalEducation, int resumeId) {
        Session session = sessionFactory.getCurrentSession();
        UserResume userResume = session.load(UserResume.class, resumeId);
        userResume.getResumeAdditionalEducations().add(additionalEducation);
        session.update(userResume);
    }

    public void addContactInfo(ResumeContactInfo contactInfo, int resumeId) {
        Session session = sessionFactory.getCurrentSession();
        UserResume userResume = session.load(UserResume.class, resumeId);
        userResume.getResumeContactInfos().add(contactInfo);
        session.update(userResume);
    }

    public void addEducation(ResumeEducation education, int resumeId) {
        Session session = sessionFactory.getCurrentSession();
        UserResume userResume = session.load(UserResume.class, resumeId);
        userResume.getResumeEducations().add(education);
        session.update(userResume);
    }

    public void addLanguage(ResumeLanguage language, int resumeId) {
        Session session = sessionFactory.getCurrentSession();
        UserResume userResume = session.load(UserResume.class, resumeId);
        userResume.getResumeLanguages().add(language);
        session.update(userResume);
    }

    public void addPhoto(ResumePhoto photo, int resumeId) {
        Session session = sessionFactory.getCurrentSession();
        UserResume userResume = session.load(UserResume.class, resumeId);
        userResume.getResumePhotos().add(photo);
        session.update(userResume);
    }

    public void addWorkExpirience(ResumeWorkExperience workExperience, int resumeId) {
        Session session = sessionFactory.getCurrentSession();
        UserResume userResume = session.load(UserResume.class, resumeId);
        userResume.getResumeWorkExperiences().add(workExperience);
        session.update(userResume);
    }

    // -------------------------------- READ ---------------------------------------------

    public UserResume getResumeById(int id) {
        Session session = sessionFactory.getCurrentSession();
        UserResume userResume = session.get(UserResume.class, id);
        return userResume;
    }

    public List<ResumeAchievement> getResumeAchievements(int id) {
        Session session = sessionFactory.getCurrentSession();
        UserResume resume = session.get(UserResume.class, id);
        List<ResumeAchievement> achievements = new ArrayList<ResumeAchievement>();
        achievements.addAll(resume.getResumeAchievements());
        return achievements;
    }

    public List<ResumeAdditionalEducation> getAdditionalEducations(int id) {
        Session session = sessionFactory.getCurrentSession();
        UserResume resume = session.get(UserResume.class, id);
        List<ResumeAdditionalEducation> additionalEducations = new ArrayList<ResumeAdditionalEducation>();
        additionalEducations.addAll(resume.getResumeAdditionalEducations());
        return additionalEducations;
    }

    public List<ResumeContactInfo> getContactInfo(int id) {
        Session session = sessionFactory.getCurrentSession();
        UserResume resume = session.get(UserResume.class, id);
        List<ResumeContactInfo> contactInfos = new ArrayList<ResumeContactInfo>();
        contactInfos.addAll(resume.getResumeContactInfos());
        return contactInfos;
    }

    public List<ResumeEducation> getResumeEducations(int id) {
        Session session = sessionFactory.getCurrentSession();
        UserResume resume = session.get(UserResume.class, id);
        List<ResumeEducation> educations = new ArrayList<ResumeEducation>();
        educations.addAll(resume.getResumeEducations());
        return educations;
    }

    public List<ResumeLanguage> getResumeLanguages(int id) {
        Session session = sessionFactory.getCurrentSession();
        UserResume resume = session.get(UserResume.class, id);
        List<ResumeLanguage> languages = new ArrayList<ResumeLanguage>();
        languages.addAll(resume.getResumeLanguages());
        return languages;
    }

    public List<ResumePhoto> getResumePhotos(int id) {
        Session session = sessionFactory.getCurrentSession();
        UserResume resume = session.get(UserResume.class, id);
        List<ResumePhoto> photos = new ArrayList<ResumePhoto>();
        photos.addAll(resume.getResumePhotos());
        return photos;
    }

    public List<ResumeWorkExperience> getResumeWorkExpirience(int id) {
        Session session = sessionFactory.getCurrentSession();
        UserResume resume = session.get(UserResume.class, id);
        List<ResumeWorkExperience> workExperiences = new ArrayList<ResumeWorkExperience>();
        workExperiences.addAll(resume.getResumeWorkExperiences());
        return workExperiences;
    }

    // -------------------------------- UPDATE -------------------------------------------

    public void updateResumeStatus(int id, boolean status) {
        Session session = sessionFactory.getCurrentSession();
        UserResume resume = session.load(UserResume.class, id);
        resume.setIsActive(status);
    }

    public void updateResume(int id, UserResume resume) {
        Session session = sessionFactory.getCurrentSession();
        UserResume oldResume = session.load(UserResume.class, id);
        replaceResumeData(oldResume, resume);
        session.update(oldResume);
    }

    // -------------------------------- DELETE -------------------------------------------

    public void deleteResume(int id) {
        Session session = sessionFactory.getCurrentSession();
        UserResume resume = session.load(UserResume.class, id);
        session.delete(resume);
    }

    public void deleteResumeAchievemet(int achievementId, UserResume resume) {
        Session session = sessionFactory.getCurrentSession();
        UserResume userResume = session.load(UserResume.class, resume.getId());
        userResume.getResumeAchievements();
    }

    public void deleteAdditionalEducation(int additionalEducationId, UserResume resume) {

    }

    public void deleteContactInfo(int contactInfoId, UserResume resume) {

    }

    public void deleteEducation(int educationId, UserResume resume) {

    }

    public void deleteLangugage(int languageId, UserResume resume) {

    }

    public void deletePhoto(int photoId, UserResume resume) {

    }
}
