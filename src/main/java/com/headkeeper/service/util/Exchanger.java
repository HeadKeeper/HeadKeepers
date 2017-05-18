package com.headkeeper.service.util;

import com.headkeeper.bean.entity.*;
import com.headkeeper.bean.view.*;

import java.util.*;

public class Exchanger {

    public static UserView exchangeEntityToView(User userEntity) {
        UserView userView = new UserView();

        userView.setId(userEntity.getId());
        userView.setEmail(userEntity.getEmail());
        userView.setPassword(userEntity.getPassword());
        userView.setNickname(userEntity.getNickname());
        userView.setCreationDate(userEntity.getCreationDate());
        userView.setActive(userEntity.getIsActive());
        userView.setRole(exchangeEntityToView(userEntity.getRole()));
        List<SkillView> skillViews = new ArrayList<SkillView>();

        for (Skill skillEntity : userEntity.getSkills()) {
            skillViews.add(exchangeEntityToView(skillEntity));
        }

        userView.setSkills(skillViews);

        return userView;
    }

    private static RoleView exchangeEntityToView(Role role) {
        RoleView roleView = new RoleView();

        roleView.setId(role.getId());
        roleView.setValue(role.getValue());

        return roleView;
    }

    public static User exchangeViewToEntity(UserView userView) {
        User userEntity = new User();

        userEntity.setId(userView.getId());
        userEntity.setEmail(userView.getEmail());
        userEntity.setPassword(userView.getPassword());
        userEntity.setNickname(userView.getNickname());
        userEntity.setCreationDate(userView.getCreationDate());
        userEntity.setIsActive(userView.isActive());

        return userEntity;
    }

    public static CompanyInfo exchangeViewToEntity(CompanyInfoView companyInfoView) {
        CompanyInfo companyInfo = new CompanyInfo();

        companyInfo.setName(companyInfoView.getName());
        companyInfo.setAddress(companyInfoView.getAddress());
        companyInfo.setDescription(companyInfoView.getDescription());
        if (companyInfoView.getUser() != null) {
            companyInfo.setUser(exchangeViewToEntity(companyInfoView.getUser()));
        } else {
            companyInfo.setUser(null);
        }
        companyInfo.setId(companyInfoView.getId());

        return companyInfo;
    }

    public static CompanyInfoView exchangeViewToEntity(CompanyInfo companyInfo) {
        CompanyInfoView companyInfoView = new CompanyInfoView();

        companyInfoView.setId(companyInfo.getId());
        companyInfoView.setName(companyInfo.getName());
        companyInfoView.setAddress(companyInfo.getAddress());
        companyInfoView.setDescription(companyInfo.getDescription());
        companyInfoView.setUser(Exchanger.exchangeEntityToView(companyInfo.getUser()));

        return companyInfoView;
    }

    public static Vacancy exchangeViewToEntity(VacancyView vacancyView) {
        Vacancy vacancyEntity = new Vacancy();

        vacancyEntity.setId(vacancyView.getId());
        vacancyEntity.setTitle(vacancyView.getTitle());
        vacancyEntity.setEmail(vacancyView.getEmail());
        vacancyEntity.setDescription(vacancyView.getDescription());
        vacancyEntity.setIsActive(vacancyView.isActive());
        vacancyEntity.setEssentialSkills(vacancyView.getEssentialSkills());
        vacancyEntity.setPreferableSkills(vacancyView.getPreferableSkills());
        vacancyEntity.setPhoneNumber(vacancyView.getPhoneNumber());
        vacancyEntity.setMinSalary(vacancyView.getMinSalary());
        vacancyEntity.setMaxSalary(vacancyView.getMaxSalary());
        vacancyEntity.setAdditionalInfoAboutSalary(vacancyView.getAdditionalInfoAboutSalary());
        if (vacancyView.getUser() != null) {
            vacancyEntity.setUser(exchangeViewToEntity(vacancyView.getUser()));
        } else {
            vacancyEntity.setUser(null);
        }

        if (vacancyView.getSkills() != null) {
            Set<Skill> skills = new HashSet<Skill>();
            for (SkillView skillView : vacancyView.getSkills()) {
                skills.add(exchangeViewToEntity(skillView));
            }

            vacancyEntity.setSkills(skills);
        } else {
            vacancyEntity.setSkills(null);
        }

        return vacancyEntity;
    }

