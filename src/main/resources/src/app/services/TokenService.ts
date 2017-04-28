export class TokenService {
    private static _token: string;

    public static getToken(): string {
        return this._token;
    }

    public static setToken(value: string) {
        this._token = value;
    }

}