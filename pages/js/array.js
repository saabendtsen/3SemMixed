var boys = ["Peter", "Lars", "Ole"];
var girls = ["Janne", "Hanne","Sanne"];


all = boys.concat(girls);
console.log(all);

console.log(all.join(", "));

all.unshift("Hanne ")

console.log(all.join(", "));

all.splice(4,1 ,"Fede svin");

console.log(all.join(", "));

all.sort()
console.log(all.join(", "));


function add(n1, n2){
    return n1 + n2;
}

var sub = function(n1,n2){
    return n1 -n2;
}

var cb = function(n1,n2, callback){
    try {
        return "Result from the two numbers: "+n1+" and "+n2+"="+callback(n1,n2)
    } catch (error) {
        
    }
    
}

console.log(add(1,2))

console.log(add);

console.log(add(1,2,3));