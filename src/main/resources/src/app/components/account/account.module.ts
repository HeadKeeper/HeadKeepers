import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { BrowserModule } from '@angular/platform-browser';

import { accountRouting } from "./account.routing";

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,
        ReactiveFormsModule,
        //accountRouting
    ],
    declarations: [
        //TODO: Create
    ],
    bootstrap: [ /*TODO: Write*/ ]
})

export class AccountModule {}
