<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Cart</title>
    <link rel="stylesheet" href="resources/css/style.css" />
</head>
<body>
    <h1>Cart</h1>

    <c:if test="${emptyCart}">
        <p><strong style="color: red;"> Votre panier est vide</strong></p>
    </c:if>

    <%@ include file="parts/tableCart.jsp" %>
</body>
</html>
