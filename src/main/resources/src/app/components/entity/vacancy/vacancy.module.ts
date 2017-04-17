import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { BrowserModule } from '@angular/platform-browser';

import { VacancyComponent } from "./component/vacancy";
import { VacancyEditComponent } from "./edit/edit";
import { VacancyPanelComponent } from "./panel/panel";
import { VacancyCreateComponent } from "./create/create";
import { VacanciesEmployerComponent } from "./employer/employer";

import { vacancyRouting } from "./vacancy.routing";

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,
        ReactiveFormsModule,

        vacancyRouting
    ],
    declarations: [
        VacancyComponent,
        VacancyEditComponent,
        VacancyPanelComponent,
        VacancyCreateComponent,
        VacanciesEmployerComponent
    ],
    exports: [
        VacancyComponent,
        VacancyEditComponent,
        VacancyPanelComponent,
        VacancyCreateComponent,
        VacanciesEmployerComponent
    ]
})

export class VacancyModule {}
