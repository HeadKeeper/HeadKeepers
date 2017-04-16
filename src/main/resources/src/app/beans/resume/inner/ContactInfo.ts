export class ContactInfo {
    private _type: string;
    private _value: string;

    public getType(): string {
        return this._type;
    }

    public setType(value: string) {
        this._type = value;
    }

    public getValue(): string {
        return this._value;
    }

    public setValue(value: string) {
        this._value = value;
    }
}