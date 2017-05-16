import { Component } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/Rx';

import { Router } from "@angular/router";
import { Resume } from "../../../../../../../beans/resume/Resume";

import { UserService } from '../../../../../../../services/UserService';
import { HTTPService } from "../../../../../../../services/HTTPService";

@Component({
    selector: 'profile__resumes__create',
    templateUrl: 'src/app/components/accounts/profile/inner/resume/inner/create/create-resume.component.html',
    styleUrls: [
        'src/app/assets/grid.css',
        'src/app/assets/form.css',
        'src/app/assets/panel.css'
    ]
})

export class ResumeCreateComponent {

    private resume = new Resume();
    private rePass: string;

    constructor(
        private httpService: HTTPService,
        private userService: UserService, 
        private router: Router
    ) { }

    public createResume() {
        this.sendRequest();
    }

    private sendRequest() {
        if (this.userService.isUser()){
            this.httpService.sendData("/add/resume", Resume.serialize(this.resume))
                .catch((error) => {
                    console.log("Something went wrong while adding resume: " + error);
                    this.router.navigate(['/..']);                    
                    return null;
                })
                .subscribe(() => {
                    this.router.navigate(['/..']);
                });
        } else {
            console.log("You don't have enought permissions to perform this action");
        }
    }
}