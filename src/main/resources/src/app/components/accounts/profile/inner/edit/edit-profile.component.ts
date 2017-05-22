import { Router } from '@angular/router';
import { Account } from '../../../../../beans/account/Account';
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

    private account = new Account();

    private servResponse: any;

    constructor(
        private httpService: HTTPService,
        private userService: UserService,
        private router: Router    
    ) { }

    public editUser() {
        if (this.account.email != "" && this.account.email.includes("@")) {                
            this.sendRequest();
        } else {
            console.log("Email isn't correct");
        }
    }

    private sendRequest() {
        this.httpService.sendData("/profile/" + this.userService.getUserId(), Account.serialize(this.account))
            .catch((error) => {
                console.log("Something went wrong. Try again later. Error: " + error);
                return null;
            })
            .subscribe(() => {
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
                    this.account = Account.deserialize(response);
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