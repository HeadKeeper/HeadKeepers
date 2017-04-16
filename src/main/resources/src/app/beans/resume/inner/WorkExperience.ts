export class WorkExperience {
    private _companyName: string;
    private _position: string;
    private _duties: string;
    private _startDate: Date;
    private _finishDate: Date;

    public getCompanyName(): string {
        return this._companyName;
    }

    public setCompanyName(value: string) {
        this._companyName = value;
    }

    public getPosition(): string {
        return this._position;
    }

    public setPosition(value: string) {
        this._position = value;
    }

    public getDuties(): string {
        return this._duties;
    }

    public setDuties(value: string) {
        this._duties = value;
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