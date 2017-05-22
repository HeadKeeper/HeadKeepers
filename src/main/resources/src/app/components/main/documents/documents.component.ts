import 'rxjs/Rx';
import { Http } from '@angular/http';
import { Router } from "@angular/router";
import { Component } from '@angular/core';

import { UserService } from '../../../services/UserService';
import { HTTPService } from '../../../services/HTTPService';

@Component({
    selector: 'documents',
    templateUrl: 'src/app/components/main/documents/documents.component.html',
    styleUrls: [
        'src/app/assets/panel.css',
        'src/app/assets/form.css',
        'src/app/assets/grid.css'
    ]
})

export class DocumentsComponent {
    
    private company: string;
    private resume: string;
    private salary: string;
    private user: string;
    private vacancy: string;

    constructor(
        private httpService: HTTPService
    ) { };

   
}