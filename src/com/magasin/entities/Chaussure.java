package com.magasin.entities;

public final class Chaussure extends Vetement {

	private int pointure;

	public Chaussure(int id, String libelle, double prixUnitaire, int quantite, String fournisseur, String couleur,
			String marque, String genre, int pointure) {
		this(libelle, prixUnitaire, quantite, fournisseur, couleur, marque, genre, pointure);
		// TODO Auto-generated constructor stub
		this.id = id;

	}

	public Chaussure(String libelle, double prixUnitaire, int quantite, String fournisseur, String couleur,
			String marque, String genre, int pointure) {
		super(libelle, prixUnitaire, quantite, fournisseur, couleur, marque, genre);
		// TODO Auto-generated constructor stub
		this.pointure = pointure;
	}

	public Chaussure() {
		// TODO Auto-generated constructor stub
	}

	public int getPointure() {
		return pointure;
	}

	public void setPointure(int pointure) {
		this.pointure = pointure;
	}

}
