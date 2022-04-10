// Máy tính nâng cấp
function count(co) {
    let so1 = parseInt(document.getElementById("1").value);
    let so2 = parseInt(document.getElementById("2").value);
    switch(co) {
        case '+':
            document.getElementById("result").innerHTML = "Result Addition: "+ (so1 + so2);
            break;
        case '-':
            document.getElementById("result").innerHTML = "Result Subtraction: "+ (so1 - so2);
            break;
        case 'x':
            document.getElementById("result").innerHTML = "Result Addition: "+ (so1 * so2);
            break;
        case '/':
            document.getElementById("result").innerHTML = "Result Addition: "+ (so1 / so2);
            break;
    }
}