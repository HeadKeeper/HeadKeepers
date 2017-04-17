import { Routes, RouterModule } from '@angular/router'

import { VacancyPanelComponent } from "./panel/panel";
import { VacancyComponent } from "./component/vacancy";
import { VacanciesEmployerComponent } from "./employer/employer";
import { VacancyCreateComponent } from "./create/create";
import { VacancyEditComponent } from "./edit/edit";

export const vacancyRoutes : Routes = [
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
                component: VacancyPanelComponent
            },
            {
                path: ':id',
                component: VacancyComponent
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
                path: 'edit',
                component: VacancyEditComponent
            }
        ]
    }
];

export const vacancyRouting = RouterModule.forChild(vacancyRoutes);
