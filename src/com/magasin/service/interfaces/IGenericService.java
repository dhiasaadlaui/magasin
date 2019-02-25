package com.magasin.service.interfaces;

import java.util.List;

import com.magasin.entities.Chaussure;

public interface IGenericService<T> {

	T findById(int id);
	List<T> findAll();
	int create (T entite);
	int edit (T entite);
	int delete(T entite);
	
	
	
}
