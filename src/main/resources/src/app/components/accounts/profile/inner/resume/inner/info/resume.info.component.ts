import 'rxjs/Rx';
import { Http } from '@angular/http';
import { Router, ActivatedRoute } from "@angular/router";
import { Component, OnInit, OnDestroy } from '@angular/core';

import { Resume } from "../../../../../../../beans/resume/Resume";

import { HTTPService } from "../../../../../../../services/HTTPService";
import { UserService } from '../../../../../../../services/UserService';

@Component({
    selector: 'profile__resumes__edit',
    templateUrl: 'src/app/components/accounts/profile/inner/resume/inner/edit/edit-resume.component.html',
    styleUrls: [
        'src/app/assets/grid.css',
        'src/app/assets/form.css',
        'src/app/assets/panel.css'
    ]
})

export class ResumeInfoComponent implements OnInit, OnDestroy {
    
    private sub: any;
    private birthdayDate: string = this.getDateFromProject();
    private resumeId = 0;
    private resume = new Resume();

    ngOnInit(): void {
        this.sub = this.route.params.subscribe(params => {
            this.resumeId = +params['resumeId'];
            this.loadResume(this.userService.getUserId(), this.resumeId);
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

    private loadResume(userId: number, resumeId: number) {
        this.httpService.getData("/resume/" + this.resumeId)
            .catch((error) => {
                console.log("Something went wrong while getting resume: " + error);
                return null;
            })
            .subscribe((resumeJSON) => {
                this.resume = Resume.deserialize(resumeJSON);
                return null;
            });
    }

    private getDateFromProject(): string {
        if (this.resume == null) {
            return "";
        }
        var today = new Date(this.resume.birthdayDate);
        var dd = today.getDate();
        var mm = today.getMonth() + 1;
        var yyyy = today.getFullYear();

        let final = yyyy.toString();
        if (mm < 10) {
            final = final + "-0";
        } else {
            final = final + "-";
        }
        final = final + mm.toString();

        if (dd < 10) {
            final = final + "-0";
        } else {
            final = final + "-";
        }
        final = final + dd.toString();

        return final;
    }
}