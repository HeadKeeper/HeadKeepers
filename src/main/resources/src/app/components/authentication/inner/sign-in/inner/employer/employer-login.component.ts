import { Router } from '@angular/router';
import { Account } from '../../../../../../beans/account/Account';
import { HTTPService } from '../../../../../../services/HTTPService';
import { UserService } from "../../../../../../services/UserService";
import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'company-login',
    templateUrl: 'src/app/components/authentication/inner/sign-in/inner/employer/employer-login.component.html'
})

export class SignInCompanyComponent implements OnInit {
    
    private rePass: string;

    private account = new Account();

    private servResponse: any;

    constructor(
        private httpService: HTTPService,
        private userService: UserService,
        private router: Router    
    ) { }

    public signUp() {
        if (this.account.password == this.rePass) {
        
            if (this.account.email != null) {
                this.sendData();
            } else {
                alert("Email is not correct");
            }
        } else {
            alert("Password and re: doesn't match");
        }
    }

    private sendData() {
        this.httpService.sendData("/login", this.account)
            .catch((error) => {
                alert("Something went wrong. Try again later. Error: " + error);
                return null;
            })
            .subscribe((response) => {
                alert("Response: " + response);
                this.servResponse = response;
                this.httpService.setToken(this.servResponse.token);
                this.userService.setId(this.servResponse.id);
                this.router.navigate(['/welcome']);
                return null;
            });
    }

    ngOnInit() { }
}