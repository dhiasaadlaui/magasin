package com.magasin.dao.implementation;

import java.util.Date;
import java.util.List;

import com.magasin.dao.interfaces.ILaitierDao;
import com.magasin.entities.Laitier;

public class LaitierDaoImpl extends GenericDaoImpl implements ILaitierDao {

	public LaitierDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Laitier findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Laitier> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int create(Laitier entite) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int edit(Laitier entite) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Laitier entite) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Laitier> findByDateExp(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Laitier> findAfterDateExp(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Laitier> findBeforeDateExp(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

}
