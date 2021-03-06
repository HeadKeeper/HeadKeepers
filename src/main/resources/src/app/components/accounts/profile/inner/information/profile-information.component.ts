import { Router } from '@angular/router';
import { HTTPService } from '../../../../../services/HTTPService';
import { UserAccount } from '../../../../../beans/account/UserAccount';
import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/Rx';
import { UserService } from "../../../../../services/UserService";

@Component({
    selector: 'profile__information',
    templateUrl: 'src/app/components/accounts/profile/inner/information/profile-information.component.html',
    styleUrls: [
        'src/app/assets/grid.css',
        'src/app/assets/form.css',
        'src/app/assets/panel.css'
    ]
})

export class ProfileInfoComponent implements OnInit {
    
    private account = new UserAccount();

    constructor(
        private httpService: HTTPService,
        private userService: UserService,
        private router: Router    
    ) { }

    private loadAccount() {
        if (this.userService.getUserId() != null) { 
            this.httpService.getData("/user/" + this.userService.getUserId())
                .catch((error) => {
                    console.log(error);
                    // console.log("Something went wrong");
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