import { Skill } from "../skill/Skill";

export class Vacancy {

    private _title: string;
    private _description: string;
    private _essentialSkills: string;
    private _preferableSkills: string;
    private _jobType: number;
    private _phoneNumber: string;
    private _email: string;
    private _minSalary: number;
    private _maxSalary: number;
    private _additionalInfoAboutSalary: string;
    private _userId : number;

    public static serialize(vacancy : Vacancy) {
        return {
            title : vacancy._title,
            description : vacancy._description,
            jobType : vacancy._jobType,
            phoneNumber : vacancy._phoneNumber,
            email : vacancy._email,
            minSalary : vacancy._minSalary,
            maxSalary : vacancy._maxSalary,
            essentialSkills: vacancy._essentialSkills,
            preferableSkills: vacancy._preferableSkills,
            additionalInfoAboutSalary : vacancy._additionalInfoAboutSalary
        }
    }

    public static deserialize(object : any): Vacancy {
        
        var vacancy = new Vacancy();

        vacancy.title = object.title;
        vacancy.description = object.description;
        vacancy.jobType = object.jobType;
        vacancy.phoneNumber = object.phoneNumber;
        vacancy.email = object.email;
        vacancy.minSalary = object.minSalary;
        vacancy.maxSalary = object.maxSalary;
        vacancy.essentialSkills = vacancy._essentialSkills;
        vacancy.preferableSkills = vacancy._preferableSkills;
        vacancy.additionalInfoAboutSalary = object.additionalInfoAboutSalary;

        return vacancy;
    }

    get userId(): number {
        return this._userId;
    }

    set userId(value: number) {
        this._userId = value;
    }

    get title(): string {
        return this._title;
    }

    set title(value: string) {
        this._title = value;
    }

    get description(): string {
        return this._description;
    }

    set description(value: string) {
        this._description = value;
    }

    get preferableSkills(): string {
        return this._preferableSkills;
    }

    set preferableSkills(value: string) {
        this._preferableSkills = value;
    }

    get essentialSkills(): string {
        return this._essentialSkills;
    }

    set essentialSkills(value: string) {
        this._essentialSkills = value;
    }

    get jobType(): number {
        return this._jobType;
    }

    set jobType(value: number) {
        this._jobType = value;
    }

    get phoneNumber(): string {
        return this._phoneNumber;
    }

    set phoneNumber(value: string) {
        this._phoneNumber = value;
    }

    get email(): string {
        return this._email;
    }

    set email(value: string) {
        this._email = value;
    }

    get minSalary(): number {
        return this._minSalary;
    }

    set minSalary(value: number) {
        this._minSalary = value;
    }

    get maxSalary(): number {
        return this._maxSalary;
    }

    set maxSalary(value: number) {
        this._maxSalary = value;
    }

    get additionalInfoAboutSalary(): string {
        return this._additionalInfoAboutSalary;
    }

    set additionalInfoAboutSalary(value: string) {
        this._additionalInfoAboutSalary = value;
    }
}