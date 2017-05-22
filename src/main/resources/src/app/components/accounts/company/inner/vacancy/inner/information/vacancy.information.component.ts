import { Vacancy } from '../../../../../../../beans/vacancy/Vacancy';
import { UserService } from '../../../../../../../services/UserService';
import { Router, ActivatedRoute } from '@angular/router';
import { HTTPService } from '../../../../../../../services/HTTPService';
import { OnInit } from '@angular/core';
import { Component, OnDestroy } from '@angular/core';
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

export class VacancyInfoComponent implements OnInit, OnDestroy {
    
    private sub: any;
    private vacancyId = 0;
    private vacancy = new Vacancy();

    ngOnInit(): void {
        this.sub = this.route.params.subscribe(params => {
            this.vacancyId = +params['vacancyId'];
            this.loadVacancy(this.userService.getUserId(), this.vacancyId);
        })
    }

    ngOnDestroy() {
        this.sub.unsubscribe();
    }

    constructor(
        private httpService: HTTPService,
        private userService: UserService,
        private route: ActivatedRoute,
        private router: Router
    ) { }

    public editVacancy() {
        if (this.userService.isUser()) {
            this.sendRequest();
        } else {
            console.log("You don't have enought permissions to perform this action");
            this.router.navigate(['/welcome']);
        }
    }

    private sendRequest() {
        this.httpService.sendData("/edit/vacancy", Vacancy.serialize(this.vacancy))
            .catch((error) => {
                console.log("Something went wrong while editing vacancy: " + error);
                this.router.navigate(['../']);
                return null;
            })
            .subscribe(() => {
                console.log("Successful changed vacancy");                
                this.router.navigate(['../']);
            });
    }

    private loadVacancy(userId: number, vacancyId: number) {
        this.httpService.getData("/companies/" + this.userService.getUserId() + "/vacancy/" + this.vacancyId)
            .catch((error) => {
                console.log("Something went wrong while getting vacancy: " + error);
                this.router.navigate(['../']);
                return null;
            })
            .subscribe((vacancyJSON) => {
                this.vacancy = Vacancy.deserialize(vacancyJSON);
                return null;
            });
    }
}