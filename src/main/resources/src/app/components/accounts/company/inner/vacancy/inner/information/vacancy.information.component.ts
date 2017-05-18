import { Vacancy } from '../../../../../../../beans/vacancy/Vacancy';
import { UserService } from '../../../../../../../services/UserService';
import { Router } from '@angular/router';
import { HTTPService } from '../../../../../../../services/HTTPService';
import { OnInit } from '@angular/core';
import { Component } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/Rx';

@Component({
    selector: 'company__vacancies__vacancy__info',
    templateUrl: 'src/app/components/accounts/company/inner/vacancy/inner/information/vacancy.information.component.html',
    styleUrls: [
        'src/app/assets/grid.css',
        'src/app/assets/form.css',
        'src/app/assets/panel.css'
    ]
})

export class VacancyInfoComponent implements OnInit {

    private vacancy = new Vacancy();

    constructor(
        private httpService: HTTPService,
        private userService: UserService,
        private router: Router    
    ) { }

    public ngOnInit() {
        this.loadVacancy();
    }

    private loadVacancy() {
        if (this.userService.getUserId() != null) { 
            this.httpService.getData("/company/" + this.userService.getUserId())
                .catch((error) => {
                    console.log("Something went wrong");
                    return null;
                })
                .subscribe((response) => {
                    this.vacancy = response;
                    return null;
                });
        } else {
            console.log("You are not logged in.");
            this.router.navigate(["/accounts/login/company"]);
        }
    }
}