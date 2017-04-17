import { Routes, RouterModule } from '@angular/router'

import { SignUpComponent } from './component/sign-up.component'
import { SignUpUserComponent } from './user/user.component'
import { SignUpEmployerComponent } from './employer/employer.component'

export const signUpRoutes : Routes = [
    {
        path: "",
        component : SignUpComponent,
        children : [
            {
                //TODO: Check
                path: '',
                redirectTo: 'settings',
                pathMatch: 'full'
            },
            {
                path: 'user',
                component: SignUpUserComponent
            },
            {
                path: 'employer',
                component: SignUpEmployerComponent
            }
        ]
    }
];

export const signUpRouting = RouterModule.forChild(signUpRoutes);
