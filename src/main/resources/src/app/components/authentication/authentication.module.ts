import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { SignUpModule } from "./inner/sign-up/sign-up.module";
import { SignInModule } from "./inner/sign-in/sign-in.module";

import { AuthenticationComponent } from './authentication.component';

import { authenticationRouting } from "./authentication.routing";

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,

        SignInModule,
        SignUpModule,

        authenticationRouting
    ],
    exports: [
        AuthenticationComponent
    ],
    declarations: [
        AuthenticationComponent
    ],
    providers: [],
})

export class AuthenticationModule { }
