import { Component } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/Rx';

@Component({
    selector: 'navigation',
    templateUrl: require('./navigation.html'),
    styleUrls: [require('./navigation.css')]
})

export class NavigationComponent {
    private logo = require("./assets/brand.png");

    constructor() {};
}