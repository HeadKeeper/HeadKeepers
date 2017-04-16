export class Education {
    private _institutionName: string;
    private _facultyName: string;
    private _type: string;
    private _startDate: Date;
    private _finishDate: Date;
    private _additionalInformation: string;

    public getInstitutionName(): string {
        return this._institutionName;
    }

    public setInstitutionName(value: string) {
        this._institutionName = value;
    }

    public getType(): string {
        return this._type;
    }

    public setType(value: string) {
        this._type = value;
    }

    public getFacultyName(): string {
        return this._facultyName;
    }

    public setFacultyName(value: string) {
        this._facultyName = value;
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

    public getAdditionalInformation(): string {
        return this._additionalInformation;
    }

    public setAdditionalInformation(value: string) {
        this._additionalInformation = value;
    }
}