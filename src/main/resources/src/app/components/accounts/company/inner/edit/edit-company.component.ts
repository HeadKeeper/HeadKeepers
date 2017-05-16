import { Router } from '@angular/router';
import { EmployerAccount } from '../../../../../beans/account/EmployerAccount';
import { Component, OnInit } from '@angular/core';

import { HTTPService } from '../../../../../services/HTTPService';
import { UserService } from "../../../../../services/UserService";

@Component({
    selector: 'company__edit',
    templateUrl: 'src/app/components/accounts/company/inner/edit/edit-company.component.html',
    styleUrls: [
        'src/app/assets/grid.css',
        'src/app/assets/form.css',
        'src/app/assets/panel.css'
    ]
})

export class CompanyEditComponent implements OnInit {

    private pass: string;

    private account = new EmployerAccount();

    private servResponse: any;

    constructor(
        private httpService: HTTPService,
        private userService: UserService,
        private router: Router    
    ) { }

    public editCompany() {
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
        this.httpService.sendData("/company/" + this.userService.getUserId() + "/edit", this.account)
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
        if (this.userService.isCompany && this.userService.getUserId() != null) { 
            this.httpService.getData("/company/" + this.userService.getUserId())
                .catch((error) => {
                    alert("Something went wrong");
                    return null;
                })
                .subscribe((response) => {
                    this.account = EmployerAccount.deserialize(response);
                    return null;
                });
        } else {
            alert("You are not logged in.");
            this.router.navigate(["/accounts/login/company"]);
        }
    }

    ngOnInit() { 
        this.loadAccount();
    }
}