    public static VacancyView exchangeEntityToView(Vacancy vacancy) {
        VacancyView vacancyView = new VacancyView();

        vacancyView.setId(vacancy.getId());
        vacancyView.setTitle(vacancy.getTitle());
        vacancyView.setEmail(vacancy.getEmail());
        vacancyView.setDescription(vacancy.getDescription());
        vacancyView.setActive(vacancy.getIsActive());
        vacancyView.setEssentialSkills(vacancy.getEssentialSkills());
        vacancyView.setPreferableSkills(vacancy.getPreferableSkills());
        vacancyView.setPhoneNumber(vacancy.getPhoneNumber());
        vacancyView.setMinSalary(vacancy.getMinSalary());
        vacancyView.setMaxSalary(vacancy.getMaxSalary());
        vacancyView.setAdditionalInfoAboutSalary(vacancy.getAdditionalInfoAboutSalary());

        return vacancyView;
    }

    public static UserResume exchangeViewToEntity(UserResumeView resume) {
        UserResume resumeEntity = new UserResume();

        resumeEntity.setId(resume.getId());
        resumeEntity.setAdditionalInformation(resume.getAdditionalInformation());
        resumeEntity.setAddress(resume.getAddress());
        resumeEntity.setBirthdayDate(resume.getBirthdayDate());
        resumeEntity.setFirstName(resume.getFirstName());
        resumeEntity.setIsActive(resume.isActive());
        resumeEntity.setLastName(resume.getLastName());
        resumeEntity.setMartialStatus(resume.getMartialStatus());
        resumeEntity.setMiddleName(resume.getMiddleName());
        resumeEntity.setReferences(resume.getReferences());

        if (resume.getResumeAchievements() != null) {
            Set<ResumeAchievement> achievements = new HashSet<ResumeAchievement>();
            for (ResumeAchievementView achievement : resume.getResumeAchievements()) {
                achievements.add(exchangeViewToEntity(achievement));
            }
            resumeEntity.setResumeAchievements(achievements);
        } else {
            resumeEntity.setResumeAchievements(null);
        }

        if (resume.getResumeAdditionalEducations() != null) {
            Set<ResumeAdditionalEducation> additionalEducationViews = new HashSet<ResumeAdditionalEducation>();
            for (ResumeAdditionalEducationView additionalEducation : resume.getResumeAdditionalEducations()) {
                additionalEducationViews.add(exchangeViewToEntity(additionalEducation));
            }
            resumeEntity.setResumeAdditionalEducations(additionalEducationViews);
        } else {
                resumeEntity.setResumeAdditionalEducations(null);
        }

        if (resume.getResumeContactInfos() != null) {
            Set<ResumeContactInfo> contactInfoViews = new HashSet<ResumeContactInfo>();
            for (ResumeContactInfoView contactInfo : resume.getResumeContactInfos()) {
                contactInfoViews.add(exchangeViewToEntity(contactInfo));
            }
            resumeEntity.setResumeContactInfos(contactInfoViews);
        } else {
            resumeEntity.setResumeContactInfos(null);
        }

        if (resume.getResumeEducations() != null) {
            Set<ResumeEducation> resumeEducationViews = new HashSet<ResumeEducation>();
            for (ResumeEducationView education : resume.getResumeEducations()) {
                resumeEducationViews.add(exchangeViewToEntity(education));
            }
            resumeEntity.setResumeEducations(resumeEducationViews);
        } else {
            resumeEntity.setResumeEducations(null);
        }

        if (resume.getResumePhotos() != null) {
            Set<ResumePhoto> resumePhotoViews = new HashSet<ResumePhoto>();
            for (ResumePhotoView photo : resume.getResumePhotos()) {
                resumePhotoViews.add(exchangeViewToEntity(photo));
            }
            resumeEntity.setResumePhotos(resumePhotoViews);
        } else {
            resumeEntity.setResumePhotos(null);
        }

        if (resume.getResumeWorkExperiences() != null) {
            Set<ResumeWorkExperience> resumeWorkExperienceViews = new HashSet<ResumeWorkExperience>();
            for (ResumeWorkExperienceView workExperience : resume.getResumeWorkExperiences()) {
                resumeWorkExperienceViews.add(exchangeViewToEntity(workExperience));
            }
            resumeEntity.setResumeWorkExperiences(resumeWorkExperienceViews);
        } else {
            resumeEntity.setResumeWorkExperiences(null);
        }

        if (resume.getResumeLanguages() != null) {
            Set<ResumeLanguage> languageViews = new HashSet<ResumeLanguage>();
            for (ResumeLanguageView language : resume.getResumeLanguages()) {
                languageViews.add(exchangeViewToEntity(language));
            }
            resumeEntity.setResumeLanguages(languageViews);
        } else {
            resumeEntity.setResumeLanguages(null);
        }

        return resumeEntity;
    }

