import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HelpComponent } from "../components/main/help/help.component";
import { WelcomeComponent } from "../components/main/welcome/welcome.component";
import { DocumentsComponent } from "../components/main/documents/documents.component";
import { PathNotFoundComponent } from "../components/errors/not-found/not-found.component";

const routes : Routes = [
    {
        path: '',
        pathMatch: 'full',
        redirectTo: '/welcome'
    },
    {
        path: 'welcome',
        component: WelcomeComponent
    },
    {
        path: 'help',
        component: HelpComponent
    },
    {
        path: 'documents',
        component: DocumentsComponent
    },
    { 
        path: '**', 
        pathMatch: 'full',
        component: PathNotFoundComponent 
    }
];

export const rootRouting: ModuleWithProviders = RouterModule.forRoot(routes);