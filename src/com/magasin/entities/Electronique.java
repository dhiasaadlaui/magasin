package com.magasin.entities;

public class Electronique extends Article {

	protected int ratingConsommation;
	
	
	public Electronique(int id, String libelle, double prixUnitaire, int quantite, String fournisseur,
			int ratingConsommation) {
	this(libelle, prixUnitaire, quantite, fournisseur, ratingConsommation);
		this.id=id;
	
		// TODO Auto-generated constructor stub
	}


	public Electronique(String libelle, double prixUnitaire, int quantite, String fournisseur,int ratingConsommation) {
		super(libelle, prixUnitaire, quantite, fournisseur);
		// TODO Auto-generated constructor stub
		this.ratingConsommation=ratingConsommation;
	}


	public Electronique() {
		// TODO Auto-generated constructor stub
	}


	public int getRatingConsommation() {
		return ratingConsommation;
	}


	public void setRatingConsommation(int ratingConsommation) {
		this.ratingConsommation = ratingConsommation;
	}

}
