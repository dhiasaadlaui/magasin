package com.magasin.entities;

public final class Tv extends Electronique {
	
	private int resolution;
	
	
	
	
	public Tv(int id, String libelle, double prixUnitaire, int quantite, String fournisseur, int ratingConsommation,
			int resolution) {
		this(libelle, prixUnitaire, quantite, fournisseur, ratingConsommation,resolution);
		// TODO Auto-generated constructor stub
		this.id = id;
	}


	public Tv(String libelle, double prixUnitaire, int quantite, String fournisseur, int ratingConsommation
			,int resolution) {
		super(libelle, prixUnitaire, quantite, fournisseur, ratingConsommation);
		// TODO Auto-generated constructor stub
		this.resolution = resolution;
	}


	public Tv() {
		// TODO Auto-generated constructor stub
	}


	public int getResolution() {
		return resolution;
	}


	public void setResolution(int resolution) {
		this.resolution = resolution;
	}


	@Override
	public String toString() {
		return "Tv [resolution=" + resolution + ", ratingConsommation=" + ratingConsommation + ", id=" + id
				+ ", libelle=" + libelle + ", prixUnitaire=" + prixUnitaire + ", quantite=" + quantite
				+ ", fournisseur=" + fournisseur + "]";
	}

	
	
}
