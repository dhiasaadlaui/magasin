package com.magasin.entities;

public final class Fruit extends Aliment {

	private String saison ;
	
	public Fruit() {
		// TODO Auto-generated constructor stub
	}

	
	
	public Fruit(int id, String libelle, double prixUnitaire, int quantite, String fournisseur,String saison) {
		this(libelle, prixUnitaire, quantite, fournisseur,saison);
		this.id = id;
		// TODO Auto-generated constructor stub
	}


	public Fruit(String libelle, double prixUnitaire, int quantite, String fournisseur, String saison) {
		super(libelle, prixUnitaire, quantite, fournisseur);
		this.saison = saison;
		// TODO Auto-generated constructor stub
	}



	public String getSaison() {
		return saison;
	}

	public void setSaison(String saison) {
		this.saison = saison;
	}
	
	

}
