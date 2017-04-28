import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { VacancyModule } from './inner/vacancy/vacancy.module';

import { CompanyComponent } from './company.component';
import { CompanyInfoComponent } from './inner/information/company-information.component';
import { CompanyEditComponent } from "./inner/edit/edit-company.component";

import { companyRouting } from './company.routing';

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,

        VacancyModule,
        
        companyRouting
    ],
    exports: [
        CompanyComponent,
        CompanyInfoComponent,
        CompanyEditComponent
    ],
    declarations: [
        CompanyComponent,
        CompanyInfoComponent,
        CompanyEditComponent
    ],
    providers: [],
})

export class CompanyModule { }
