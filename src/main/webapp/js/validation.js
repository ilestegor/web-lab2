document.querySelector(".reset-btn").addEventListener('click', (event) => {
    resetInput();
    post_req(`http://localhost:8080/lab2-1.0-SNAPSHOT/controller`, event, `function=clear`)
});

const xIndex = 0;
const yIndex = 1;
const rIndex = 2;


//return all values from user
function getInput(){
    let x = document.querySelector("input[type=radio]:checked");
    let y = document.getElementById("y-input");
    let r = document.getElementById("r-input");
    return [x, y, r];
}
function getErrorTextField(){
    let xError = document.getElementById("x-error-field");
    let yError = document.getElementById("y-error-field");
    let rError = document.getElementById("r-error-field");
    return [xError, yError, rError];
}

function validateInput(event){
    event.preventDefault();
    //receiving data from user
    let x = getInput()[xIndex];
    let y = getInput()[yIndex].value.trim().replace(",", ".");
    let r = getInput()[rIndex].value.trim().replace(",", ".");

    //get elements for error text
    let xError = getErrorTextField()[xIndex];
    let yError = getErrorTextField()[yIndex];
    let rError = getErrorTextField()[rIndex];

    //get input fields to give them error styles
    let xField = document.querySelectorAll(".custom-x-button");
    let yField = getInput()[yIndex];
    let rField = getInput()[rIndex];

    let xFlag = false;
    let yFlag = validateAndSetValidationText(checkY, y, yError, yField, "", "Введите число от -5...5", "Введите число");
    let rFlag = validateAndSetValidationText(checkR, r, rError, rField, "", "Введите число от 2...5", "Введите число");

    if (checkX(x)){
        setMultipleSuccess(xError, xField, "");
        xFlag = true;
    } else {
        setMultipleError(xError, xField, "Выберите одно из значений")
        xFlag = false;
    }
    return xFlag && yFlag && rFlag;
}

//validates if number and if in right area, first param is function for area check, second is value that will
//be checked, third is field for error text, fourth is for adding error styling, three left are messages to user
//(1 - success, 2 - not in right area, 3 - not a number)
function validateAndSetValidationText(f, value, elem, field, msg1, msg2, msg3){
    let flag = false;
    if (!isNumber(value)){
        setSingleError(elem, field, msg3);
        flag = false;
    } else if (f(value)){
        setSingleSuccess(elem, field, msg1);
        flag = true;
    } else {
        setSingleError(elem, field, msg2);
        flag = false;
    }
    return flag;
}


//function for resetting input;
function resetInput(event){


    let form  = document.getElementById("input-form");

    let xError = getErrorTextField()[xIndex];
    let yError = getErrorTextField()[yIndex];
    let rError = getErrorTextField()[rIndex];

    //get input fields to give them error styles
    let xField = document.querySelectorAll(".custom-x-button");
    let yField = getInput()[yIndex];
    let rField = getInput()[rIndex];

    form.reset();
    setSingleSuccess(yError, yField, "");
    setSingleSuccess(rError, rField, "");
    setMultipleSuccess(xError, xField, "");

    calculator.setState(initState);
}


//function for setting error styles and error text
function setMultipleError(elem1, elem2, message){
    elem1.innerText = message;
    for (let i = 0; i < elem2.length; i++) {
        elem2[i].classList.add("x-error-buttons");
    }
}
function setSingleError(elem1, elem2, message){
    elem1.innerText = message;
    elem2.classList.add("error-input");
}
function setMultipleSuccess(elem1, elem2, message){
    elem1.innerText = message;
    for (let i = 0; i < elem2.length; i++) {
        elem2[i].classList.remove("x-error-buttons");
    }
}
function setSingleSuccess(elem1, elem2, message){
    elem1.innerText = message;
    elem2.classList.remove("error-input");
}


//helper functions for main validation function
function isNumber(value) {
    return value != null && value !== "" && !isNaN(Number(value));
}

function checkX(value){
    return value !== null;
}
function checkY(value){
    return value >= -5 && value <= 5;
}
function checkR(value){
    return value >= 2 && value <= 5;
}




