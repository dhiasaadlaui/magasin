package com.magasin.dao.interfaces;

import java.util.List;

import com.magasin.entities.Pull;

public interface IPullDao extends IGenericDao<Pull>{

	List<Pull> rechercherParTaille ( String taille);
	
}
