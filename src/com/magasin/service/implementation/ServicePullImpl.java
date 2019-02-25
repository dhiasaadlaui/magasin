package com.magasin.service.implementation;

import java.util.List;

import com.magasin.dao.implementation.PullDaoImpl;
import com.magasin.dao.interfaces.IPullDao;
import com.magasin.entities.Pull;
import com.magasin.service.interfaces.IServicePull;

public class ServicePullImpl implements IServicePull {

	private IPullDao pulldo;
	public ServicePullImpl() {
		// TODO Auto-generated constructor stub
		pulldo = new PullDaoImpl();
	}

	@Override
	public Pull findById(int id) {
		// TODO Auto-generated method stub
		
		return pulldo.findById(id);
	}

	@Override
	public List<Pull> findAll() {
		// TODO Auto-generated method stub
		return pulldo.findAll();
	}

	@Override
	public int create(Pull entite) {
		// TODO Auto-generated method stub
		return pulldo.create(entite);
	}

	@Override
	public int edit(Pull entite) {
		// TODO Auto-generated method stub
		return pulldo.edit(entite);
	}

	@Override
	public int delete(Pull entite) {
		// TODO Auto-generated method stub
		return pulldo.delete(entite);
	}

	@Override
	public List<Pull> search(Object field, Object value) {
		// TODO Auto-generated method stub
		if(field.equals("taille"))
			return pulldo.rechercherParTaille((String)value);
		return null;
	}

}
