import { ProfileEditComponent } from './inner/edit/edit-profile.component';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { ResumeModule } from "./inner/resume/resume.module";

import { ProfileComponent } from './profile.component';
import { ProfileInfoComponent } from './inner/information/profile-information.component';

import { profileRouting } from "./profile.routing";

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,

        ResumeModule,

        profileRouting
    ],
    declarations: [
       ProfileComponent,
       ProfileInfoComponent,
       ProfileEditComponent,
    ],
    exports: [
       ProfileComponent,
       ProfileInfoComponent,
       ProfileEditComponent
    ]
})

export class ProfileModule {}
