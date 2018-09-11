<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Catalogue</title>

    <script src="resources/js/cart.js"></script>
    <script>var cart = new Cart("http://localhost:8080/")</script>
</head>
<body>
<div id="cart">
</div>

    <form action="http://localhost:8080/CloudCart/catalogue" method="post">
        <label>reference : </label><input type="text" name="reference" />
        <label>name : </label><input type="text" name="name" />
        <label>link : </label><input type="text" name="link" />
        <label>price : </label><input type="text" name="price" />

        <input type="submit" />
    </form>

</body>
</html>
