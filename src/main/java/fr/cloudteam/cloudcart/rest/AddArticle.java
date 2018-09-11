package fr.cloudteam.cloudcart.rest;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import fr.cloudteam.cloudcart.bean.PanierBean;
import fr.cloudteam.cloudcart.pojo.Article;

@Path("panier")
public class AddArticle {
	
	@Context private HttpServletRequest request;

	public static final String CART_URL = "panier";
	
	/**
	 * Ajoute un article au panier du client
	 * @param a L'article à ajouter
	 * @return L'état du panier actuel
	 */
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Map<String, Integer> addArticle(Article a) {
		PanierBean panierBean = (PanierBean)request.getSession().getAttribute(CART_URL);
		
		
		if(panierBean == null) {
			panierBean = new PanierBean();
			panierBean.setCookieClient(request.getSession().getId());
			request.getSession().setAttribute(CART_URL, panierBean);
		}
		
		panierBean.addArticle(a);
		
		Map<String, Integer> response = new HashMap<>();

		response.put("articles", panierBean.getArticles().values().stream().mapToInt(Integer::intValue).sum());
		return response;
	}
}
