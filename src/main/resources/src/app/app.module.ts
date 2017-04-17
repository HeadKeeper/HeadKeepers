import { NgModule } from '@angular/core';
import { LocationStrategy, HashLocationStrategy } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { BrowserModule } from '@angular/platform-browser';

import { ApplicationComponent } from './components/application/application';
import { NavigationComponent } from './components/navigation/navigation';
import { FooterComponent } from './components/page-footer/page-footer';
import { routing } from "./app.routing";

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,
        ReactiveFormsModule,
        routing
    ],
    declarations: [
        ApplicationComponent,
        NavigationComponent,
        FooterComponent
    ],
    bootstrap: [ ApplicationComponent ]
})

export class AppModule {}
