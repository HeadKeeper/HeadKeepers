import { Component } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/Rx';

@Component({
    selector: 'navigation',
    templateUrl: 'src/app/components/navigation/navigation.html',
    styleUrls: ['src/app/components/navigation/navigation.css']
})

export class NavigationComponent {
    //This will work fine with WebPack: private logo = require("./assets/brand.png");

    constructor() {};
}