    public static UserResumeView exchangeEntityToView(UserResume resumeEntity) {
        UserResumeView resumeView = new UserResumeView();

        resumeView.setId(resumeEntity.getId());
        resumeView.setAdditionalInformation(resumeEntity.getAdditionalInformation());
        resumeView.setAddress(resumeEntity.getAddress());
        resumeView.setBirthdayDate(resumeEntity.getBirthdayDate());
        resumeView.setFirstName(resumeEntity.getFirstName());
        resumeView.setActive(resumeEntity.getIsActive());
        resumeView.setLastName(resumeEntity.getLastName());
        resumeView.setMartialStatus(resumeEntity.getMartialStatus());
        resumeView.setMiddleName(resumeEntity.getMiddleName());
        resumeView.setReferences(resumeEntity.getReferences());

        List<ResumeAchievementView> achievements = new ArrayList<ResumeAchievementView>();
        for (ResumeAchievement achievement : resumeEntity.getResumeAchievements()) {
            achievements.add(exchangeEntityToView(achievement));
        }
        resumeView.setResumeAchievements(achievements);

        List<ResumeAdditionalEducationView> additionalEducationViews = new ArrayList<ResumeAdditionalEducationView>();
        for (ResumeAdditionalEducation additionalEducation : resumeEntity.getResumeAdditionalEducations()) {
            additionalEducationViews.add(exchangeEntityToView(additionalEducation));
        }
        resumeView.setResumeAdditionalEducations(additionalEducationViews);

        List<ResumeContactInfoView> contactInfoViews = new ArrayList<ResumeContactInfoView>();
        for (ResumeContactInfo contactInfo : resumeEntity.getResumeContactInfos()) {
            contactInfoViews.add(exchangeEntityToView(contactInfo));
        }
        resumeView.setResumeContactInfos(contactInfoViews);

        List<ResumeEducationView> resumeEducationViews = new ArrayList<ResumeEducationView>();
        for (ResumeEducation education : resumeEntity.getResumeEducations()) {
            resumeEducationViews.add(exchangeEntityToView(education));
        }
        resumeView.setResumeEducations(resumeEducationViews);

        List<ResumePhotoView> resumePhotoViews = new ArrayList<ResumePhotoView>();
        for (ResumePhoto photo : resumeEntity.getResumePhotos()) {
            resumePhotoViews.add(exchangeEntityToView(photo));
        }
        resumeView.setResumePhotos(resumePhotoViews);

        List<ResumeWorkExperienceView> resumeWorkExperienceViews = new ArrayList<ResumeWorkExperienceView>();
        for (ResumeWorkExperience workExperience : resumeEntity.getResumeWorkExperiences()) {
            resumeWorkExperienceViews.add(exchangeEntityToView(workExperience));
        }
        resumeView.setResumeWorkExperiences(resumeWorkExperienceViews);

        List<ResumeLanguageView> languageViews = new ArrayList<ResumeLanguageView>();
        for (ResumeLanguage language : resumeEntity.getResumeLanguages()) {
            languageViews.add(exchangeEntityToView(language));
        }
        resumeView.setResumeLanguages(languageViews);

        return resumeView;
    }

