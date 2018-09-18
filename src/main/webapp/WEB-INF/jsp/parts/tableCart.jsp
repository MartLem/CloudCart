<table>
    <tr>
        <th>Article</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Total</th>
        <th></th>
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
            <td class="prixUnite">
                    ${article.prixUnite}&euro;
            </td> 
            <td class="quantityTable">
                <button class="plus" >+</button>
                <input class="quantity" type="text" value="${quantity}"/>
                <button class="minus">-</button>
            </td>
            <td class="totalPriceArticle">
                    ${ quantity * article.prixUnite }&euro;
            </td>
            <td>
            	<a href="/CloudCart/delete?ref=${ article.reference }"><i style="color: black" class="fas fa-trash-alt"></i></a>
            </td>
        </tr>

    </c:forEach>
    <tr>
        <td>Total</td>
        <td></td>
        <td id="numberOfArticles"></td>
        <td id="totalPrice"></td>
        <td></td>
    </tr>
</table>
