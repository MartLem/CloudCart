<table>
    <tr>
        <th>Article</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Total</th>
    </tr>

    <c:set var="totalPrice" value="${0}"/>
    <c:set var="totalArticle" value="${0}"/>

    <c:forEach items="${sessionScope.panier.articles}" var="entry">

        <c:set var="article" value="${entry.key}"/>
        <c:set var="quantity" value="${entry.value}"/>

        <tr>
            <td>
                <a href="${article.lien}">${article.nom}</a>
            </td>
            <td>
                    ${article.prixUnite}
            </td>
            <td class="quantityTable">
                <button class="plus">+</button>
                <input class="quantity" type="text" value="${quantity}"/>
                <button class="minus">-</button>
            </td>
            <td>
                    ${ quantity * article.prixUnite }
            </td>
        </tr>

    </c:forEach>
    <tr>
        <td>Total</td>
        <td></td>
        <td>${ pageScope.totalArticle }</td>
        <td>${ pageScope.totalPrice }</td>
    </tr>
</table>
