var submitelement = document.getElementById("submit");
submitelement.addEventListener("click",Clickconvert);
function Clickconvert() {
    let Amount = parseInt(document.getElementById("IN").value);
    let From = document.getElementById("FR").value;
    let To = document.getElementById("T").value;
    let convert

    if(From == "VNĐ"){
        if(To == "VNĐ"){
            convert = Amount;
        }else if (To == "CNY"){
            convert = Amount/3592;
        }else if (To == "USD"){
            convert = Amount/23000;
        }
    }
    if(From == "CNY"){
        if(To == "VNĐ"){
            convert = Amount*3592;
        }else if (To == "CNY"){
            convert = Amount;
        }else if (To == "USD"){
            convert = Amount*0.16;
        }
    }
    if(From == "USD"){
        if(To == "VNĐ"){
            convert = Amount*23000;
        }else if (To == "CNY"){
            convert = Amount;
        }else if (To == "USD"){
            convert = Amount;
        }
    }

    document.getElementById("result").innerHTML = "Result: "+convert+" "+To;
}