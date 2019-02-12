package com.magasin.entities;

public class Article {

	protected int id;
	protected String libelle;
	protected double prixUnitaire;
	protected int quantite ;
	protected String fournisseur;
	
	
	public Article() {
		// TODO Auto-generated constructor stub
	}
	
	public Article(String libelle, double prixUnitaire, int quantite, String fournisseur) {
		
		this.libelle = libelle;
		this.prixUnitaire = prixUnitaire;
		this.quantite = quantite;
		this.fournisseur = fournisseur;
	}

	public Article(int id, String libelle, double prixUnitaire, int quantite, String fournisseur) {
		this(libelle,prixUnitaire,quantite,fournisseur);
		this.id = id;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public double getPrixUnitaire() {
		return prixUnitaire;
	}


	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}


	public int getQuantite() {
		return quantite;
	}


	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}


	public String getFournisseur() {
		return fournisseur;
	}


	public void setFournisseur(String fournisseur) {
		this.fournisseur = fournisseur;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id + getClass().getSimpleName().hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", libelle=" + libelle + ", prixUnitaire=" + prixUnitaire + ", quantite="
				+ quantite + ", fournisseur=" + fournisseur + "]";
	}
	
	
	

}
