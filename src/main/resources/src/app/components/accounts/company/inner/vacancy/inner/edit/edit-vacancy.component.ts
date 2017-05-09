import { Vacancy } from '../../../../../../../beans/vacancy/Vacancy';
import { UserService } from '../../../../../../../services/UserService';
import { Router } from '@angular/router';
import { HTTPService } from '../../../../../../../services/HTTPService';
import { OnInit } from '@angular/core';
import { Component } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/Rx';

@Component({
    selector: 'company__vacancies__edit',
    templateUrl: 'src/app/components/accounts/company/inner/vacancy/inner/edit/edit-vacancy.component.html'
})

export class VacancyEditComponent implements OnInit {

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
        if (this.userService.getId() != null) { 
            this.httpService.getData("/company/" + this.userService.getId())
                .catch((error) => {
                    alert("Something went wrong");
                    return null;
                })
                .subscribe((response) => {
                    this.vacancy = response;
                    return null;
                });
        } else {
            alert("You are not logged in.");
            this.router.navigate(["/accounts/login/company"]);
        }
    }
}