package com.magasin.dao.implementation;

import java.util.List;

import com.magasin.dao.interfaces.IArticleDao;
import com.magasin.entities.Article;

public class ArticleDaoImpl extends GenericDaoImpl implements IArticleDao {

	public ArticleDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Article> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> findByLibelle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int create(Article entite) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int edit(Article entite) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Article entite) {
		// TODO Auto-generated method stub
		return 0;
	}

}
