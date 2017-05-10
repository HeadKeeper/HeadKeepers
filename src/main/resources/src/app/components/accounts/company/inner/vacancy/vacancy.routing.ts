import { ModuleWithProviders } from '@angular/core/core';
import { Routes, RouterModule } from '@angular/router'

import { VacancyComponent } from "./vacancy.component";
import { VacancyInfoComponent } from "./inner/information/vacancy.information.component";
import { VacancyEditComponent } from "./inner/edit/edit-vacancy.component";
import { VacancyCreateComponent } from "./inner/create/create-vacancy.component";
import { VacanciesEmployerComponent } from "./inner/employer/vacancy-employer.component";

export const vacancyRoutes : Routes = [
    {
        path: '',
        children: [
            {
                path: '',
                pathMatch: 'full',
                component: VacanciesEmployerComponent
            },
            {
                path: 'create',
                component: VacancyCreateComponent
            },
            {
                path: ':vacancyId',
                component: VacancyComponent,
                children: [
                    {
                        path: '',
                        component: VacancyInfoComponent
                    },
                    {
                        path: 'edit',
                        component: VacancyEditComponent
                    }
                ]
            }
        ]
    }
];

export const vacancyRouting: ModuleWithProviders = RouterModule.forRoot(vacancyRoutes);