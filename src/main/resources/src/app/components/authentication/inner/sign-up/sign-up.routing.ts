import { ModuleWithProviders } from '@angular/core/core';
import { Routes, RouterModule } from '@angular/router'

import { SignUpComponent } from './sign-up.component'
import { SignUpUserComponent } from './inner/user/user.component'
import { SignUpCompanyComponent } from './inner/employer/employer.component'

export const signUpRoutes : Routes = [
    {
        path: "",
        component: SignUpComponent,
        children: [
            {
                path: 'user',
                component: SignUpUserComponent
            },
            {
                path: 'company',
                component: SignUpCompanyComponent
            }
        ]
    }
];

export const SignUpRouting: ModuleWithProviders = RouterModule.forRoot(signUpRoutes);