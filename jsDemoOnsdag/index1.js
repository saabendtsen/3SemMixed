const outerDiv = document.getElementById("outer");
const btn = document.getElementById("btn");

outerDiv.onclick = (evt) => document.getElementById("para").innerHTML = evt.target.id;

function click(e){
    var target = e.target;
    console.log(target.id);
    document.getElementById("para").innerHTML = target;
}

const persons = ["Hej","Niller","Går det"];

function writeToP(){
    document.getElementById("list").innerHTML = persons.join("");
}

const formbtn = document.getElementById("submit")
formbtn.onclick = (el) => {
    el.preventDefault();
    persons.push(document.getElementById("inp").value)
    console.log(persons);
    writeToP();
}

document.getElementById("removeFirst").onclick = (el) =>{
    el.preventDefault();
    persons.shift();
    writeToP();
}

document.getElementById("removeLast").onclick = (el) =>{
    el.preventDefault();
    persons.pop();
    writeToP();
}



//btn.onclick = document.getElementById("para").innerHTML = target;


