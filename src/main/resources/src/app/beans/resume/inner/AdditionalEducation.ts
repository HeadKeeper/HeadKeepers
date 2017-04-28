export class AdditionalEducation {
    private _name: string;
    private _type: string;
    private _institutionName: string;
    private _startDate: Date;
    private _finishDate: Date;

    public getName(): string {
        return this._name;
    }

    public setName(value: string) {
        this._name = value;
    }

    public getType(): string {
        return this._type;
    }

    public setType(value: string) {
        this._type = value;
    }

    public getInstitutionName(): string {
        return this._institutionName;
    }

    public setInstitutionName(value: string) {
        this._institutionName = value;
    }

    public getStartDate(): Date {
        return this._startDate;
    }

    public setStartDate(value: Date) {
        this._startDate = value;
    }

    public getFinishDate(): Date {
        return this._finishDate;
    }

    public setFinishDate(value: Date) {
        this._finishDate = value;
    }
}