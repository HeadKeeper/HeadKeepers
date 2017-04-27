import { ModuleWithProviders } from '@angular/core/core';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router'

import { CompanyComponent } from "./company.component";
import { CompanyInfoComponent } from "./inner/information/company-information.component";

export const companyRoutes : Routes = [
    {
        path: 'company',
        component: CompanyComponent,
        children: [
            {
                path: ':id/information',
                component: CompanyInfoComponent
            }
        ]
    }
];

export const companyRouting: ModuleWithProviders = RouterModule.forRoot(companyRoutes);