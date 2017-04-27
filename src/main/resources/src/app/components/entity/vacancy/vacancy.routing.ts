import { ModuleWithProviders } from '@angular/core/core';
import { Routes, RouterModule } from '@angular/router'

import { VacancyComponent } from "./vacancy.component";
import { VacancyEditComponent } from "./inner/edit/edit-vacancy.component";
import { VacancyPanelComponent } from "./inner/panel/panel-vacancy.component";
import { VacancyCreateComponent } from "./inner/create/create-vacancy.component";
import { VacanciesEmployerComponent } from "./inner/employer/vacancy-employer.component";

export const vacancyRoutes : Routes = [
    {
        path: 'vacancy',
        component: VacancyComponent,
        children: [
            {
                path: ':id',
                pathMatch: 'full',
                component: VacancyPanelComponent
            },
            {
                path: 'employer/:id',
                component: VacanciesEmployerComponent
            },
            {
                path: 'create',
                component: VacancyCreateComponent
            },
            {
                path: ':id/edit',
                pathMatch: 'full',
                component: VacancyEditComponent
            }
        ]
    }
];

export const vacancyRouting: ModuleWithProviders = RouterModule.forRoot(vacancyRoutes);