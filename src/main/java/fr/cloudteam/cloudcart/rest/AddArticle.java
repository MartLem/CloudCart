package fr.cloudteam.cloudcart.rest;

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

	private static final String PANIER_SESSION_BEAN = "panier"; 
	
	/**
	 * Ajoute un article au panier du client
	 * @param a L'article à ajouter
	 * @return L'état du panier actuel
	 */
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Map<Article, Integer> addArticle(Article a) {
		PanierBean panierBean = (PanierBean)request.getSession().getAttribute(PANIER_SESSION_BEAN);
		
		
		if(panierBean == null) {
			panierBean = new PanierBean();
			panierBean.setCookieClient(request.getSession().getId());
			request.getSession().setAttribute(PANIER_SESSION_BEAN, panierBean);
		}
		
		panierBean.addArticle(a);
		
		return panierBean.getArticles();
	}
}
