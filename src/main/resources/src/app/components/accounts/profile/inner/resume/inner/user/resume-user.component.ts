import { Resume } from '../../../../../../../beans/resume/Resume';
import { Router } from '@angular/router';
import { UserService } from '../../../../../../../services/UserService';
import { HTTPService } from '../../../../../../../services/HTTPService';
import { Component } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/Rx';

@Component({
    selector: 'profile__resumes__by-user',
    templateUrl: 'src/app/components/accounts/profile/inner/resume/inner/user/resume-user.component.html'
})

export class ResumesUserComponent {

     private resumes = new Array<Resume>();

    constructor(
        private httpService: HTTPService,
        private userService: UserService,
        private router: Router
    ) { }
    
    ngOnInit() {
        this.loadResumes();
    }

    private loadResumes() {
        if (this.userService.getId() != null && this.userService.isCompany()) {
            this.httpService.getData("/companies/" + this.userService.getId() + "/vacancies")
                .catch((error) => {
                    alert("Something went wrong");
                    return null;
                })
                .subscribe((data) => {
                    // TODO: Check returned data passing with array
                    this.resumes = data;
                    return null;
                })
        }
    }

}