import { Vacancy } from '../../../../../../../beans/vacancy/Vacancy';
import { Router } from "@angular/router";
import { HTTPService } from '../../../../../../../services/HTTPService';
import { UserService } from "../../../../../../../services/UserService";
import { Component, OnInit } from '@angular/core';
import 'rxjs/Rx';

@Component({
    selector: 'vacancies-employer',
    templateUrl: 'src/app/components/accounts/company/inner/vacancy/inner/employer/vacancy-employer.component.html'
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
        if (this.userService.getId() != null && this.userService.isCompany()) {
            this.httpService.getData("/companies/" + this.userService.getId() + "/vacancies")
                .catch((error) => {
                    alert("Something went wrong");
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