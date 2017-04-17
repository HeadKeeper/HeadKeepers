import { Routes, RouterModule } from '@angular/router'

import { accountRoutes } from './components/account/account.routing'
import { resumeRoutes } from "./components/entity/resume/resume.routing";
import { vacancyRoutes } from "./components/entity/vacancy/vacancy.routing";

const routes : Routes = [
    {
        path: '',
        children: [
            {
                path: '',
                redirectTo: '/home',
                pathMatch: 'full',
            },
            {
                path: 'account',
                children: [...accountRoutes]
            },
            {
                path: 'vacancies',
                children: [...vacancyRoutes]
            },
            {
                path: 'resumes',
                children: [...resumeRoutes]
            }
        ]
    },
];

export const routing = RouterModule.forRoot(routes);