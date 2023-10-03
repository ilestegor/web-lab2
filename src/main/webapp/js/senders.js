let form = document.getElementById("input-form");
const xhr = new XMLHttpRequest();

form.addEventListener("submit", (event) => {
    let xValue = getInput()[xIndex];
    let yValue = getInput()[yIndex].value.replace(",", ".");
    let rValue = getInput()[rIndex].value;
    if (validateInput(event)) {
        post_req(`http://localhost:8080/lab2-1.0-SNAPSHOT/controller`, event, `x=${xValue.value}&y=${yValue}&r=${rValue}&function=check`)
    }
})




function post_req(link, event, data){
    event.preventDefault();
    xhr.open('POST', link, true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send(data);

    xhr.onload = () => {
        if (xhr.readyState === 4){
            switch (xhr.status){
                case 307:
                    window.location.href = 'result.jsp';
                    break;
                case 400:
                    window.location.href = '400.jsp';
                    break;
                default:
                    window.location.href = "";


            }
        }
    }
}







