export class Language {
    private _name: string;
    private _level: string;

    get name(): string {
        return this._name;
    }

    set name(value: string) {
        this._name = value;
    }

    get level(): string {
        return this._level;
    }

    set level(value: string) {
        this._level = value;
    }
}