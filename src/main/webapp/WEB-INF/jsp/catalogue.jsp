<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Catalogue</title>
	<link rel="stylesheet" href="resources/css/style.css" />
    <script src="resources/js/cart.js"></script>
    <script>var cart = new Cart("http://localhost:8080/", "#434343")</script>
</head>
<body>
	<div id="cart"></div>
	
	<header>
		<div id="headerLeft">
			<img class="logo" src="http://pigment.github.io/fake-logos/logos/large/color/crofts-accountants.png"/>
			<span id="companyName">Company Name</span>
		</div>
	</header>
	
	<div id="catalogue">
		<div class="product">
			<h1>Bavoir anti-tâches</h1>
			<img class="preview" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQyzx2a9j_wA5p-Rrc0CdyufdPNVRW7h5cakZnr2lNB9CRDYBQ-" alt="" />
			<p class="description">
				Quam ob rem circumspecta cautela observatum est deinceps et cum edita montium petere coeperint grassatores, loci iniquitati milites cedunt. ubi autem in planitie potuerint reperiri, quod contingit adsidue, nec exsertare lacertos nec crispare permissi tela, quae vehunt bina vel terna, pecudum ritu inertium trucidantur.
			</p>
			<button class="addToCart" onClick="cart.addArticle('28555421', 'Bavoir anti-tâches de nouilles', 'http://google.com', 19.99)"><i class="fas fa-plus"></i> Add to cart</button>		
		</div>
		<div class="product">
			<h1>Lazy Rubik's Cube</h1>
			<img class="preview" src="http://img.funnytab.net/gallery/products/Lazy_Rubiks_Cube.jpg" alt="" />
			<p class="description">
				Quam ob rem circumspecta cautela observatum est deinceps et cum edita montium petere coeperint grassatores, loci iniquitati milites cedunt. ubi autem in planitie potuerint reperiri, quod contingit adsidue, nec exsertare lacertos nec crispare permissi tela, quae vehunt bina vel terna, pecudum ritu inertium trucidantur.
			</p>
			<button class="addToCart" onClick="cart.addArticle('21145698', 'Lazy Rubik\'s Cube', 'http://google.com', 27.99)"><i class="fas fa-plus"></i> Add to cart</button>		
		</div>
		<div class="product">
			<h1>Pastèques carrées</h1>
			<img class="preview" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQJDjm8MsO03hi821lxN-TjRI0bLBn3AyKFfzZ8zLtCQNdVihqyFw" alt="" />
			<p class="description">
				Quam ob rem circumspecta cautela observatum est deinceps et cum edita montium petere coeperint grassatores, loci iniquitati milites cedunt. ubi autem in planitie potuerint reperiri, quod contingit adsidue, nec exsertare lacertos nec crispare permissi tela, quae vehunt bina vel terna, pecudum ritu inertium trucidantur.
			</p>
			<button class="addToCart" onClick="cart.addArticle('151124114', 'Pastèques carrées', 'http://google.com', 59.99)"><i class="fas fa-plus"></i> Add to cart</button>		
		</div>
	</div>
</body>
</html>
