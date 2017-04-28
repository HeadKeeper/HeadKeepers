import { Skill } from "../skill/Skill";

export class Vacancy {
    private _title: string;
    private _description: string;
    private _essentialSkills: Array<Skill>;
    private _preferableSkills: Array<Skill>;
    private _jobType: number;
    private _phoneNumber: string;
    private _email: string;
    private _minSalary: number;
    private _maxSalary: number;
    private _additionalInfoAboutSalary: string;

    public getTitle(): string {
        return this._title;
    }

    public setTitle(value: string) {
        this._title = value;
    }

    public getDescription(): string {
        return this._description;
    }

    public setDescription(value: string) {
        this._description = value;
    }

    public getEssentailSkills(): Array<Skill> {
        return this._essentialSkills;
    }

    public addEssentailSkill(value: Skill) {
        this._essentialSkills.concat(value);
    }

    public getPreferableSkills(): Array<Skill> {
        return this._preferableSkills;
    }

    public addPreferableSkill(value: Skill) {
        this._preferableSkills.concat(value);
    }

    public getJobType(): number {
        return this._jobType;
    }

    public setJobType(value: number) {
        this._jobType = value;
    }

    public getPhoneNumber(): string {
        return this._phoneNumber;
    }

    public setPhoneNumber(value: string) {
        this._phoneNumber = value;
    }

    public getEmail(): string {
        return this._email;
    }

    public setEmail(value: string) {
        this._email = value;
    }

    public getMinSalary(): number {
        return this._minSalary;
    }

    public setMinSalary(value: number) {
        this._minSalary = value;
    }

    public getMaxSalary(): number {
        return this._maxSalary;
    }

    public setMaxSalary(value: number) {
        this._maxSalary = value;
    }

    public getAdditionalInfoAboutSalary(): string {
        return this._additionalInfoAboutSalary;
    }

    public setAdditionalInfoAboutSalary(value: string) {
        this._additionalInfoAboutSalary = value;
    }
}