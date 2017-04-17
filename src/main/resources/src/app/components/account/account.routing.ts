import { Routes, RouterModule } from '@angular/router'

import { SignInComponent } from "./sign-in/sign-in";

import { signUpRoutes } from "./sign-up/sign-up.routing";
import { informationRoutes } from "./information/information.routing";

export const accountRoutes : Routes = [
    {
        path: "",
        children : [
            {
                path: '',
                redirectTo: 'settings',
                pathMatch: 'full'
            },
            {
                path: 'information/:id',
                children: [...informationRoutes]
            },
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

export const accountRouting = RouterModule.forChild(accountRoutes);
