const outerDiv = document.getElementById("outer");
const btn = document.getElementById("btn");

var cars = [
    { id: 1, year: 1997, make: 'Ford', model: 'E350', price: 3000 },
    { id: 2, year: 1999, make: 'Chevy', model: 'Venture', price: 4900 },
    { id: 3, year: 2000, make: 'Chevy', model: 'Venture', price: 5000 },
    { id: 4, year: 1996, make: 'Jeep', model: 'Grand Cherokee', price: 4799 },
    { id: 5, year: 2005, make: 'Volvo', model: 'V70', price: 44799 }
  ];

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



var carList; 
var newCars = cars;

function updateCarList(){
    var carList = "<tr><th>ID</th><th>Year</th><th>Make</th><th>Model</th><th>Price</th></tr>";
    newCars.forEach(el => {
        let car = `<tr><td>${el.id}</td><td>${el.year}</td><td>${el.make}</td><td>${el.model}</td><td>${el.price}</td><tr/>`;
        carList = carList.concat(car);
    });
    document.getElementById("cars").innerHTML = carList;
}

updateCarList();

var filterPrice = document.getElementById("filter");
filterPrice.onclick = (el) => {
    
    el.preventDefault();
    console.log(document.getElementById("price").value);
    newCars = cars.filter(car => car.price < document.getElementById("price").value);
    updateCarList();
}

//btn.onclick = document.getElementById("para").innerHTML = target;


