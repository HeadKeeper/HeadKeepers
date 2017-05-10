import { Component } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/Rx';
import {HTTPService} from "../../../../../../../services/HTTPService";
import {Router} from "@angular/router";
import {Resume} from "../../../../../../../beans/resume/Resume";

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

    constructor(
        private httpService: HTTPService,
        private router: Router
    ) { }

    public sendResume() {
        // add data validation if need (but on server side it was)
        // TODO: ADD USER ID TO this.resume FROM TOKEN!!!!
        this.sendRequest();
    }

    private sendRequest() {
        this.httpService.sendData("/add/resume", Resume.serialize(this.resume))
            .catch((error) => {
                alert("Something went wrong. Try again later. Error: " + error);
                return null;
            });
    }
}