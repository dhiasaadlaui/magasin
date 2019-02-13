package com.magasin.dao.interfaces;

import java.util.List;

public interface IGenericDao<T> {

	T findById(int id);
	List<T> findAll();
	int create (T entite);
	int edit (T entite);
	int delete(T entite);

}

//Med
