import { Component } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/Rx';
import {Vacancy} from "../../../../../../../beans/vacancy/Vacancy";
import {HTTPService} from "../../../../../../../services/HTTPService";
import {Router} from "@angular/router";

@Component({
    selector: 'company__vacancies__create',
    templateUrl: 'src/app/components/accounts/company/inner/vacancy/inner/create/create-vacancy.component.html',
    styleUrls: [
        'src/app/assets/grid.css',
        'src/app/assets/form.css',
        'src/app/assets/panel.css'
    ]
})

export class VacancyCreateComponent {

    private vacancy = new Vacancy();

    constructor(
        private httpService: HTTPService,
        private router: Router
    ) { }

    public createVacancy() {
        this.sendRequest();
    }

    private sendRequest() {
        this.httpService.sendData("/add/vacancy", Vacancy.serialize(this.vacancy))
            .catch((error) => {
                console.log("Something went wrong. Try again later. Error: " + error);
                return null;
            })
            .subscribe(() => {
                console.log("Successful added new vacancy");
                this.router.navigate(['../']);
            });
    }

}