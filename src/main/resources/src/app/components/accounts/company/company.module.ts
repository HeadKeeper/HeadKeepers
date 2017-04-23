import { CompanyInfoComponent } from './inner/information/company-information.component';
import { NgModule } from '@angular/core';

import { CompanyComponent } from './company.component';

import { companyRoutes, companyRouting } from './company.routing';

@NgModule({
    imports: [
        companyRouting
    ],
    exports: [
        CompanyComponent,
        CompanyInfoComponent
    ],
    declarations: [
        CompanyComponent,
        CompanyInfoComponent
    ],
    providers: [],
})

export class CompanyModule { }
