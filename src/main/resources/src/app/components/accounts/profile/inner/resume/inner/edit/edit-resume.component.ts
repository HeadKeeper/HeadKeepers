import 'rxjs/Rx';
import { Http } from '@angular/http';
import { Router } from "@angular/router";
import { Component } from '@angular/core';

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

export class ResumeEditComponent {

    private resume = new Resume();

    constructor(
        private httpService: HTTPService,
        private userService: UserService,
        private router: Router
    ) { }

    public editResume() {
        if (this.userService.isUser()) {
            this.sendRequest();
        } else {
            console.log("You don't have enought permissions to perform this action");
            this.router.navigate(['/welcome']);
        }
    }

    private sendRequest() {
        this.httpService.sendData("/edit/resume", Resume.serialize(this.resume))
            .catch((error) => {
                console.log("Something went wrong while editing resume: " + error);
                this.router.navigate(['../']);
                return null;
            })
            .subscribe(() => {
                this.router.navigate(['../']);
            });
    }
}