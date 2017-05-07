package com.headkeeper.service.util;

import com.headkeeper.bean.entity.*;
import com.headkeeper.bean.view.*;

import java.util.LinkedList;
import java.util.List;

public class Exchanger {

    public static UserView exchangeEntityToView(User userEntity) {
        try {
            UserView userView = new UserView();

            userView.setId(userEntity.getId());
            userView.setEmail(userEntity.getEmail());
            userView.setPassword(userEntity.getPassword());
            userView.setNickname(userEntity.getNickname());
            userView.setCreationDate(userEntity.getCreationDate());
            userView.setActive(userEntity.getIsActive());

            return userView;
        }
        catch (Exception exception) {
            return new UserView();
        }
    }

    public static User exchangeViewToEntity(UserView userView) {
        try {
            User userEntity = new User();

            userEntity.setId(userView.getId());
            userEntity.setEmail(userView.getEmail());
            userEntity.setPassword(userView.getPassword());
            userEntity.setNickname(userView.getNickname());
            userEntity.setCreationDate(userView.getCreationDate());
            userEntity.setIsActive(userView.isActive());

            return userEntity;
        }
        catch (Exception exception) {
            return new User();
        }
    }

    public static Vacancy exchangeViewToEntity(VacancyView vacancyView) {
        Vacancy vacancyEntity = new Vacancy();
        //TODO: Write
        return vacancyEntity;
    }

    public static VacancyView exchangeEntityToView(Vacancy vacancyEntity) {
        VacancyView vacancyView = new VacancyView();
        //TODO: Write
        return vacancyView;
    }

    public static UserResume exchangeViewToEntity(UserResumeView resume) {
        UserResume resumeEntity = new UserResume();
        //TODO: Write
        return resumeEntity;
    }

    public static UserResumeView exchangeEntityToView(UserResume resumeEntity) {
        UserResumeView resumeView = new UserResumeView();
        //TODO: Write
        return resumeView;
    }

    public static ResumeAchievement exchangeViewToEntity(ResumeAchievementView achievement) {
        ResumeAchievement achievementEntity = new ResumeAchievement();
        //TODO: Write
        return achievementEntity;
    }

    public static Skill exchangeViewToEntity(SkillView skill) {
        Skill skillEntity = new Skill();
        //TODO: Write
        return skillEntity;
    }

    public static SkillView exchangeEntityToView(Skill skillEntity) {
        SkillView skillView = new SkillView();
        //TODO: Write
        return skillView;
    }

    public static UserCertificate exchangeViewToEntity(UserCertificateView certificate) {
        UserCertificate certificateEntity = new UserCertificate();
        //TODO: Write
        return certificateEntity;
    }

    public static UserCertificateView exchangeEntityToView(UserCertificate certificateEntity) {
        UserCertificateView certificateView = new UserCertificateView();
        //TODO: Write
        return certificateView;
    }

    public static ResumeAchievementView exchangeViewToEntity(ResumeAchievement achievementEntity) {
        ResumeAchievementView achievementView = new ResumeAchievementView();
        //TODO: Write
        return achievementView;
    }

    public static ResumeEducationView exchangeViewToEntity(ResumeEducation educationEntity) {
        ResumeEducationView educationView = new ResumeEducationView();
        //TODO: Write
        return educationView;
    }

    public static ResumeEducation exchangeViewToEntity(ResumeEducationView education) {
        ResumeEducation educationEntity = new ResumeEducation();
        //TODO: Write
        return educationEntity;
    }

    public static ResumeAdditionalEducation exchangeViewToEntity(ResumeAdditionalEducationView education) {
        ResumeAdditionalEducation educationEntity = new ResumeAdditionalEducation();
        //TODO: Write
        return educationEntity;
    }

    public static ResumeAdditionalEducationView exchangeViewToEntity(ResumeAdditionalEducation educationEntity) {
        ResumeAdditionalEducationView educationView = new ResumeAdditionalEducationView();
        //TODO: Write
        return educationView;
    }

    public static ResumeContactInfo exchangeViewToEntity(ResumeContactInfoView contactInfo) {
        ResumeContactInfo contactInfoEntity = new ResumeContactInfo();
        //TODO: Write
        return contactInfoEntity;
    }

    public static ResumeContactInfoView exchangeViewToEntity(ResumeContactInfo contactInfoEntity) {
        ResumeContactInfoView contactInfoView = new ResumeContactInfoView();
        //TODO: Write
        return contactInfoView;
    }

    public static ResumeLanguage exchangeViewToEntity(ResumeLanguageView language) {
        ResumeLanguage languageEntity = new ResumeLanguage();
        //TODO: Write
        return languageEntity;
    }

    public static ResumeLanguageView exchangeViewToEntity(ResumeLanguage resumeLanguageEntity) {
        ResumeLanguageView languageView = new ResumeLanguageView();
        //TODO: Write
        return languageView;
    }

    public static ResumePhoto exchangeViewToEntity(ResumePhotoView photo) {
        ResumePhoto photoEntity = new ResumePhoto();
        //TODO: Write
        return photoEntity;
    }

    public static ResumePhotoView exchangeViewToEntity(ResumePhoto photoEntity) {
        ResumePhotoView photoView = new ResumePhotoView();
        //TODO: Write
        return photoView;
    }

    public static ResumeWorkExperience exchangeViewToEntity(ResumeWorkExperienceView workExperience) {
        ResumeWorkExperience workExperienceEntity = new ResumeWorkExperience();
        //TODO: Write
        return workExperienceEntity;
    }

    public static ResumeWorkExperienceView exchangeViewToEntity(ResumeWorkExperience workExperienceEntity) {
        ResumeWorkExperienceView workExperienceView = new ResumeWorkExperienceView();
        //TODO: Write
        return workExperienceView;
    }
}