    public static ResumeAchievement exchangeViewToEntity(ResumeAchievementView achievement) {
        ResumeAchievement achievementEntity = new ResumeAchievement();

        achievementEntity.setId(achievement.getId());
        achievementEntity.setName(achievement.getName());
        achievementEntity.setValue(achievement.getValue());

        return achievementEntity;
    }

    public static Skill exchangeViewToEntity(SkillView skill) {
        Skill skillEntity = new Skill();

        skillEntity.setId(skill.getId());
        skillEntity.setLevel(skill.getLevel());
        skillEntity.setName(skill.getName());
        // Users list ?

        return skillEntity;
    }

    public static SkillView exchangeEntityToView(Skill skillEntity) {
        SkillView skillView = new SkillView();

        skillView.setId(skillEntity.getId());
        skillView.setLevel(skillEntity.getLevel());
        skillView.setName(skillEntity.getName());

        return skillView;
    }

    public static UserCertificate exchangeViewToEntity(UserCertificateView certificate) {
        UserCertificate certificateEntity = new UserCertificate();

        certificateEntity.setId(certificate.getId());
        certificateEntity.setRealName(certificate.getRealName());
        certificateEntity.setCertificateHref(certificate.getCertificateHref());
//        certificateEntity.setUser(exchangeViewToEntity(certificate.getUser()));

        return certificateEntity;
    }

    public static UserCertificateView exchangeEntityToView(UserCertificate certificateEntity) {
        UserCertificateView certificateView = new UserCertificateView();

        certificateView.setId(certificateEntity.getId());
        certificateView.setCertificateHref(certificateEntity.getCertificateHref());
        certificateView.setRealName(certificateEntity.getRealName());

        return certificateView;
    }

    public static ResumeAchievementView exchangeEntityToView(ResumeAchievement achievementEntity) {
        ResumeAchievementView achievementView = new ResumeAchievementView();

        achievementView.setId(achievementEntity.getId());
        achievementView.setName(achievementEntity.getName());
        achievementView.setValue(achievementEntity.getValue());

        return achievementView;
    }

    public static ResumeEducationView exchangeEntityToView(ResumeEducation educationEntity) {
        ResumeEducationView educationView = new ResumeEducationView();

        educationView.setId(educationEntity.getId());
        educationView.setAdditionalInformation(educationEntity.getAdditionalInformation());
        educationView.setFacultyName(educationEntity.getFacultyName());
        educationView.setStartDate(educationEntity.getStartDate());
        educationView.setFinishDate(educationEntity.getFinishDate());
        educationView.setInstitutionName(educationEntity.getInstitutionName());
        educationView.setType(educationEntity.getType());

        return educationView;
    }

    public static ResumeEducation exchangeViewToEntity(ResumeEducationView education) {
        ResumeEducation educationEntity = new ResumeEducation();

        educationEntity.setId(education.getId());
        educationEntity.setAdditionalInformation(education.getAdditionalInformation());
        educationEntity.setFacultyName(education.getFacultyName());
        educationEntity.setStartDate(education.getStartDate());
        educationEntity.setFinishDate(education.getFinishDate());
        educationEntity.setInstitutionName(education.getInstitutionName());
        educationEntity.setType(education.getType());
//        educationEntity.setUserResume(exchangeViewToEntity(education.getUserResume()));

        return educationEntity;
    }

    public static ResumeAdditionalEducation exchangeViewToEntity(ResumeAdditionalEducationView education) {
        ResumeAdditionalEducation educationEntity = new ResumeAdditionalEducation();

        educationEntity.setId(education.getId());
        educationEntity.setName(education.getName());
        educationEntity.setStartDate(education.getStartDate());
        educationEntity.setFinishDate(education.getFinishDate());
        educationEntity.setType(education.getType());
        educationEntity.setInstitutionName(education.getInstitutionName());
//        educationEntity.setUserResume(exchangeViewToEntity(education.getUserResume()));

        return educationEntity;
    }

