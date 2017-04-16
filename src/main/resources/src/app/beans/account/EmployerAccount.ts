import {Account} from "./Account";

export class EmployerAccount extends Account {
    private _name :string;
    private _description :string;
    private _address :string;

    public getName(): string {
        return this._name;
    }

    public setName(value: string) {
        this._name = value;
    }

    public getDescription(): string {
        return this._description;
    }

    public setDescription(value: string) {
        this._description = value;
    }

    public getAddress(): string {
        return this._address;
    }

    public setAddress(value: string) {
        this._address = value;
    }
}