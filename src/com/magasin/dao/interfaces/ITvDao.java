package com.magasin.dao.interfaces;

import java.util.List;

import com.magasin.entities.Tv;

public interface ITvDao extends IGenericDao<Tv>{
	List<Tv> rechercherParResolution ( int resolution);
}
