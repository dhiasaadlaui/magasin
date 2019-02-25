package com.magasin.service.implementation;

import java.util.ArrayList;
import java.util.List;

import com.magasin.dao.implementation.ArticleDaoImpl;
import com.magasin.dao.implementation.Connexion;
import com.magasin.dao.interfaces.IArticleDao;
import com.magasin.entities.Article;
import com.magasin.entities.Pull;
import com.magasin.service.interfaces.IServiceArticle;

public class ServiceArticleImpl implements IServiceArticle {

	private IArticleDao articleDao;

	public ServiceArticleImpl() {
		this.articleDao = new ArticleDaoImpl();
	}

	@Override
	public Article findById(ArticleTypes type, int id) {
		switch (type) {
		case CHAUSSURE:
			return new ServiceChaussureImpl().findById(id);
		case FRIGO:
			return new ServiceFrigoImpl().findById(id);
		case FRUIT:
			return new ServiceFruitImpl().findById(id);
		case LAITIER:
			return new ServiceLaitierImpl().findById(id);
		case PULL:
			return new ServicePullImpl().findById(id);
		case TV:
			return new ServiceTvImpl().findById(id);

		default:
			return null;
		}
	}

	@Override
	public List<Article> findAll() {
		return articleDao.findAll();
	}

	@Override
	public int create(Article entite) {
		return articleDao.create(entite);
	}

	@Override
	public int edit(Article entite) {
		return articleDao.edit(entite);
	}

	@Override
	public int delete(Article entite) {
		return articleDao.delete(entite);
	}

	@Override
	public List<Article> findByLibelle(String libelle) {
		return articleDao.findByLibelle(libelle);
	}

}
