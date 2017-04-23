import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { ResumeModule } from "../components/entity/resume/resume.module";
import { ProfileModule } from "../components/accounts/profile/profile.module";
import { CompanyModule } from "../components/accounts/company/company.module";
import { VacancyModule } from "../components/entity/vacancy/vacancy.module";

import { HelpComponent } from "../components/main/help/help.component";
import { FooterComponent } from '../components/main/page-footer/page-footer.component';
import { WelcomeComponent } from "../components/main/welcome/welcome.component";
import { NavigationComponent } from '../components/main/navigation/navigation.component';
import { ApplicationComponent } from "./app.component";
import { PathNotFoundComponent } from "../components/errors/not-found/not-found.component";

import { rootRouting } from "./app.routing";

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,

        ResumeModule,
        ProfileModule,
        CompanyModule,
        VacancyModule,

        rootRouting
    ],
    declarations: [
        HelpComponent,
        FooterComponent,
        WelcomeComponent,
        NavigationComponent,        
        ApplicationComponent,
        PathNotFoundComponent
    ],
    bootstrap: [ 
        ApplicationComponent 
    ]
})

export class AppModule {
}
