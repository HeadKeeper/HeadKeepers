export class Education {
    private _institutionName: string;
    private _facultyName: string;
    private _type: string;
    private _startDate: Date;
    private _finishDate: Date;
    private _additionalInformation: string;

    get institutionName(): string {
        return this._institutionName;
    }

    set institutionName(value: string) {
        this._institutionName = value;
    }

    get facultyName(): string {
        return this._facultyName;
    }

    set facultyName(value: string) {
        this._facultyName = value;
    }

    get type(): string {
        return this._type;
    }

    set type(value: string) {
        this._type = value;
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

    get additionalInformation(): string {
        return this._additionalInformation;
    }

    set additionalInformation(value: string) {
        this._additionalInformation = value;
    }
}