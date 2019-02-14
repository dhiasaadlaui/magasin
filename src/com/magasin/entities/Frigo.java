package com.magasin.entities;

public final class Frigo extends Electronique {

	private int capacite ;
	
	
	
	public Frigo() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Frigo(int id, String libelle, double prixUnitaire, int quantite, String fournisseur,
			int ratingConsommation,int capacite) {
		this(libelle, prixUnitaire, quantite, fournisseur, ratingConsommation,capacite);
		this.id = id ;
		// TODO Auto-generated constructor stub
	}


	public Frigo(String libelle, double prixUnitaire, int quantite, String fournisseur, int ratingConsommation, int capacite) {
		super(libelle, prixUnitaire, quantite, fournisseur, ratingConsommation);
		this.capacite = capacite;
		// TODO Auto-generated constructor stub
	}


	public int getCapacite() {
		return capacite;
	}
	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}


	@Override
	public String toString() {
		return "Frigo [capacite=" + capacite + ", ratingConsommation=" + ratingConsommation + ", id=" + id
				+ ", libelle=" + libelle + ", prixUnitaire=" + prixUnitaire + ", quantite=" + quantite
				+ ", fournisseur=" + fournisseur + "]";
	}
	
	
	

}
