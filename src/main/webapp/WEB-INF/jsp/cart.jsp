<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="parts/header.jsp" %>

<h1>Cart</h1>

<c:if test="${emptyCart}">
    <p><strong style="color: red;"> Votre panier est vide</strong></p>
</c:if>

<%@ include file="parts/tableCart.jsp" %>

<a href="/CloudCart/payment">Confirmer</a>

<%@ include file="parts/footer.jsp" %>