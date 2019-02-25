package com.magasin.service.interfaces;

import java.util.List;

import com.magasin.entities.Frigo;
import com.magasin.entities.Tv;

public interface IServiceFrigo extends IGenericService<Frigo> {

	public enum FrigoSearchFields{
		CAPACITE,CONSOMMATION;
		
	}
	
	List<Frigo> search ( FrigoSearchFields  field,Object value  );
}
