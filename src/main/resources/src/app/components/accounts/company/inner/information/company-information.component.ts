import { Router } from '@angular/router';
import { HTTPService } from '../../../../../services/HTTPService';
import { EmployerAccount } from '../../../../../beans/account/EmployerAccount';
import { Component } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/Rx';
import { UserService } from "../../../../../services/UserService";

@Component({
    selector: 'company__information',
    templateUrl: 'src/app/components/accounts/company/inner/information/company-information.component.html',
    styleUrls: [
        'src/app/assets/grid.css',
        'src/app/assets/form.css',
        'src/app/assets/panel.css'
    ]
})

export class CompanyInfoComponent {
    private account = new EmployerAccount();

    constructor(
        private httpService: HTTPService,
        private userService: UserService,
        private router: Router    
    ) { }

    private loadAccount() {
        this.httpService.getData("/company/" + this.userService.getUserId())
            .catch((error) => {
                alert("Something went wrong");
                return null;
            })
            .subscribe((response) => {
                this.account = EmployerAccount.deserialize(response);
                return null;
            });
    }

    ngOnInit() { 
        this.loadAccount();
    }
}