import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { BrowserModule } from '@angular/platform-browser';

import { SignUpComponent } from "./component/sign-up.component";
import { SignUpUserComponent } from "./user/user.component";
import { SignUpEmployerComponent } from "./employer/employer.component";

import { signUpRouting } from "./sign-up.routing";

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,
        ReactiveFormsModule,

        signUpRouting
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
