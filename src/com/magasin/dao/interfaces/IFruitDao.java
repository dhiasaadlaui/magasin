package com.magasin.dao.interfaces;

import java.util.List;

import com.magasin.entities.Fruit;

public interface IFruitDao extends IGenericDao<Fruit> {
	
	List<Fruit> rechercherParSaision ( String saison);
}
