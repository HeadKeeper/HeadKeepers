import {Account} from "./Account";

export class EmployerAccount extends Account {
    private _name :string;
    private _description :string;
    private _address :string;

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