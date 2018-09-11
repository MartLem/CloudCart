/**
 * Create a new cart
 * A cart is a collection of articles
 * @param wsLink The link of webservices which manage the cart
 * @param color The main color of the button. You can put a hex value or a plain text color (Ex. "orange" or "#5d875f") 
 * @returns A new cart object
 */
function Cart(wsLink, color){
	
	// If there's no color, we put "orange" as default value
	if(color == undefined) {
		this.color = "orange";
	} else {
		this.color = color;
	}
	
	this.wsLink = wsLink;
	
	/**
	 * Add an article to the cart and update the button 
	 */
	this.addArticle = function(reference, nom, lien, prixUnite, quantite) {
		const req = new XMLHttpRequest();

		req.onreadystatechange = function(event) {
			// XMLHttpRequest.DONE === 4
			if (this.readyState === XMLHttpRequest.DONE) {
				if (this.status === 200) {
					console.log("Réponse reçue: %s", this.responseText);
				} else {
					console.log("Status de la réponse: %d (%s)", this.status, this.statusText);
				}
			}
		};

		req.open('POST', this.wsLink + "CloudCart/panier", true);
		
		var body = new Object()
		body.reference = reference
		body.nom = nom;
		body.lien = lien
		body.prixUnite = prixUnite
		
		req.setRequestHeader("Content-Type", "application/json");
		req.send(JSON.stringify(body));
	}
	
	/**
	 * Remove one article from the cart
	 */
	this.removeArticle = function(reference) {
		// TODO
	}
	
	this.initializeStyle = function() {
		
		var bootstrap = document.createElement("link");
		var fontawesome = document.createElement("link");
		
		bootstrap.rel = "stylesheet";
		fontawesome.rel = "stylesheet";
		
		bootstrap.href = "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
		fontawesome.href = "https://use.fontawesome.com/releases/v5.3.1/css/all.css"
			
		
		document.querySelector("head").appendChild(fontawesome);
		document.querySelector("head").appendChild(bootstrap);
		
		
		// BUTTON STYLE
		var cssText = `
			#cart-button {
                border: 1px solid #DDD;
                padding: 15px;
                border-radius: 30px;
                display: inline-block;
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
	}
	
	/**
	 * Initialize the cart button
	 */
	this.initialization = function(){
		this.initializeStyle();
		
		// CREATION OF THE DOM TREE
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
		//buttonText.innerText = "Votre panier";
		
		cartButton.appendChild(buttonText);
		
		// EVENTS
		cartButton.addEventListener("click", function(){
			alert()
		})
			
		// BUTTON DISPLAY
		cartDom.appendChild(cartButton);
	}.bind(this)
	
	
	
	/**
	 * We load the module
	 */
	window.addEventListener("load", this.initialization);
	
}
