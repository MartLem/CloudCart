package fr.cloudteam.cloudcart.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import javax.ejb.EJB;

import org.junit.Test;

import fr.cloudteam.cloudcart.bean.PanierBean;
import fr.cloudteam.cloudcart.pojo.Article;


public class AddArticleTest {
	private PanierBean panierBean = new PanierBean();
	
	/**
	 * Vérifie les différentes contraintes concernant l'ajout
	 * et la suppression d'articles dans un panier
	 */
	@Test
	public void addAndRemoveArticleTest() {
		Article a1 = new Article("000", "nom", "lien", 3.0);
		Article a2 = new Article("005", "nom", "lien", 3.0);
		
		panierBean.addArticle(a1);
		panierBean.addArticle(a2);
		
		assertEquals(new Integer(1), panierBean.getArticles().get(a1));
		assertEquals(new Integer(1), panierBean.getArticles().get(a2));
		
		panierBean.addArticle(a1);
		panierBean.removeArticle(a2);
		
		assertEquals(new Integer(2), panierBean.getArticles().get(a1));
		assertNull(panierBean.getArticles().get(a2));
		
		panierBean.addMultipleArticles(a2, 42);
		panierBean.removeMultipleArticles(a1, 999);
		
		assertEquals(new Integer(42), panierBean.getArticles().get(a2));
		assertNull(panierBean.getArticles().get(a1));
	}
	
	
}

