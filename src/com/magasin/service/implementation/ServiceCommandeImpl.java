package com.magasin.service.implementation;

import java.util.Date;
import java.util.List;

import com.magasin.dao.implementation.CommandeDaoImpl;
import com.magasin.dao.interfaces.ICommandeDao;
import com.magasin.entities.Commande;
import com.magasin.service.interfaces.IServiceCommande;

public class ServiceCommandeImpl implements IServiceCommande {

	private ICommandeDao commandeDao;
	
	public ServiceCommandeImpl() {
		this.commandeDao = new CommandeDaoImpl();
	}

	@Override
	public Commande findById(int id) {
		return this.commandeDao.findById(id);
	}

	@Override
	public List<Commande> findAll() {
		return this.commandeDao.findAll();
	}

	@Override
	public int create(Commande entite) {
		entite.setStatutCmd("PENDING");
		return this.commandeDao.create(entite);
	}

	@Override
	public int edit(Commande entite) {
		return this.commandeDao.edit(entite);
	}

	@Override
	public int delete(Commande entite) {
		return this.commandeDao.delete(entite);
	}


	@Override
	public List<Commande> search(CommandeSearchFields field, Object value) {
		switch (field) {
		case BYDATE:
			return commandeDao.findByDate((Date) value);
		case AFTERDATE:
			return commandeDao.findAfterDate((Date) value);
		case BEFOREDATE:
			return commandeDao.findBeforeDate((Date) value);
		default:
			return null;
		}
	}

	@Override
	public void validateCommande(Commande commande) {
		commande.setStatutCmd("DONE");
		this.edit(commande);
	}

}
