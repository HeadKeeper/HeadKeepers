export class Account {
    private _id: number;
    private _email: string;
    private _password: string;
    private _nickname: string;
    private _creationDate: Date;

    public static serialize(account: Account): Object {
        return {
            id : account._id,
            email : account._email,
            password : account._password,
            nickname : account._nickname,
            creationDate : account._creationDate
        };
    }

    public static serializeForLogin(account: Account): Object {
        return {
            email : account._email,
            password : account._password
        };
    }

    public static deserialize(obj: any): Account {
        var account = new Account();

        account.id = obj.id;
        account.email = obj.email;
        account.password = obj.password;
        account.nickname = obj.nickname;
        account.creationDate = obj.creationDate;

        return account;
    }

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