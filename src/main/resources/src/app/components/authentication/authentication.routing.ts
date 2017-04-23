import { signUpRoutes } from './inner/sign-up/sign-up.routing';
import { SignUpComponent } from './inner/sign-up/sign-up.component';
import { Routes, RouterModule } from '@angular/router'

import { SignInComponent } from "./inner/sign-in/sign-in.component";
import { AuthenticationComponent } from "./authentication.component";

export const accountRoutes : Routes = [
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

export const accountRouting = RouterModule.forRoot(accountRoutes);
