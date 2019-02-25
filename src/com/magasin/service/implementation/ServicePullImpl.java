package com.magasin.service.implementation;

import java.util.List;

import com.magasin.dao.implementation.PullDaoImpl;
import com.magasin.dao.interfaces.IPullDao;
import com.magasin.entities.Pull;
import com.magasin.service.interfaces.IServicePull;

public class ServicePullImpl implements IServicePull {

	private IPullDao pulldo;

	public ServicePullImpl() {
		pulldo = new PullDaoImpl();
	}

	@Override
	public Pull findById(int id) {
		return pulldo.findById(id);
	}

	@Override
	public List<Pull> findAll() {
		return pulldo.findAll();
	}

	@Override
	public int create(Pull entite) {
		return pulldo.create(entite);
	}

	@Override
	public int edit(Pull entite) {
		return pulldo.edit(entite);
	}

	@Override
	public int delete(Pull entite) {
		return pulldo.delete(entite);
	}

	@Override
	public List<Pull> search(PullSearchFields field, Object value) {
		switch (field) {
		case TAILLE:
			return pulldo.rechercherParTaille((String) value);
		default:
			return null;
		}
	}

}
