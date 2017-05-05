export class AdditionalEducation {
    private _name: string;
    private _type: string;
    private _institutionName: string;
    private _startDate: Date;
    private _finishDate: Date;

    get name(): string {
        return this._name;
    }

    set name(value: string) {
        this._name = value;
    }

    get type(): string {
        return this._type;
    }

    set type(value: string) {
        this._type = value;
    }

    get institutionName(): string {
        return this._institutionName;
    }

    set institutionName(value: string) {
        this._institutionName = value;
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