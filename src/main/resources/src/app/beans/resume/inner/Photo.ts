export class Photo {
    private _href: string;

    public getName(): string {
        return this._href;
    }

    public setName(value: string) {
        this._href = value;
    }
}