import { Router } from '@angular/router';
import { HTTPService } from '../../../../../services/HTTPService';
import { EmployerAccount } from '../../../../../beans/account/EmployerAccount';
import { Component } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/Rx';
import { UserService } from "../../../../../services/UserService";

@Component({
    selector: 'company-information',
    templateUrl: 'src/app/components/accounts/company/inner/information/company-information.component.html'
})

export class CompanyInfoComponent {
    private account = new EmployerAccount();

    constructor(
        private httpService: HTTPService,
        private userService: UserService,
        private router: Router    
    ) { }

    private loadAccount() {
        if (this.userService.getId() != null) { 
            this.httpService.getData("/company/" + this.userService.getId())
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
            this.router.navigate(["/accounts/login/company"]);
        }
    }

    ngOnInit() { 
        this.loadAccount();
    }
}