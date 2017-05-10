import { Component } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/Rx';
import {Resume} from "../../../../../../../beans/resume/Resume";
import {HTTPService} from "../../../../../../../services/HTTPService";
import {Router} from "@angular/router";

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
        private router: Router
    ) { }

}