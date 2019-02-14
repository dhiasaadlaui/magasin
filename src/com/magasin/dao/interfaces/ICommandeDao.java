package com.magasin.dao.interfaces;

import java.util.Date;
import java.util.List;

import com.magasin.entities.Commande;

public interface ICommandeDao extends IGenericDao<Commande> {
	
	
	public List<Commande> findBeforeDate(Date date);
	public List<Commande> findAfterDate(Date date);
	public List<Commande> findByDate(Date date);
	public List<Commande> findByStatut(String statut);

}
