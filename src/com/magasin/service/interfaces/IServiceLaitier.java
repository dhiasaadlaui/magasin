package com.magasin.service.interfaces;

import java.util.List;

import com.magasin.entities.Laitier;

public interface IServiceLaitier extends IGenericService<Laitier> {
	public enum LaitierSearchFields{
		DATEXP,BEFOREDATEXP,AFTERDATEXP;
		
	}
	
	List<Laitier> search ( LaitierSearchFields  field,Object value  );
}
