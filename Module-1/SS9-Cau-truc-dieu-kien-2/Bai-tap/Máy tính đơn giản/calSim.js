let prs = '';
let pus = '';
function so(value) {

     if (value == 'C'){
         document.getElementById('sho').value = pus;
     }else if(value == '='){

     }else {
         prs += value;
        document.getElementById('sho').value = prs;
     }
}