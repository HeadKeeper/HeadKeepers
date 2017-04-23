import { Routes, RouterModule } from '@angular/router'

import { VacancyComponent } from "./vacancy.component";
import { VacancyEditComponent } from "./inner/edit/edit-vacancy.component";
import { VacancyPanelComponent } from "./inner/panel/panel-vacancy.component";
import { VacancyCreateComponent } from "./inner/create/create-vacancy.component";
import { VacanciesEmployerComponent } from "./inner/employer/vacancy-employer.component";

export const vacancyRoutes : Routes = [
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

];

export const vacancyRouting = RouterModule.forRoot(vacancyRoutes);