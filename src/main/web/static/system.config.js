var angularVersion = '4.0.0';
var routerVersion = '4.0.0';
var rxJsVersion = '5.0.0-beta.12';
var zoneVersion = '0.6.25';
var reflectMetadataVersion = '0.1.3';

System.config({
    baseUrl: '/',
    paths: {
        'unpkg:*': 'https://unpkg.com/*'
    }
});

System.config({
    transpiler: 'typescript',
    typescriptOptions: { 
        emitDecoratorMetadata: true 
    },

    meta: {
        '*': {
            deps: [ 'zone.js', 'reflect-metadata' ]
        }
    }
});

System.config({
    packageConfigPaths: [
        "unpkg:@*/*/package.json"
    ],

    map: {
        app : "/app", // static/app
        '@angular/core': 'unpkg:@angular/core@' + angularVersion,
        '@angular/router': 'unpkg:@angular/router@' + routerVersion,
        '@angular/compiler': 'unpkg:@angular/compiler@' + angularVersion,
        '@angular/forms': 'unpkg:@angular/forms@' + angularVersion,
        '@angular/common': 'unpkg:@angular/common@' + angularVersion,
        '@angular/platform-browser': 'unpkg:@angular/platform-browser@' + angularVersion,
        '@angular/http': 'unpkg:@angular/http@' + angularVersion,
        '@angular/platform-browser-dynamic': 'unpkg:@angular/platform-browser-dynamic@' + angularVersion,
        'rxjs': 'unpkg:rxjs@' + rxJsVersion,
        'zone.js': 'unpkg:zone.js@' + zoneVersion,
        'reflect-metadata': 'unpkg:reflect-metadata@' + reflectMetadataVersion,
        "crypto": "@empty"
    },

    packages: {
        'app': {
            defaultExtension: 'ts',
            main: 'main.ts'
        }
    }
});