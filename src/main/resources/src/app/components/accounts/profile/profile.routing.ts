import { ModuleWithProviders } from '@angular/core/core';
import { Routes, RouterModule } from '@angular/router'

import { ProfileComponent } from "./profile.component";
import { ProfileInfoComponent } from "./inner/information/profile-information.component";

export const profileRoutes : Routes = [
    {
        path: 'profile',
        component: ProfileComponent,
        children: [
            {
                path: ':id',
                component: ProfileInfoComponent
            },
            {
                path: ':id/edit',
                component: ProfileInfoComponent
            }
        ]
    }
];

export const profileRouting: ModuleWithProviders = RouterModule.forRoot(profileRoutes);
