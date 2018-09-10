package fr.cloudteam.cloudcart.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;

import fr.cloudteam.cloudcart.pojo.Article;

@Stateful
@StatefulTimeout(unit = TimeUnit.MINUTES, value = 30)
public class PanierBean {
	
	private long id;
	private String cookieClient;
	private long idMagasin;
	private Map<Article, Integer> articles  = new HashMap<>();
	
	/**
	 * Ajoute une certaine quantité d'un article au panier
	 * @param a Un article
	 * @param quantite La quantité à ajouter
	 */
	public void addMultipleArticles(Article a, int quantite) {
		if(this.articles.keySet().contains(a)) {
			this.articles.put(a, this.articles.get(a)+quantite);
		}
		else {
			this.articles.put(a, quantite);
		}
	}
	/**
	 * Supprime une certaine quantité d'un article au panier
	 * @param a L'article
	 * @param quantite La quantité à supprimer
	 */
	public void removeMultipleArticles(Article a, int quantite) {
		if(this.articles.containsKey(a)) {
			int nouvelleQuantite = this.articles.get(a) - quantite;
			
			if(nouvelleQuantite <= 0) {
				this.articles.remove(a);
			}
			else {
				this.articles.put(a, nouvelleQuantite);
			}
		}
	}
 	
	/**
	 * Ajoute un article au panier
	 * @param a Un article
	 */
	public void addArticle(Article a) {
		this.addMultipleArticles(a, 1);
	}
	
	/**
	 * Retire un article du panier
	 * @param a L'article à retirer
	 */
	public void removeArticle(Article a) {
		this.removeMultipleArticles(a, 1);
	}
	
	
	/* Getters et Setters */
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getCookieClient() {
		return cookieClient;
	}
	
	public void setCookieClient(String cookieClient) {
		this.cookieClient = cookieClient;
	}
	
	public long getIdMagasin() {
		return idMagasin;
	}
	
	public void setIdMagasin(long idMagasin) {
		this.idMagasin = idMagasin;
	}
	
	public Map<Article, Integer> getArticles() {
		return articles;
	}
	
	public void setArticles(Map<Article, Integer> articles) {
		this.articles = articles;
	}
	
	
}
