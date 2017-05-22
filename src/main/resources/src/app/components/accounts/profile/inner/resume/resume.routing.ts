import { ModuleWithProviders } from '@angular/core/core';
import { Routes, RouterModule } from '@angular/router';

import { ResumeComponent } from "./resume.component";
import { ResumeEditComponent } from "./inner/edit/edit-resume.component";
import { ResumesUserComponent } from "./inner/list/resume-list.component";
import { ResumeCreateComponent } from "./inner/create/create-resume.component";
import { ResumeInfoComponent } from "./inner/info/resume.info.component";

export const resumeRoutes : Routes = [
    {
        path: '',
        children: [
            {
                path: '',
                pathMatch: 'full',
                component: ResumesUserComponent
            },
            {
                path: 'create',
                component: ResumeCreateComponent
            },
            {
                path: ':resumeId',
                component: ResumeInfoComponent
            },
            {
                path: ':resumeId/edit',
                component: ResumeEditComponent
            }
        ]
    },
];

export const resumeRouting: ModuleWithProviders = RouterModule.forRoot(resumeRoutes);