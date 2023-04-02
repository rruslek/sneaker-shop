const addToCart = (id) => {
    const counter = document.querySelector("#counter");
    const url = "http://localhost:8080/cart/add/" + id;
    $.ajax({
        type: "POST",
        url: url
    }).done(function(response) {
        counter.innerHTML = response
        location.reload();
    }).fail(function() {
        counter.innerHTML = "0"
    });
}

const deleteFromCart = (id) => {
    const counter = document.querySelector("#counter");
    const url = "http://localhost:8080/cart/add/" + id;
    $.ajax({
        type: "DELETE",
        url: url
    }).done(function(response) {
        counter.innerHTML = response
        location.reload();
    }).fail(function() {
        counter.innerHTML = "0"
    });
}

const createOrder = () => {
    const city = document.getElementById("city")
    const url = "http://localhost:8080/order/Пермь";
    $.ajax({
        type: "POST",
        url: url
    }).done(function(response) {
        location.reload();
    }).fail(function() {
    });
}

const items = document.getElementsByClassName("buy");

for (let i=0;i<items.length;i++){
    items[i].onclick = function(){addToCart(items[i].id)};
}