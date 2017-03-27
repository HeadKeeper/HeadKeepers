'use strict'

function sendDataToServer() {
    var FIRST_ELEMENT = 0;
    var resumeData = {
        firstName : document.getElementsByName("first-name")[FIRST_ELEMENT].value,
        lastName : document.getElementsByName("last-name")[FIRST_ELEMENT].value,
        middleName : document.getElementsByName("middle-name")[FIRST_ELEMENT].value,
        birthdayDate : document.getElementsByName("birthday-date")[FIRST_ELEMENT].value,
        address : document.getElementsByName("address")[FIRST_ELEMENT].value,
        martialStatus : document.getElementsByName("martial-status")[FIRST_ELEMENT].value,
        references : document.getElementsByName("references")[FIRST_ELEMENT].value,
        additionalInformation : document.getElementsByName("additional-information")[FIRST_ELEMENT].value
    }
    alert(JSON.stringify(resumeData));
}