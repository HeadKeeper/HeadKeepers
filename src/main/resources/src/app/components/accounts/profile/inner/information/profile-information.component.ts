import { Router } from '@angular/router';
import { HTTPService } from '../../../../../services/HTTPService';
import { UserAccount } from '../../../../../beans/account/UserAccount';
import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/Rx';
import { UserService } from "../../../../../services/UserService";

@Component({
    selector: 'profile-information',
    templateUrl: 'src/app/components/accounts/profile/inner/information/profile-information.component.html'
})

export class ProfileInfoComponent implements OnInit {
    
    private account = new UserAccount();

    constructor(
        private httpService: HTTPService,
        private userService: UserService,
        private router: Router    
    ) { }

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