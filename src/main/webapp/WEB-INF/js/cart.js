var Cart;

function Cart(wsLink, color){
	
	if(color == undefined) {
		this.color = "orange";
	} else {
		this.color = color;
	}
	
	this.wsLink = wsLink;
	
	this.addArticle = function(reference, nom, lien, prixUnite, quantite) {
		// TODO
	}
	
	this.removeArticle = function(reference) {
		// TODO
	}
	
	
	this.initialization = function(){
		// CRÉATION DE L'ARBRE DOM
		var cartDom = document.getElementById("cart");
		var cartButton = document.createElement("div");
		var cartIcon = document.createElement("i");
		var articlesQuantity = document.createElement("span");
		var buttonText = document.createElement("span");
		
		cartButton.id = "cart-button";
		
		cartIcon.className = "fas fa-shopping-cart";
		cartIcon.id = "cart-icon";
		cartButton.appendChild(cartIcon);
		
		articlesQuantity.id = "articles-quantity";
		articlesQuantity.className = "badge";
		articlesQuantity.innerText = "0";
		cartButton.appendChild(articlesQuantity);		
		
		buttonText.id = "button-text";
		buttonText.innerText = "Votre panier";
		
		cartButton.appendChild(buttonText);
		
		// AJOUT D'ÉVÈNEMENTS
		cartButton.addEventListener("click", function(){
			alert()
		})
		
		// STYLE DU BOUTON
		var cssText = `
			#cart-button {
                border: 1px solid #DDD;
                padding: 15px;
                border-radius: 30px;
                width: 165px;
                box-shadow: 1px 1px #EEE;
                transition: 0.3s;
                color: orange;
            }

            #cart-button:hover {
                cursor: pointer;
                background-color: #F9F9F9;
                transition: 0.3s;
            }

            #button-text {
                color: orange;
            }

            #articles-quantity {
                background-color: orange;
                color: white;
                font-weight: bold;
                border-radius: 50px;
                position: absolute;
                top: 8px;
                left: 27px;
            }

            #button-text {
                margin-left: 10px;
            }
            `
            
            cssText = cssText.replace(new RegExp("orange", "g"), this.color)
            
            var style = document.createElement('style');

			if (style.styleSheet) {
				style.styleSheet.cssText = cssText;
			} else {
				style.appendChild(document.createTextNode(cssText));
			}

			document.getElementsByTagName('head')[0].appendChild(style);
			
			// AFFICHAGE DU BOUTON
			cartDom.appendChild(cartButton);
	}.bind(this)
	
	/**
	 * On charge le module
	 */
	window.addEventListener("load", this.initialization);
	
}
