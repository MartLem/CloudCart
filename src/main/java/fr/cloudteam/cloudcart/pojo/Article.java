package fr.cloudteam.cloudcart.pojo;

import javax.persistence.Entity;

@Entity
public class Article {
	private String reference;
	private String nom;
	private String lien;
	private double prixUnite;
	
	public Article() {
		
	}
	
	public Article(String reference, String nom, String lien, int quantite, double prixUnite) {
		this.reference = reference;
		this.nom = nom;
		this.lien = lien;
		this.prixUnite = prixUnite;
	}
	
	public String getReference() {
		return reference;
	}
	
	public void setReference(String reference) {
		this.reference = reference;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getLien() {
		return lien;
	}
	
	public void setLien(String lien) {
		this.lien = lien;
	}
	
	public double getPrixUnite() {
		return prixUnite;
	}
	
	public void setPrixUnite(double prixUnite) {
		this.prixUnite = prixUnite;
	}
	
	@Override
	public int hashCode() {
		return this.reference.hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Article) {
			Article a = (Article) o;
			return this.reference.equals(a.getReference());
		}
		return false;
	}
	
	@Override
	public String toString() {
		return String.format("[%s] %s", this.reference, this.nom);
	}
	
	
}
