export class Account {
    private _id: number;
    private _email: string;
    private _password: string;
    private _nickname: string;
    private _creationDate: Date;

    get id(): number {
        return this._id;
    }

    set id(value: number) {
        this._id = value;
    }

    get email(): string {
        return this._email;
    }

    set email(value: string) {
        this._email = value;
    }

    get password(): string {
        return this._password;
    }

    set password(value: string) {
        this._password = value;
    }

    get nickname(): string {
        return this._nickname;
    }

    set nickname(value: string) {
        this._nickname = value;
    }

    get creationDate(): Date {
        return this._creationDate;
    }

    set creationDate(value: Date) {
        this._creationDate = value;
    }

    
}