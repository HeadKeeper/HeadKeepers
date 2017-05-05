export class WorkExperience {
    private _companyName: string;
    private _position: string;
    private _duties: string;
    private _startDate: Date;
    private _finishDate: Date;

    get companyName(): string {
        return this._companyName;
    }

    set companyName(value: string) {
        this._companyName = value;
    }

    get position(): string {
        return this._position;
    }

    set position(value: string) {
        this._position = value;
    }

    get duties(): string {
        return this._duties;
    }

    set duties(value: string) {
        this._duties = value;
    }

    get startDate(): Date {
        return this._startDate;
    }

    set startDate(value: Date) {
        this._startDate = value;
    }

    get finishDate(): Date {
        return this._finishDate;
    }

    set finishDate(value: Date) {
        this._finishDate = value;
    }
}