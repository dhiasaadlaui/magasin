package com.magasin.entities;

public class LigneCommande {
	private Article article; 
	private int quantite;
	private double prixTotalArticle;
	private Commande commande;
	
	
	
	public LigneCommande(Article article,Commande commande, int quantite) {
		super();
		this.article = article;
		this.quantite = quantite;
		this.commande = commande;
		this.prixTotalArticle = article.getPrixUnitaire() * quantite;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
		this.prixTotalArticle = article.getPrixUnitaire() * quantite;
	}
	public Article getArticle() {
		return article;
	}
	public double getPrixTotalArticle() {
		return prixTotalArticle;
	}
	@Override
	public int hashCode() {
	return article.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LigneCommande other = (LigneCommande) obj;
		if (article == null) {
			if (other.article != null)
				return false;
		} else if (!article.equals(other.article))
			return false;
		return true;
	}
	
	
}
