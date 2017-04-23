import { Routes, RouterModule } from '@angular/router'
import { ResumePanelComponent } from "./inner/panel/panel-resume.component";
import { ResumeComponent } from "./resume.component";
import { ResumesUserComponent } from "./inner/user/resume-user.component";
import { ResumeCreateComponent } from "./inner/create/create-resume.component";
import { ResumeEditComponent } from "./inner/edit/edit-resume.component";


export const resumeRoutes : Routes = [
    {
        path: '',
        component: ResumePanelComponent
    },
    {
        path: ':id',
        component: ResumeComponent
    },
    {
        path: 'user/:id',
        component: ResumesUserComponent
    },
    {
        path: 'create',
        component: ResumeCreateComponent
    },
    {
        path: 'edit',
        component: ResumeEditComponent
    }
];

export const resumeRouting = RouterModule.forChild(resumeRoutes);
