package com.magasin.service.implementation;

import java.util.Date;
import java.util.List;

import com.magasin.dao.implementation.LaitierDaoImpl;
import com.magasin.dao.interfaces.ILaitierDao;
import com.magasin.entities.Laitier;
import com.magasin.service.interfaces.IServiceLaitier;

public class ServiceLaitierImpl implements IServiceLaitier {
	
	private ILaitierDao laitierDao;

	public ServiceLaitierImpl() {
		this.laitierDao = new LaitierDaoImpl();
	}

	@Override
	public Laitier findById(int id) {
		return this.laitierDao.findById(id);
	}

	@Override
	public List<Laitier> findAll() {
		return this.laitierDao.findAll();
	}

	@Override
	public int create(Laitier entite) {
		return this.laitierDao.create(entite);
	}

	@Override
	public int edit(Laitier entite) {
		return this.laitierDao.edit(entite);
	}

	@Override
	public int delete(Laitier entite) {
		return this.laitierDao.delete(entite);
	}


	@Override
	public List<Laitier> search(LaitierSearchFields field, Object value) {
		switch (field) {
		case DATEXP:
			return this.laitierDao.findByDateExp((Date) value);
		case BEFOREDATEXP:
			return this.laitierDao.findBeforeDateExp((Date) value);
		case AFTERDATEXP:
			return this.laitierDao.findAfterDateExp((Date) value);
		default:
			return null;
		}
	}

}
