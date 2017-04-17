import { Routes, RouterModule } from '@angular/router'

import { UserInfoComponent } from "./user/user";
import { EmployerInfoComponent } from "./employer/employer";

export const informationRoutes : Routes = [
    {
        path: "",
        children : [
            {
                path: 'user/:id',
                component: UserInfoComponent
            },
            {
                path: 'employer/:id',
                component: EmployerInfoComponent
            }
        ]
    }
];

export const informationRouting = RouterModule.forChild(informationRoutes);
