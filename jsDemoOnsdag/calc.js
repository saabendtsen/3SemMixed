const container = document.getElementById("buttons");
const display = document.getElementById("display");
const calc = document.getElementById("calculate");

var numbers = [];

container.onclick = (evt) =>{
    numbers.push(evt.target.innerHTML)
     display.innerHTML = numbers.join("")
    };

calc.onclick = (evt) => {
    evt.stopPropagation();
    checkSymbol();
}

function checkSymbol(){
    let index;
    let stringNr = numbers.join("");
    let res;
    let first;
    let sekund;
    if(numbers.indexOf("+")){
        stringNr = stringNr.split("+");
        res = parseInt(stringNr[0]) + parseInt(stringNr[1]);
        display.innerHTML = res;
        numbers = [];    
    }else if(numbers.indexOf("-")){
        stringNr = stringNr.split("-");
        res = parseInt(stringNr[0]) + parseInt(stringNr[1]);
        display.innerHTML = res;
        numbers = [];    
    }else if(numbers.indexOf("*")){
        stringNr = stringNr.split("*");
        res = parseInt(stringNr[0]) + parseInt(stringNr[1]);
        display.innerHTML = res;
        numbers = [];    
    }else if(numbers.indexOf("/")){
        stringNr = stringNr.split("/");
        res = parseInt(stringNr[0]) + parseInt(stringNr[1]);
        display.innerHTML = res;
        numbers = [];    
    }
}