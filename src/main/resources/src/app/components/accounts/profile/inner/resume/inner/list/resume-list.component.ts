import { Resume } from '../../../../../../../beans/resume/Resume';
import { Router, ActivatedRoute } from '@angular/router';
import { UserService } from '../../../../../../../services/UserService';
import { HTTPService } from '../../../../../../../services/HTTPService';
import { Component } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/Rx';

@Component({
    selector: 'profile__resumes__by-user',
    templateUrl: 'src/app/components/accounts/profile/inner/resume/inner/list/resume-list.component.html',
    styleUrls: [
        'src/app/assets/grid.css',
        'src/app/assets/form.css',
        'src/app/assets/panel.css'
    ]
})

export class ResumesUserComponent {

    private resumes = new Array<Resume>();

    private sub: any;

    constructor(
        private httpService: HTTPService,
        private userService: UserService,
        private route: ActivatedRoute,
        private router: Router
    ) { }

    ngOnInit() {
        this.loadProjects(this.userService.getUserId());
    }

    ngOnDestroy() {
    }

    private loadProjects(userId: number) {
        if (this.userService.getUserId() != 0) {
            this.httpService.getData("/users/" + userId + "/resumes")
                .catch((error) => {
                    console.log("Something went wrong while getting projects : " + error);
                    this.router.navigate(['../']);
                    return null;
                })
                .subscribe((data) => {
                    this.deserializeResponse(data);
                    return null;
                })
        } else {
            console.log("Permission denied");
        }
    }

    private deserializeResponse(response: any) {
        let resumesJSON = response;
        let resumes = new Array<Resume>();

        resumesJSON.forEach(function(element: any) {
            let resume = Resume.deserialize(element);
            resumes.push(resume);
        });
        
        this.resumes = resumes;
    }


}