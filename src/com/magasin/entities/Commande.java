package com.magasin.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Commande {

	private int id;
	private Date dateCmd;
	private String statutCmd ;
	private List<LigneCommande> lignesCommande = new ArrayList<>() ;
	
	
	
	
	public List<LigneCommande> getLignesCommande() {
		return lignesCommande;
	}

	public void setLignesCommande(List<LigneCommande> lignesCommande) {
		this.lignesCommande = lignesCommande;
	}

	public Commande(Date dateCmd, String statutCmd) {
		super();
		this.dateCmd = dateCmd;
		this.statutCmd = statutCmd;
	}

	public Commande(Date dateCmd, String statutCmd, List<LigneCommande> lignesCommande) {
		super();
		this.dateCmd = dateCmd;
		this.statutCmd = statutCmd;
		this.lignesCommande = lignesCommande;
	}

	public Commande(int id, Date dateCmd, String statutCmd, List<LigneCommande> lignesCommande) {
		super();
		this.id = id;
		this.dateCmd = dateCmd;
		this.statutCmd = statutCmd;
		this.lignesCommande = lignesCommande;
	}

	public Commande(int id, Date dateCmd, String statutCmd) {
		this(dateCmd, statutCmd);
		this.id=id;
	}
	
	
	public Commande() {
		// TODO Auto-generated constructor stub
		this.dateCmd = new Date();
		statutCmd = "PENDING";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateCmd() {
		return dateCmd;
	}

	public void setDateCmd(Date dateCmd) {
		this.dateCmd = dateCmd;
	}

	public String getStatutCmd() {
		return statutCmd;
	}

	public void setStatutCmd(String statutCmd) {
		this.statutCmd = statutCmd;
	}

	@Override
	public String toString() {
		return "Commande [id=" + id + ", dateCmd=" + dateCmd + ", statutCmd=" + statutCmd + "]";
	}
	
	

}
