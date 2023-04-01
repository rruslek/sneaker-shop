const addToCart = (counter) => {
    if (counter.innerHTML == "") counter.innerHTML = 1
    else counter.innerHTML = parseInt(counter.innerHTML) + 1
}  

const items = document.getElementsByClassName("buy");
const counter = document.querySelector("#counter");

for (let i=0;i<items.length;i++){

    items[i].onclick = function(){addToCart(counter)};
}