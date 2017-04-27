import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router'

import { SignInComponent } from "./inner/sign-in/sign-in.component";
import { AuthenticationComponent } from "./authentication.component";

import { signUpRoutes } from './inner/sign-up/sign-up.routing';

export const authenticationRoutes : Routes = [
    {
        path: 'account',
        component: AuthenticationComponent,
        children: [
            {
                path: 'login',
                component: SignInComponent
            },
            {
                path: 'registration',
                children: [...signUpRoutes]
            }
        ]
    }
];

export const authenticationRouting: ModuleWithProviders = RouterModule.forRoot(authenticationRoutes);
