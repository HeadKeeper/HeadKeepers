import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { ResumeComponent } from "./resume.component";
import { ResumeEditComponent } from "./inner/edit/edit-resume.component";
import { ResumesUserComponent } from "./inner/user/resume-user.component";
import { ResumePanelComponent } from "./inner/panel/panel-resume.component";
import { ResumeCreateComponent } from "./inner/create/create-resume.component";

import { resumeRouting } from "./resume.routing";

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,
       
        resumeRouting
    ],
    declarations: [
        ResumeComponent,
        ResumeEditComponent,
        ResumesUserComponent,
        ResumePanelComponent,
        ResumeCreateComponent,
    ],
    exports: [
        ResumeComponent,
        ResumeEditComponent,
        ResumesUserComponent,
        ResumePanelComponent,
        ResumeCreateComponent,
    ]
})

export class ResumeModule {}
