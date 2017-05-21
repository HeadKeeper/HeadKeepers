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
    private _firstName: string;
    private _lastName: string;
    private _middleName: string;
    private _address: string;
    private _martialStatus: string;
    private _references: string;
    private _additionalInformation: string;
    private _birthdayDate : Date;
    private _id : number; // set from token

    public static serialize(resume : Resume): Object {
        return {
            firstName : resume._firstName,
            lastName : resume._lastName,
            middleName : resume._middleName,
            address : resume._address,
            martialStatus : resume._martialStatus,
            references : resume._references,
            additionalInformation : resume._additionalInformation,
            birthdayDate : resume._birthdayDate,
            userId : resume._id
        }
    }

    public static deserialize(object : any): Resume {
        
        var resume = new Resume();

        resume.firstName = object.firstName;
        resume.lastName = object.lastName;
        resume.middleName = object.middleName;
        resume.address = object.address;
        resume.martialStatus = object.martialStatus;
        resume.references = object.references;
        resume.additionalInformation = object.additionalInformation;
        resume.birthdayDate = object.birthdayDate;
        resume.id = object.id;

        return resume;
        
    }

    get birthdayDate(): Date {
        return this._birthdayDate;
    }

    set birthdayDate(value: Date) {
        this._birthdayDate = value;
    }
    
    get id(): number {
        return this._id;
    }

    set id(value: number) {
        this._id = value;
    }

    get references(): string {
        return this._references;
    }

    set references(value: string) {
        this._references = value;
    }
    get martialStatus(): string {
        return this._martialStatus;
    }

    set martialStatus(value: string) {
        this._martialStatus = value;
    }
    get address(): string {
        return this._address;
    }

    set address(value: string) {
        this._address = value;
    }
    get middleName(): string {
        return this._middleName;
    }

    set middleName(value: string) {
        this._middleName = value;
    }
    get lastName(): string {
        return this._lastName;
    }

    set lastName(value: string) {
        this._lastName = value;
    }
    get firstName(): string {
        return this._firstName;
    }

    set firstName(value: string) {
        this._firstName = value;
    }
    get additionalInformation(): string {
        return this._additionalInformation;
    }

    set additionalInformation(value: string) {
        this._additionalInformation = value;
    }

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
