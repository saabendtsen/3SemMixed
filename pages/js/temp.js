const myArr = ["one","two","three"];

for( let step = 0; step < myArr.length; step++){
    console.log(myArr[step]);
}

for (el of myArr){
    console.log(el)
}

myArr.forEach(function(el){
    console.log("forEach",el);
});

myArr.forEach(el=>console.log("Arrow notation", el));

//setTimeout(()=>console.log("SUT DUT"),2000);


const persons = [
    {name:"Henriette", age:54},
    {name: "Niller", age:34},
    {name: "Samual", age:5, title:"Chef"},
];

var newPersons = persons.filter(el=>el.age > 12).forEach(el=>console.log(el));
//console.log(newPersons);

persons.map(el=>{
     el.phone = 43
     return el;
    }).forEach(el=>console.log(el));

    const name = "Beate";
    const sentence = `${name} er 
    
    
    væk`;
    console.log(sentence);