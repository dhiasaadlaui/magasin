package com.magasin.service.interfaces;

import java.util.List;

import com.magasin.entities.Chaussure;
import com.magasin.entities.Tv;

public interface IServiceChaussure extends IGenericService<Chaussure> {

	
	public enum ChaussureSearchFields{
		POINTURE,COULEUR,MARQUE,GENRE;		
	}
	
	List<Chaussure> search ( ChaussureSearchFields field,Object value  );
	
}
