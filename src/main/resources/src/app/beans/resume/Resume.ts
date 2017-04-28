import { Achievement } from "./inner/Achievement";
import { AdditionalEducation } from "./inner/AdditionalEducation";
import { ContactInfo } from "./inner/ContactInfo";
import { Education } from "./inner/Education";
import { Language } from "./inner/Language";
import { Photo } from "./inner/Photo";
import { WorkExperience } from "./inner/WorkExperience";
import { Skill } from "../skill/Skill";

export class Resume {
    private _achievements: Array<Achievement>;
    private _additionalEducations: Array<AdditionalEducation>;
    private _contactInfos: Array<ContactInfo>;
    private _educations: Array<Education>;
    private _languages: Array<Language>;
    private _photos: Array<Photo>;
    private _workExperiences: Array<WorkExperience>;
    private _skills: Array<Skill>;

    public getAchievements(): Array<Achievement> {
        return this._achievements;
    }

    public addAchievement(value: Achievement) {
        this._achievements.concat(value);
    }

    public getAdditionalEducations(): Array<AdditionalEducation> {
        return this._additionalEducations;
    }

    public addAdditionalEducation(value: AdditionalEducation) {
        this._additionalEducations.concat(value);
    }

    public getContactInfos(): Array<ContactInfo> {
        return this._contactInfos;
    }

    public addContactInfo(value: ContactInfo) {
        this._contactInfos.concat(value);
    }

    public getEducations(): Array<Education> {
        return this._educations;
    }

    public addEducation(value: Education) {
        this._educations.concat(value);
    }

    public getLanguages(): Array<Language> {
        return this._languages;
    }

    public addLanguage(value: Language) {
        this._languages.concat(value);
    }

    public getPhotos(): Array<Photo> {
        return this._photos;
    }

    public addPhoto(value: Photo) {
        this._photos.concat(value);
    }

    public getWorkExperiences(): Array<WorkExperience> {
        return this._workExperiences;
    }

    public addWorkExperience(value: WorkExperience) {
        this._workExperiences.concat(value);
    }

    public getSkills(): Array<Skill> {
        return this._skills;
    }

    public addSkill(value: Skill) {
        this._skills.concat(value);
    }
}
