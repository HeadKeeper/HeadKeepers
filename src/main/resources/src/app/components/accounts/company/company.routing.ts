import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router'

import { CompanyComponent } from "./company.component";
import { CompanyInfoComponent } from "./inner/information/company-information.component";
import { CompanyEditComponent } from "./inner/edit/edit-company.component";

import { vacancyRoutes } from "./inner/vacancy/vacancy.routing";

export const companyRoutes : Routes = [
    {
        path: 'companies',
        component: CompanyComponent,
        children: [
            {
                path: ':companyId',
                component: CompanyInfoComponent
            },
            {
                path: ':companyId/edit',
                component: CompanyEditComponent
            },
            {
                path: ':companyId/vacancies',
                children: [...vacancyRoutes]
            }
        ]
    }
];

export const companyRouting: ModuleWithProviders = RouterModule.forRoot(companyRoutes);