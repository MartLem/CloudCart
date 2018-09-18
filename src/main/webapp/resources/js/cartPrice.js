var initialization = function() {
	updateTotalQuantity();
	
	var plusButtons = document.querySelectorAll(".quantityTable button.plus")
	var minusButtons = document.querySelectorAll(".quantityTable button.minus")
	
	plusButtons.forEach(function(element){
		element.addEventListener("click", incrementQuantity);
	})
	
	minusButtons.forEach(function(element){
		element.addEventListener("click", decreaseQuantity);
	})
	
	updateTotalPrice();
}

var incrementQuantity = function(event) {
	var target = event.target.parentNode.querySelector(".quantity")
	
	
	target.value = parseInt(target.value) + 1
	updateTotalQuantity();
	updateArticlePrice(target.parentNode.parentNode)
	updateTotalPrice();
	
}

var decreaseQuantity = function(event) {
	var target = event.target.parentNode.querySelector(".quantity")
	
	if(parseInt(target.value)-1 > 0) {
		target.value = parseInt(target.value) - 1
		updateTotalQuantity();
		updateArticlePrice(target.parentNode.parentNode)
		updateTotalPrice();
	}
}

var updateTotalQuantity = function() {
	var quantities = document.querySelectorAll(".quantityTable input.quantity");
	var totalQuantity = 0;
	var totalQuantityTd = document.getElementById("numberOfArticles");
	
	quantities.forEach(function(element) {
		totalQuantity += parseInt(element.value);
	})
	
	
	totalQuantityTd.innerText = totalQuantity;
}

var updateTotalPrice = function(){
	var allPrices = document.querySelectorAll(".totalPriceArticle")
	var total = 0
	
	allPrices.forEach(function(element) {
		total += parseFloat(element.innerText)
	})
	
	document.getElementById("totalPrice").innerText = total + "€"
}

var updateArticlePrice = function(target) {
	var price = parseFloat(target.querySelector(".prixUnite").innerText)
	var quantity = parseInt(target.querySelector(".quantity").value)
	var totalPrice = price * quantity
	
	target.querySelector(".totalPriceArticle").innerText = totalPrice + "€"
}

window.addEventListener("load", initialization);