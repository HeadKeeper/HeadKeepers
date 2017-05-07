import { Router } from '@angular/router';
import { UserAccount } from '../../../../../../beans/account/UserAccount';
import { HTTPService } from '../../../../../../services/HTTPService';
import { Component } from '@angular/core';
import 'rxjs/Rx';

@Component({
    selector: 'sing-up-user',
    templateUrl: 'src/app/components/authentication/inner/sign-up/inner/user/user.component.html',
    styleUrls: ['src/app/components/authentication/inner/sign-up/inner/user/user.component.css']
})

export class SignUpUserComponent {
    
    private rePass: string;

    private account = new UserAccount();

    private servResponse: any;

    constructor(
        private httpService: HTTPService,
        private router: Router    
    ) { }

    public signUp() {
        if (this.account.email != "" && this.account.email.includes("@")) {
            if (this.account.password == this.rePass) {
                
                this.sendRequest();
            } else {
                alert("Password and re: doesn't match");
            }
        } else {
            alert("Email isn't correct");
        }
    }

    private sendRequest() {
        this.httpService.sendData("/registration", this.account)
            .catch((error) => {
                alert("Something went wrong. Try again later. Error: " + error);
                return null;
            })
            .subscribe((response) => {
                alert("Response: " + response);
                this.servResponse = response;
                this.httpService.setToken(this.servResponse.token);
                this.router.navigate(['/accounts/login']);
                return null;
            });
    }
}