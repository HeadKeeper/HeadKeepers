export class UserService {
    private _id: number;
    private _type: number;

    public getId(): number {
        return this._id;
    }

    public setId(value: number) {
        this._id = value;
    }

    public setUser() {
        this._type = 1;
    }

    public setCompany() {
        this._type = 2;
    }

    public isCompany(): boolean {
        return this._type == 2;
    }

    public isUser(): boolean {
        return this._type == 1;
    }

}