package com.magasin.entities;

import java.util.Date;

public final class Laitier extends Aliment {
	private Date dateFab;
	private Date dateExp;

	public Laitier() {
		// TODO Auto-generated constructor stub
	}

	public Laitier(int id, String libelle, double prixUnitaire, int quantite, String fournisseur, Date dateExp,
			Date dateFab) {
		this(libelle, prixUnitaire, quantite, fournisseur, dateExp, dateFab);
		this.id = id;
		// TODO Auto-generated constructor stub
	}

	public Laitier(String libelle, double prixUnitaire, int quantite, String fournisseur, Date dateExp, Date dateFab) {
		super(libelle, prixUnitaire, quantite, fournisseur);
		this.dateExp = dateExp;
		this.dateFab = dateFab;
		// TODO Auto-generated constructor stub
	}

	public Date getDateExp() {
		return dateExp;
	}

	public void setDateExp(Date dateExp) {
		this.dateExp = dateExp;
	}

	public Date getDateFab() {
		return dateFab;
	}

	public void setDateFab(Date dateFab) {
		this.dateFab = dateFab;
	}

}
