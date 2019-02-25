package com.magasin.service.interfaces;

import java.util.List;

import com.magasin.entities.Tv;

public interface IServiceTv extends IGenericService<Tv> {
	public enum TvSearchFields {
		RESOLUTION;
	}
	List<Tv> search ( TvSearchFields  field,Object value  );
}
