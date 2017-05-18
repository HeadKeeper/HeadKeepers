import { Vacancy } from '../../../../../../../beans/vacancy/Vacancy';
import { Router } from "@angular/router";
import { HTTPService } from '../../../../../../../services/HTTPService';
import { UserService } from "../../../../../../../services/UserService";
import { Component, OnInit } from '@angular/core';
import 'rxjs/Rx';

@Component({
    selector: 'company__vacancies__by-employer',
    templateUrl: 'src/app/components/accounts/company/inner/vacancy/inner/employer/vacancy-employer.component.html',
    styleUrls: [
        'src/app/assets/grid.css',
        'src/app/assets/form.css',
        'src/app/assets/panel.css'
    ]
})

export class VacanciesEmployerComponent implements OnInit {
    
    private vacancies = new Array<Vacancy>();

    constructor(
        private httpService: HTTPService,
        private userService: UserService,
        private router: Router
    ) { }
    
    ngOnInit() {
        this.loadVacancies();
    }

    private loadVacancies() {
        if (this.userService.getUserId() != null && this.userService.isCompany()) {
            this.httpService.getData("/companies/" + this.userService.getUserId() + "/vacancies")
                .catch((error) => {
                    console.log("Something went wrong");
                    return null;
                })
                .subscribe((data) => {
                    // TODO: Check returned data passing with array
                    this.vacancies = data;
                    return null;
                })
        }
    }
}