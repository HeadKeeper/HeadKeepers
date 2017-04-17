import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { BrowserModule } from '@angular/platform-browser';

import { ResumeComponent } from "./component/resume";
import { ResumeEditComponent } from "./edit/edit";
import { ResumesUserComponent } from "./user/user";
import { ResumePanelComponent } from "./panel/panel";
import { ResumeCreateComponent } from "./create/create";

import { resumeRouting } from "./resume.routing";

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,
        ReactiveFormsModule,

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
