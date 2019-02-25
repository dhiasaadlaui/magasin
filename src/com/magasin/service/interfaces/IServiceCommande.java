package com.magasin.service.interfaces;

import java.util.List;

import com.magasin.entities.Commande;
import com.magasin.entities.Tv;

public interface IServiceCommande extends IGenericService<Commande> {
	
	public enum CommandeSearchFields{
		BEFOREDATE,AFTERDATE,BYDATE,STATUS;
		
	}
	List<Commande> search ( CommandeSearchFields  field,Object value  );
	
}
