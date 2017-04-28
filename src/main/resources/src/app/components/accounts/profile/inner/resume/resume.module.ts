import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';

import { ResumeComponent } from "./resume.component";
import { ResumeEditComponent } from "./inner/edit/edit-resume.component";
import { ResumesUserComponent } from "./inner/user/resume-user.component";
import { ResumeCreateComponent } from "./inner/create/create-resume.component";

@NgModule({
    imports: [
        BrowserModule,
        RouterModule,
        FormsModule,
        HttpModule
    ],
    declarations: [
        ResumeComponent,
        ResumeEditComponent,
        ResumesUserComponent,
        ResumeCreateComponent,
    ],
    exports: [
        ResumeComponent,
        ResumeEditComponent,
        ResumesUserComponent,
        ResumeCreateComponent,
    ]
})

export class ResumeModule {}
