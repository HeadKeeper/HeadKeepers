import { Routes, RouterModule } from '@angular/router'

import { CompanyComponent } from "./company.component";
import { CompanyInfoComponent } from "./inner/information/company-information.component";

export const companyRoutes : Routes = [
    {
        path: 'company:id',
        component: CompanyComponent,
        children: [
            {
                path: 'information',
                component: CompanyInfoComponent
            }
        ]
    }
];

export const companyRouting = RouterModule.forRoot(companyRoutes);
