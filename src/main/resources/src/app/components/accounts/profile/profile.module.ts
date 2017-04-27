import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { ProfileComponent } from './profile.component';
import { ProfileInfoComponent } from './inner/information/profile-information.component';

import { profileRouting } from "./profile.routing";

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,

        profileRouting
    ],
    declarations: [
       ProfileComponent,
       ProfileInfoComponent
    ],
    exports: [
       ProfileComponent,
       ProfileInfoComponent
    ]
})

export class ProfileModule {}
