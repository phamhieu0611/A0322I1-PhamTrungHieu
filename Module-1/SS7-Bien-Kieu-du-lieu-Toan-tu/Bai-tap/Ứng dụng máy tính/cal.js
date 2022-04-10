// Máy tính cơ bản
let so1;
let so2;

function AddFunction() {

    so1 = parseInt(document.getElementById("a").value);
    so2 = parseInt(document.getElementById("b").value);

    document.getElementById("result").innerHTML = "Result Addition: " +(so1 + so2);
}
function SubFunction() {

    document.getElementById("result").innerHTML = "Result Subtraction: "+ (so1 - so2);
}
function MulFunction() {

    document.getElementById("result").innerHTML = "Result Addition: "+ (so1 * so2);
}
function DivFunction() {

    document.getElementById("result").innerHTML = "Result Addition: "+ (so1 / so2);
}
