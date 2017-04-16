import {Account} from "./Account";

export class UserAccount extends Account {
    private _name :string;
    private _phoneNumber :string;

    public getName(): string {
        return this._name;
    }

    public setName(value: string) {
        this._name = value;
    }

    public getPhoneNumber(): string {
        return this._phoneNumber;
    }

    public setPhoneNumber(value: string) {
        this._phoneNumber = value;
    }
}