    public static ResumeAdditionalEducationView exchangeEntityToView(ResumeAdditionalEducation education) {
        ResumeAdditionalEducationView educationView = new ResumeAdditionalEducationView();

        educationView.setId(education.getId());
        educationView.setName(education.getName());
        educationView.setStartDate(education.getStartDate());
        educationView.setFinishDate(education.getFinishDate());
        educationView.setType(education.getType());
        educationView.setInstitutionName(education.getInstitutionName());

        return educationView;
    }

    public static ResumeContactInfo exchangeViewToEntity(ResumeContactInfoView contactInfo) {
        ResumeContactInfo contactInfoEntity = new ResumeContactInfo();

        contactInfoEntity.setId(contactInfo.getId());
        contactInfoEntity.setType(contactInfo.getType());
        contactInfoEntity.setValue(contactInfo.getValue());
//        contactInfoEntity.setUserResumeByUserResumeId(exchangeViewToEntity(contactInfo.getUserResume()));

        return contactInfoEntity;
    }

    public static ResumeContactInfoView exchangeEntityToView(ResumeContactInfo contactInfo) {
        ResumeContactInfoView contactInfoView = new ResumeContactInfoView();

        contactInfoView.setId(contactInfo.getId());
        contactInfoView.setType(contactInfo.getType());
        contactInfoView.setValue(contactInfo.getValue());

        return contactInfoView;
    }

    public static ResumeLanguage exchangeViewToEntity(ResumeLanguageView language) {
        ResumeLanguage languageEntity = new ResumeLanguage();

        languageEntity.setId(language.getId());
        languageEntity.setLanguage(language.getLanguage());
        languageEntity.setLevel(language.getLevel());
//        languageEntity.setUserResume(exchangeViewToEntity(language.getUserResume()));

        return languageEntity;
    }

    public static ResumeLanguageView exchangeEntityToView(ResumeLanguage language) {
        ResumeLanguageView languageView = new ResumeLanguageView();

        languageView.setId(language.getId());
        languageView.setLanguage(language.getLanguage());
        languageView.setLevel(language.getLevel());

        return languageView;
    }

    public static ResumePhoto exchangeViewToEntity(ResumePhotoView photo) {
        ResumePhoto photoEntity = new ResumePhoto();

        photoEntity.setId(photo.getId());
        photoEntity.setRealName(photo.getRealName());
        photoEntity.setPhotoHref(photo.getPhotoHref());
//        photoEntity.setUserResume(exchangeViewToEntity(photo.getUserResume()));

        return photoEntity;
    }

    public static ResumePhotoView exchangeEntityToView(ResumePhoto photo) {
        ResumePhotoView photoView = new ResumePhotoView();

        photoView.setId(photo.getId());
        photoView.setRealName(photo.getRealName());
        photoView.setPhotoHref(photo.getPhotoHref());

        return photoView;
    }

    public static ResumeWorkExperience exchangeViewToEntity(ResumeWorkExperienceView workExperience) {
        ResumeWorkExperience workExperienceEntity = new ResumeWorkExperience();

        workExperienceEntity.setId(workExperience.getId());
        workExperienceEntity.setCompanyName(workExperience.getCompanyName());
        workExperienceEntity.setDateStart(workExperience.getDateStart());
        workExperienceEntity.setDateFinish(workExperience.getDateFinish());
        workExperienceEntity.setDuties(workExperience.getDuties());
        workExperienceEntity.setPosition(workExperience.getPosition());
//        workExperienceEntity.setUserResumeByUserResumeId(exchangeViewToEntity(workExperience.getUserResume()));

        return workExperienceEntity;
    }

    public static ResumeWorkExperienceView exchangeEntityToView(ResumeWorkExperience workExperience) {
        ResumeWorkExperienceView workExperienceView = new ResumeWorkExperienceView();

        workExperienceView.setId(workExperience.getId());
        workExperienceView.setCompanyName(workExperience.getCompanyName());
        workExperienceView.setDateStart(workExperience.getDateStart());
        workExperienceView.setDateFinish(workExperience.getDateFinish());
        workExperienceView.setDuties(workExperience.getDuties());
        workExperienceView.setPosition(workExperience.getPosition());

        return workExperienceView;
    }
}
