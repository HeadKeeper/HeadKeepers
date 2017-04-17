import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { BrowserModule } from '@angular/platform-browser';

import { SignUpModule } from "./sign-up/sign-up.module";
import { AccountInformationModule } from "./information/information.module";

import { accountRouting } from "./account.routing";

import { SignInComponent } from "./sign-in/sign-in";

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,
        ReactiveFormsModule,

        SignUpModule,
        AccountInformationModule,

        accountRouting
    ],
    declarations: [
        SignInComponent
    ],
    exports: [
        SignInComponent
    ]
})

export class AccountModule {}
