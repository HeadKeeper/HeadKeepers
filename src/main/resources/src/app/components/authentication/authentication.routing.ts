import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router'

import { AuthenticationComponent } from "./authentication.component";

import { signUpRoutes } from './inner/sign-up/sign-up.routing';
import { signInRoutes } from "./inner/sign-in/sign-in.routing";

export const authenticationRoutes : Routes = [
    {
        path: 'accounts',
        component: AuthenticationComponent,
        children: [
            {
                path: 'login',
                children: [...signInRoutes]
            },
            {
                path: 'registration',
                children: [...signUpRoutes]
            }
        ]
    }
];

export const authenticationRouting: ModuleWithProviders = RouterModule.forRoot(authenticationRoutes);
