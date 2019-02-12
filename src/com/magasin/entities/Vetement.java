package com.magasin.entities;

public class Vetement extends Article {
	protected String couleur;
	protected String marque;
	protected String genre;

	
	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Vetement() {
	}

	public Vetement(int id, String libelle, double prixUnitaire, int quantite, String fournisseur, String couleur,
			String marque, String genre) {
		this(libelle, prixUnitaire, quantite, fournisseur, couleur, marque, genre);
		this.id = id;

	}

	public Vetement(String libelle, double prixUnitaire, int quantite, String fournisseur, String couleur,
			String marque, String genre) {
		super(libelle, prixUnitaire, quantite, fournisseur);
		// TODO Auto-generated constructor stub
		this.couleur = couleur;
		this.marque = marque;
		this.genre = genre;

	}

	@Override
	public String toString() {
		return "Vetement [couleur=" + couleur + ", marque=" + marque + ", genre=" + genre + ", id=" + id + ", libelle="
				+ libelle + ", prixUnitaire=" + prixUnitaire + ", quantite=" + quantite + ", fournisseur=" + fournisseur
				+ "]";
	}

}
