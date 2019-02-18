package com.magasin.dao.interfaces;

import java.util.Date;
import java.util.List;

import com.magasin.entities.Laitier;

public interface ILaitierDao extends IGenericDao<Laitier> {
 
 List<Laitier>	findByDateExp (Date date);
 List<Laitier> findAfterDateExp(Date  date);
 List<Laitier> findBeforeDateExp(Date  date);
 
	
}
