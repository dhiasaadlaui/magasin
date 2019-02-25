package com.magasin.service.interfaces;

import java.util.List;

import com.magasin.entities.Fruit;
import com.magasin.entities.Tv;

public interface IServiceFruit extends IGenericService<Fruit> {

	public enum FruitSearchFields{
		SAISON;		
	}
	
	List<Fruit> search ( FruitSearchFields  field,Object value  );
}
