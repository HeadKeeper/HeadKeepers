import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { BrowserModule } from '@angular/platform-browser';

import { UserInfoComponent } from "./user/user";
import { EmployerInfoComponent } from "./employer/employer";

import { informationRouting } from "./information.routing";

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,
        ReactiveFormsModule,

        informationRouting
    ],
    declarations: [
        EmployerInfoComponent,
        UserInfoComponent
    ],
    exports: [
        EmployerInfoComponent,
        UserInfoComponent
    ]
})

export class AccountInformationModule {}
