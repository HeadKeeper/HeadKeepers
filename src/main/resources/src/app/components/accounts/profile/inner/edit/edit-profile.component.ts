import { Router } from '@angular/router';
import { UserAccount } from '../../../../../beans/account/UserAccount';
import { HTTPService } from '../../../../../services/HTTPService';
import { Component, OnInit } from '@angular/core';
import { UserService } from "../../../../../services/UserService";

@Component({
    selector: 'profile__edit',
    templateUrl: 'src/app/components/accounts/profile/inner/edit/edit-profile.component.html'
})

export class ProfileEditComponent implements OnInit {
    
    private pass: string;

    private account = new UserAccount();

    private servResponse: any;

    constructor(
        private httpService: HTTPService,
        private userService: UserService,
        private router: Router    
    ) { }

    public changeProfile() {
        if (this.account.email != "" && this.account.email.includes("@")) {
            if (this.account.password == this.pass) {
                
                this.sendRequest();
            } else {
                alert("Password doesn't match");
            }
        } else {
            alert("Email isn't correct");
        }
    }

    private sendRequest() {
        this.httpService.sendData("/profile/" + this.userService.getId() + "/edit", this.account)
            .catch((error) => {
                alert("Something went wrong. Try again later. Error: " + error);
                return null;
            })
            .subscribe((response) => {
                alert("Response: " + response);
                this.servResponse = response;
                this.httpService.setToken(this.servResponse.token);
                this.router.navigate(['/welcome']);
                return null;
            });
    }

    private loadAccount() {
        if (this.userService.getId() != null) { 
            this.httpService.getData("/profile/" + this.userService.getId())
                .catch((error) => {
                    alert("Something went wrong");
                    return null;
                })
                .subscribe((response) => {
                    this.account = response;
                    return null;
                });
        } else {
            alert("You are not logged in.");
            this.router.navigate(["/accounts/login/user"]);
        }
    }

    ngOnInit() { 
        this.loadAccount();
    }
}