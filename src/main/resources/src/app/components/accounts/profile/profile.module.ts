import { ProfileInfoComponent } from './inner/information/profile-information.component';
import { ProfileComponent } from './profile.component';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { profileRoutes, profileRouting } from './profile.routing';

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
