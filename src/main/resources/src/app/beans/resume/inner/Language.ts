export class Language {
    private _name: string;
    private _level: string;

    public getName(): string {
        return this._name;
    }

    public setName(value: string) {
        this._name = value;
    }

    public getLevel(): string {
        return this._level;
    }

    public setLevel(value: string) {
        this._level = value;
    }
}