// happy coding 👻
console.log("hello world");
function fybonancci(x:number):number {
    if (x===1 || x===2) {
        return 1;
    } else {
        return fybonancci(x-1)+fybonancci(x-2);
    }
}
let sum:number = 0;
for (let i:number = 1; i<=10;i++){
    console.log(fybonancci(i)+"\n");
    sum+=fybonancci(i);
}
console.log("Tổng 10 số fybonancci đầu tiên là: "+sum);