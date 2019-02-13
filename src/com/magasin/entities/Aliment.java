package com.magasin.entities;

public class Aliment extends Article{

	
	public Aliment() {
		// TODO Auto-generated constructor stub
	}

	public Aliment(int id, String libelle, double prixUnitaire, int quantite, String fournisseur) {
		super(id, libelle, prixUnitaire, quantite, fournisseur);
		// TODO Auto-generated constructor stub
	}

	public Aliment(String libelle, double prixUnitaire, int quantite, String fournisseur) {
		super(libelle, prixUnitaire, quantite, fournisseur);
		// TODO Auto-generated constructor stub
	}

	
	
}
