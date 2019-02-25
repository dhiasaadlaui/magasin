package com.magasin.service.implementation;

import java.util.List;

import com.magasin.dao.implementation.TvDaoImpl;
import com.magasin.dao.interfaces.ITvDao;
import com.magasin.entities.Tv;
import com.magasin.service.interfaces.IServiceTv;

public class ServiceTvImpl implements IServiceTv {

	private ITvDao tvDao;

	public ServiceTvImpl() {
		this.tvDao = new TvDaoImpl();
	}

	@Override
	public Tv findById(int id) {
		return this.tvDao.findById(id);
	}

	@Override
	public List<Tv> findAll() {
		return this.tvDao.findAll();
	}

	@Override
	public int create(Tv entite) {
		return this.tvDao.create(entite);
	}

	@Override
	public int edit(Tv entite) {
		return this.tvDao.edit(entite);
	}

	@Override
	public int delete(Tv entite) {
		return this.tvDao.delete(entite);
	}

	@Override
	public List<Tv> search(TvSearchFields field, Object value) {
		switch (field) {
		case RESOLUTION:
			return this.tvDao.rechercherParResolution((int) value);
		default:
			return null;
		}
	}

}
