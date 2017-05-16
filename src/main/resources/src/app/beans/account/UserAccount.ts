import {Account} from "./Account";

export class UserAccount extends Account {
    private _name :string;
    private _phoneNumber :string;

public static serialize(account: UserAccount): Object {
        return {
            user : {
                id: account.id,
                email: account.email,
                password: account.password,
                nickname: account.nickname,
                creationDate: account.creationDate
            },
            name : account._name,
            phoneNumber : account._phoneNumber,
        };
    }

    public static deserialize(obj: any): UserAccount {
        var account = new UserAccount();

        account.id = obj.id;
        account.email = obj.email;
        account.password = obj.password;
        account.nickname = obj.nickname;
        account.creationDate = obj.creationDate;
        account.name = obj.name;
        account.phoneNumber = obj.phoneNumber;

        return account;
    }

    get name(): string {
        return this._name;
    }

    set name(value: string) {
        this._name = value;
    }

    get phoneNumber(): string {
        return this._phoneNumber;
    }

    set phoneNumber(value: string) {
        this._phoneNumber = value;
    }
}