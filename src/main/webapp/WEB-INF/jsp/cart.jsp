<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Cart</title>
</head>
<body>
    <h1>Cart</h1>

    <table>
        <tr><th>Article</th><th>Price</th><th>Number</th></tr>

        <c:forEach items="${sessionScope.panier.articles}" var="entry">
            <c:set var="article" value="${entry.key}"/>
            <c:set var="quantity" value="${entry.value}"/>

            <tr>
                <td><a href="${article.lien}">${article.nom}</a></td><td>${article.prixUnite}</td><td>${quantity}</td>
            </tr>

        </c:forEach>

    </table>
</body>
</html>
