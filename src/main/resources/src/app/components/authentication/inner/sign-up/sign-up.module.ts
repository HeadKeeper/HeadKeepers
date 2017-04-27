import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { SignUpComponent } from './sign-up.component';
import { SignUpUserComponent } from "./inner/user/user.component";
import { SignUpEmployerComponent } from "./inner/employer/employer.component";

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
        SignUpEmployerComponent,
    ],
    exports: [
        SignUpComponent,
        SignUpUserComponent,
        SignUpEmployerComponent
    ]
})

export class SignUpModule {}
