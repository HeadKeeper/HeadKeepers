package com.headkeeper.dao.util;

import com.headkeeper.bean.entity.*;
import org.hibernate.HibernateException;

public class DataExchanger {

    public static void replaceSkillData(Skill oldSkill, Skill skill) throws HibernateException {
        oldSkill.setName(skill.getName());
        oldSkill.setLevel(skill.getLevel());
    }

    public static void replaceEmployerInfo(EmployerInfo employerInfo, EmployerInfo oldEmployerInfo) throws HibernateException {
        oldEmployerInfo.setName(employerInfo.getName());
        oldEmployerInfo.setPhoneNumber(employerInfo.getPhoneNumber());
    }

    public static void replaceUserData(User user, User oldUser) throws HibernateException {
        oldUser.setEmail(user.getEmail());
        oldUser.setNickname(user.getNickname());
        oldUser.setPassword(user.getPassword());
    }

    public static void replaceContactInfo(ResumeContactInfo oldContactInfo, ResumeContactInfo contactInfo) throws HibernateException {
        oldContactInfo.setType(contactInfo.getType());
        oldContactInfo.setValue(contactInfo.getValue());
    }

    public static void replacePhoto(ResumePhoto oldPhoto, ResumePhoto photo) throws HibernateException {
        oldPhoto.setPhotoHref(photo.getPhotoHref());
        oldPhoto.setRealName(photo.getRealName());
    }

    public static void replaceEducation(ResumeEducation oldEducation, ResumeEducation education) {
        oldEducation.setType(education.getType());
        oldEducation.setStartDate(education.getStartDate());
        oldEducation.setFinishDate(education.getFinishDate());
        oldEducation.setAdditionalInformation(education.getAdditionalInformation());
        oldEducation.setFacultyName(education.getFacultyName());
        oldEducation.setInstitutionName(education.getInstitutionName());
    }

    public static void replaceAdditionalEducation(ResumeAdditionalEducation oldAdditionalEducation,
                                                  ResumeAdditionalEducation additionalEducation) throws HibernateException {
        oldAdditionalEducation.setName(additionalEducation.getName());
        oldAdditionalEducation.setInstitutionName(additionalEducation.getInstitutionName());
        oldAdditionalEducation.setType(additionalEducation.getType());
        oldAdditionalEducation.setStartDate(additionalEducation.getStartDate());
        oldAdditionalEducation.setFinishDate(additionalEducation.getFinishDate());
    }

    public static void replaceCompanyInfo(CompanyInfo companyInfo, CompanyInfo oldCompanyInfo) throws HibernateException {
        oldCompanyInfo.setDescription(companyInfo.getDescription());
        oldCompanyInfo.setAddress(companyInfo.getAddress());
        oldCompanyInfo.setName(companyInfo.getName());
    }

    public static void replaceResumeData(UserResume oldResume, UserResume newResume) throws HibernateException {
        oldResume.setAdditionalInformation(newResume.getAdditionalInformation());
        oldResume.setAddress(newResume.getAddress());
        oldResume.setBirthdayDate(newResume.getBirthdayDate());
        oldResume.setFirstName(newResume.getFirstName());
        oldResume.setLastName(newResume.getLastName());
        oldResume.setMiddleName(newResume.getMiddleName());
        oldResume.setReferences(newResume.getReferences());
        oldResume.setMartialStatus(newResume.getMartialStatus());
    }

    public static void replaceResumeAchievementData(ResumeAchievement oldAchievement,
                                                    ResumeAchievement achievement) throws HibernateException {
        oldAchievement.setName(achievement.getName());
        oldAchievement.setValue(achievement.getValue());
    }

    public static void replaceWorkExperienceData(ResumeWorkExperience oldWorkExperience,
                                                 ResumeWorkExperience workExperience) throws HibernateException {
        oldWorkExperience.setCompanyName(workExperience.getCompanyName());
        oldWorkExperience.setDateFinish(workExperience.getDateFinish());
        oldWorkExperience.setDateStart(workExperience.getDateStart());
        oldWorkExperience.setDuties(workExperience.getDuties());
        oldWorkExperience.setPosition(workExperience.getPosition());
    }
}
