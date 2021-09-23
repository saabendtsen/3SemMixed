
const divs = document.getElementsByTagName("div");

const btn = document.getElementById("btn");

function changeColor(){

divs[0].style.backgroundColor = "red";
divs[1].style.backgroundColor = "green";
divs[2].style.backgroundColor = "blue";

}

fetch("https://api.chucknorris.io/jokes/random").then((el)=> el.json().then((data)=>{
    document.getElementById("div1").innerHTML = data.value;
}))

btn.onclick = changeColor;