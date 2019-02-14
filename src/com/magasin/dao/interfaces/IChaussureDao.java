package com.magasin.dao.interfaces;

import java.util.List;

import com.magasin.entities.Chaussure;

public interface IChaussureDao extends IGenericDao<Chaussure> {
	List<Chaussure> rechercherParPointure ( int pointure);
	List<Chaussure> rechercherParCouleur ( String couleur);
	List<Chaussure> rechercherParMarque ( String marque);
	List<Chaussure> rechercherParGenre ( String genre);
	
}
