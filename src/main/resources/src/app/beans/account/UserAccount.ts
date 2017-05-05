import {Account} from "./Account";

export class UserAccount extends Account {
    private _name :string;
    private _phoneNumber :string;

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