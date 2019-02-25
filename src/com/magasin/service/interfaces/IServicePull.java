package com.magasin.service.interfaces;

import java.util.List;

import com.magasin.entities.Pull;
import com.magasin.entities.Tv;

public interface IServicePull extends IGenericService<Pull> {
	
	public enum PullSearchFields{
		TAILLE;
	}
	List<Pull> search ( PullSearchFields  field,Object value  );
}
