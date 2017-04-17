import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { BrowserModule } from '@angular/platform-browser';

import { AccountModule } from "./components/account/account.module";
import { ResumeModule } from "./components/entity/resume/resume.module";
import { VacancyModule } from "./components/entity/vacancy/vacancy.module";

import { ApplicationComponent } from "./components/application/application";
import { NavigationComponent } from './components/navigation/navigation';
import { FooterComponent } from './components/page-footer/page-footer';

import { routing } from "./app.routing";

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,
        ReactiveFormsModule,

        AccountModule,
        ResumeModule,
        VacancyModule,

        routing
    ],
    declarations: [
        NavigationComponent,
        FooterComponent
    ],
    bootstrap: [ ApplicationComponent ]
})

export class AppModule {}
