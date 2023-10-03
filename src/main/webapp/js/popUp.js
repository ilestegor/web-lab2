let closeBtn = document.querySelector(".close-btn");
let popUpContainer = document.querySelector(".error-popup");
let mainContainer = document.querySelector("main");
let errorText = document.querySelector(".error-popup > p")
closeBtn.addEventListener('click', closePopUp);

function popUp(message){
    popUpContainer.classList.remove("close");
    popUpContainer.classList.add("open");
    mainContainer.classList.add("opacity-bg");
    errorText.innerHTML = message;
}

function closePopUp(e){
    e.preventDefault();
    popUpContainer.classList.add("close");
    mainContainer.classList.remove("opacity-bg");
    elt.addEventListener('click', handleGraphClick)
}