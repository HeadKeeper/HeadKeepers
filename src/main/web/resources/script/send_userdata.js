'use strict'

function sendDataToServer(page) {
    var FIRST_ELEMENT = 0;
    var request = new XMLHttpRequest();
    var userData = {
        email : document.getElementsByName("userBase-email")[FIRST_ELEMENT].value,
        nickname : document.getElementsByName("userBase-nickname")[FIRST_ELEMENT].value,
        password : document.getElementsByName("userBase-password")[FIRST_ELEMENT].value
    };
    var xmlhttp = new XMLHttpRequest();   // new HttpRequest instance
    xmlhttp.open("POST", "/".concat(page));
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    alert(JSON.stringify(userData));
    xmlhttp.send(JSON.stringify(userData));
}