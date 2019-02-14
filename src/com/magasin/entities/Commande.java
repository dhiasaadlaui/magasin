package com.magasin.entities;

import java.util.Date;

public class Commande {

	private int id;
	private Date dateCmd;
	private String statutCmd ;
	
	
	
	public Commande(Date dateCmd, String statutCmd) {
		super();
		this.dateCmd = dateCmd;
		this.statutCmd = statutCmd;
	}

	public Commande(int id, Date dateCmd, String statutCmd) {
		this(dateCmd, statutCmd);
		this.id=id;
	}
	
	
	public Commande() {
		// TODO Auto-generated constructor stub
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
	
	

}
