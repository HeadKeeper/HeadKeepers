import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';

import { VacancyComponent } from "./vacancy.component";
import { VacancyInfoComponent } from "./inner/information/vacancy.information.component";
import { VacancyEditComponent } from "./inner/edit/edit-vacancy.component";
import { VacancyCreateComponent } from "./inner/create/create-vacancy.component";
import { VacanciesEmployerComponent } from "./inner/list/vacancy-list.component";


@NgModule({
    imports: [
        BrowserModule,
        RouterModule,
        FormsModule,
        HttpModule
    ],
    declarations: [
        VacancyComponent,
        VacancyEditComponent,
        VacancyInfoComponent,
        VacancyCreateComponent,
        VacanciesEmployerComponent
    ],
    exports: [
        VacancyComponent,
        VacancyEditComponent,
        VacancyInfoComponent,
        VacancyCreateComponent,
        VacanciesEmployerComponent
    ]
})

export class VacancyModule {}
