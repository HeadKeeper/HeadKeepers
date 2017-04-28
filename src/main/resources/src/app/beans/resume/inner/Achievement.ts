export class Achievement {
    private _name: string;
    private _value: number;

    public getName(): string {
        return this._name;
    }

    public setName(value: string) {
        this._name = value;
    }

    public getValue(): number {
        return this._value;
    }

    public setValue(value: number) {
        this._value = value;
    }
}