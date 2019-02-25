package com.magasin.service.interfaces;

import java.util.List;

import com.magasin.entities.Tv;

public interface IServiceTv extends IGenericService<Tv> {
	List<Tv> search ( Object  field,Object value  );
}
