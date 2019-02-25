package com.magasin.service.implementation;

import java.util.Date;
import java.util.List;

import com.magasin.dao.implementation.FrigoDaoImpl;
import com.magasin.dao.interfaces.IFrigoDao;
import com.magasin.entities.Frigo;
import com.magasin.service.interfaces.IServiceFrigo;

public class ServiceFrigoImpl implements IServiceFrigo {

	private IFrigoDao frigoDao;

	public ServiceFrigoImpl() {
		this.frigoDao = new FrigoDaoImpl();
	}

	@Override
	public Frigo findById(int id) {
		return this.frigoDao.findById(id);
	}

	@Override
	public List<Frigo> findAll() {
		return this.frigoDao.findAll();
	}

	@Override
	public int create(Frigo entite) {
		return this.frigoDao.create(entite);
	}

	@Override
	public int edit(Frigo entite) {
		return this.frigoDao.edit(entite);
	}

	@Override
	public int delete(Frigo entite) {
		return this.frigoDao.delete(entite);
	}

	@Override
	public List<Frigo> search(FrigoSearchFields field, Object value) {
		switch (field) {
		case CAPACITE:
			return frigoDao.rechercherParCapacite((int) value);
		case CONSOMMATION:
			return frigoDao.rechercherParRationCons((int) value);
		default:
			return null;
		}
	}

}
