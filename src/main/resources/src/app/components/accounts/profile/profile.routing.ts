import { Routes, RouterModule } from '@angular/router'

import { ProfileComponent } from "./profile.component";
import { ProfileInfoComponent } from "./inner/information/profile-information.component";

export const profileRoutes : Routes = [
    {
        path: 'profile:id',
        component: ProfileComponent,
        children: [
            {
                path: 'information',
                component: ProfileInfoComponent
            }
        ]
    }
];

export const profileRouting = RouterModule.forRoot(profileRoutes);
