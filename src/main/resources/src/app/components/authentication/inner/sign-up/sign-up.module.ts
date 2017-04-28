import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { SignUpComponent } from './sign-up.component';
import { SignUpUserComponent } from "./inner/user/user.component";
import { SignUpCompanyComponent } from "./inner/employer/employer.component";

@NgModule({
    imports: [
        BrowserModule,
        RouterModule,
        FormsModule,
        HttpModule
    ],
    declarations: [
        SignUpComponent,
        SignUpUserComponent,
        SignUpCompanyComponent,
    ],
    exports: [
        SignUpComponent,
        SignUpUserComponent,
        SignUpCompanyComponent
    ]
})

export class SignUpModule {}
