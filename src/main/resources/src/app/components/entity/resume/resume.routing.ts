import { Routes, RouterModule } from '@angular/router'

import { ResumeComponent } from "./component/resume";
import { ResumeCreateComponent } from "./create/create";
import { ResumesUserComponent } from "./user/user";
import { ResumeEditComponent } from "./edit/edit";
import { ResumePanelComponent } from "./panel/panel";

export const resumeRoutes : Routes = [
    {
        path: "",
        children : [
            {
                path: '',
                redirectTo: 'panel',
                pathMatch: 'full'
            },
            {
                path: 'panel',
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
        ]
    }
];

export const resumeRouting = RouterModule.forChild(resumeRoutes);
