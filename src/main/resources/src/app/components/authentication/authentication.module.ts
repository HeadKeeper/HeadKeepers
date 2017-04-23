import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { SignUpModule } from "./inner/sign-up/sign-up.module";

import { AuthenticationComponent } from './authentication.component';

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule
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
