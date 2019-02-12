package com.magasin.entities;

public class Pull extends Vetement {

	protected String taille;
	protected String type;
	
	public Pull(
			
			int id, 
			String libelle, 
			double prixUnitaire, 
			int quantite, 
			String fournisseur, 
			String couleur,
			String marque, 
			String genre,
			String taille, 
			String type
			
			) {
		this(libelle, prixUnitaire, quantite, fournisseur, couleur, marque, genre,taille,type);
	
	}





	public Pull(String libelle, double prixUnitaire, int quantite, String fournisseur, String couleur, String marque,
			String genre, String taille, String type) {
		super(libelle, prixUnitaire, quantite, fournisseur, couleur, marque, genre);
		 this.taille= taille;
		 this.type = type;
		
		// TODO Auto-generated constructor stub
	}





	public Pull() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	

	public String getTaille() {
		return taille;
	}

	public void setTaille(String taille) {
		this.taille = taille;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	

}
