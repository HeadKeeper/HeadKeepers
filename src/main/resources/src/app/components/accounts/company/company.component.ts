import { Component, OnInit } from '@angular/core';

import { UserService } from '../../../services/UserService';

@Component({
    selector: 'company',
    templateUrl: 'src/app/components/accounts/company/company.component.html',
    styleUrls: [
        'src/app/assets/grid.css',
        'src/app/assets/panel.css'
    ]
})

export class CompanyComponent implements OnInit {
    constructor(
        private userService: UserService
    ) { }

    ngOnInit() { }
}