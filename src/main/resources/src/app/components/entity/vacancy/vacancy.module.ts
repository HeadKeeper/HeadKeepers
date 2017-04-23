import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { BrowserModule } from '@angular/platform-browser';

import { VacancyComponent } from "./vacancy.component";
import { VacancyEditComponent } from "./inner/edit/edit-vacancy.component";
import { VacancyPanelComponent } from "./inner/panel/panel-vacancy.component";
import { VacancyCreateComponent } from "./inner/create/create-vacancy.component";
import { VacanciesEmployerComponent } from "./inner/employer/vacancy-employer.component";

import { vacancyRoutes, vacancyRouting } from './vacancy.routing';

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,

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
