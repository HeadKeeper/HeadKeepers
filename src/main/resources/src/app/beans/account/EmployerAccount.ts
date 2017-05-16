import {Account} from "./Account";

export class EmployerAccount extends Account {
    private _name :string;
    private _description :string;
    private _address :string;

    public static serialize(account: EmployerAccount): Object {
        return {
            user : {
                id: account.id,
                email: account.email,
                password: account.password,
                nickname: account.nickname,
                creationDate: account.creationDate
            },
            name : account._name,
            description : account._description,
            address : account._address
        };
    }

    public static deserialize(obj: any): EmployerAccount {
        var account = new EmployerAccount();

        account.id = obj.id;
        account.email = obj.email;
        account.password = obj.password;
        account.nickname = obj.nickname;
        account.creationDate = obj.creationDate;
        account.name = obj.name;
        account.description = obj.description;
        account.address = obj.address;

        return account;
    }

    get name(): string {
        return this._name;
    }

    set name(value: string) {
        this._name = value;
    }

    get description(): string {
        return this._description;
    }

    set description(value: string) {
        this._description = value;
    }

    get address(): string {
        return this._address;
    }

    set address(value: string) {
        this._address = value;
    }
}