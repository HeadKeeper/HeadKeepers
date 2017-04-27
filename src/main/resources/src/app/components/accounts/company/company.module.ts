import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { CompanyComponent } from './company.component';
import { CompanyInfoComponent } from './inner/information/company-information.component';

import { companyRouting } from './company.routing';

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,
        
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
