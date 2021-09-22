
const divs = document.getElementsByTagName("div");

const btn = document.getElementById("btn");

function changeColor(){

divs[0].style.backgroundColor = "red";
divs[1].style.backgroundColor = "green";
divs[2].style.backgroundColor = "blue";

}

btn.onclick = changeColor;