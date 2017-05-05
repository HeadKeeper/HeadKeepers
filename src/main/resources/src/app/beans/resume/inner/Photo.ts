export class Photo {
    private _href: string;

    get href(): string {
        return this._href;
    }

    set href(value: string) {
        this._href = value;
    }
}