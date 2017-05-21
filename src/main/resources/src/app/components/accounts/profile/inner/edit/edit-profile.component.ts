import { Router } from '@angular/router';
import { UserAccount } from '../../../../../beans/account/UserAccount';
import { HTTPService } from '../../../../../services/HTTPService';
import { Component, OnInit } from '@angular/core';
import { UserService } from "../../../../../services/UserService";

@Component({
    selector: 'profile__edit',
    templateUrl: 'src/app/components/accounts/profile/inner/edit/edit-profile.component.html',
    styleUrls: [
        'src/app/assets/grid.css',
        'src/app/assets/form.css',
        'src/app/assets/panel.css'
    ]
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

    public changeUser() {
        if (this.account.email != "" && this.account.email.includes("@")) {
            if (this.account.password == this.pass) {
                
                this.sendRequest();
            } else {
                console.log("Password doesn't match");
            }
        } else {
            console.log("Email isn't correct");
        }
    }

    private sendRequest() {
        this.httpService.sendData("/profile/" + this.userService.getUserId(), UserAccount.serialize(this.account))
            .catch((error) => {
                console.log("Something went wrong. Try again later. Error: " + error);
                return null;
            })
            .subscribe((response) => {
                this.servResponse = response;
                this.httpService.setToken(this.servResponse.token);
                this.router.navigate(['/welcome']);
                return null;
            });
    }

    private loadAccount() {
        if (this.userService.getUserId() != null) { 
            this.httpService.getData("/user/" + this.userService.getUserId())
                .catch((error) => {
                    console.log("Something went wrong");
                    return null;
                })
                .subscribe((response) => {
                    this.account = UserAccount.deserialize(response);
                    return null;
                });
        } else {
            console.log("You are not logged in.");
            this.router.navigate(["/accounts/login/user"]);
        }
    }

    ngOnInit() { 
        this.loadAccount();
    }
}