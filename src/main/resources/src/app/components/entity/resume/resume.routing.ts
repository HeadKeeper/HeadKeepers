import { ModuleWithProviders } from '@angular/core/core';
import { Routes, RouterModule } from '@angular/router';

import { ResumeComponent } from "./resume.component";
import { ResumeEditComponent } from "./inner/edit/edit-resume.component";
import { ResumePanelComponent } from "./inner/panel/panel-resume.component";
import { ResumesUserComponent } from "./inner/user/resume-user.component";
import { ResumeCreateComponent } from "./inner/create/create-resume.component";

export const resumeRoutes : Routes = [
    {
        path: 'resume',
        component: ResumeComponent,
        children: [
            {
                path: ':id',
                pathMatch: 'full',
                component: ResumePanelComponent
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
                path: ':id/edit',
                pathMatch: 'full',
                component: ResumeEditComponent
            }
        ]
    }
];

export const resumeRouting: ModuleWithProviders = RouterModule.forRoot(resumeRoutes);