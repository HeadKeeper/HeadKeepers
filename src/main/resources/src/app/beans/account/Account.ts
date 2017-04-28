export class Account {
    private _id: number;
    private _email: string;
    private _password: string;
    private _nickname: string;
    private _creationDate: Date;

    public getId(): number {
        return this._id;
    }

    public setId(value: number) {
        this._id = value;
    }

    public getEmail(): string {
        return this._email;
    }

    public setEmail(value: string) {
        this._email = value;
    }

    public getPassword(): string {
        return this._password;
    }

    public setPassword(value: string) {
        this._password = value;
    }

    public getNickname(): string {
        return this._nickname;
    }

    public setNickname(value: string) {
        this._nickname = value;
    }

    public getCreationDate(): Date {
        return this._creationDate;
    }

    public setCreationDate(value: Date) {
        this._creationDate = value;
    }
}