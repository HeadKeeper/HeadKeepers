import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { SignUpModule } from "./inner/sign-up/sign-up.module";

import { SignInComponent } from './inner/sign-in/sign-in.component';
import { AuthenticationComponent } from './authentication.component';

import { authenticationRouting } from "./authentication.routing";

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,

        SignUpModule,

        authenticationRouting
    ],
    exports: [
        SignInComponent,
        AuthenticationComponent
    ],
    declarations: [
        SignInComponent,
        AuthenticationComponent
    ],
    providers: [],
})

export class AuthenticationModule { }
