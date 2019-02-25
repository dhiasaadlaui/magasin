package com.magasin.service.implementation;

import java.util.Date;
import java.util.List;

import com.magasin.dao.implementation.FruitDaoImpl;
import com.magasin.dao.interfaces.IFruitDao;
import com.magasin.entities.Fruit;
import com.magasin.service.interfaces.IServiceFruit;

public class ServiceFruitImpl implements IServiceFruit {

	private IFruitDao fruitDao;

	public ServiceFruitImpl() {
		this.fruitDao = new FruitDaoImpl();
	}

	@Override
	public Fruit findById(int id) {
		return this.fruitDao.findById(id);
	}

	@Override
	public List<Fruit> findAll() {
		return this.fruitDao.findAll();
	}

	@Override
	public int create(Fruit entite) {
		return this.fruitDao.create(entite);
	}

	@Override
	public int edit(Fruit entite) {
		return this.fruitDao.edit(entite);
	}

	@Override
	public int delete(Fruit entite) {
		return this.fruitDao.delete(entite);
	}

	@Override
	public List<Fruit> search(FruitSearchFields field, Object value) {
		switch (field) {
		case SAISON:
			return this.fruitDao.rechercherParSaision((String) value);
		default:
			return null;
		}
	}

}
