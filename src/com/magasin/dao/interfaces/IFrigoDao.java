package com.magasin.dao.interfaces;

import java.util.ArrayList;

import com.magasin.entities.Frigo;

public interface IFrigoDao extends IGenericDao<Frigo>{
	
	ArrayList<Frigo> rechercherParCapacite(int capacite);
	ArrayList<Frigo> rechercherParRationCons(int capacite);
}
