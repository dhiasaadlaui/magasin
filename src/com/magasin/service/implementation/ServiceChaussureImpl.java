package com.magasin.service.implementation;

import java.util.List;

import com.magasin.dao.implementation.ChaussureDaoImpl;
import com.magasin.dao.interfaces.IChaussureDao;
import com.magasin.entities.Chaussure;
import com.magasin.service.interfaces.IServiceChaussure;

public class ServiceChaussureImpl implements IServiceChaussure {

	private IChaussureDao chaussureDao;

	public ServiceChaussureImpl() {
		this.chaussureDao = new ChaussureDaoImpl();
	}

	@Override
	public Chaussure findById(int id) {
		return chaussureDao.findById(id);
	}

	@Override
	public List<Chaussure> findAll() {
		return chaussureDao.findAll();
	}

	@Override
	public int create(Chaussure entite) {
		return chaussureDao.create(entite);
	}

	@Override
	public int edit(Chaussure entite) {
		return chaussureDao.edit(entite);
	}

	@Override
	public int delete(Chaussure entite) {
		return chaussureDao.delete(entite);
	}

	@Override
	public List<Chaussure> search(ChaussureSearchFields field, Object value) {
		switch (field) {
		case COULEUR:
			return chaussureDao.rechercherParCouleur((String) value);
		case MARQUE:
			return chaussureDao.rechercherParMarque((String) value);
		case GENRE:
			return chaussureDao.rechercherParGenre((String) value);
		case POINTURE:
			return chaussureDao.rechercherParPointure((int) value);
		default:
			return null;
		}

	}

}
