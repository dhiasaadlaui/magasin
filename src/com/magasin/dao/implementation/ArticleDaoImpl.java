package com.magasin.dao.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.magasin.dao.interfaces.IArticleDao;
import com.magasin.dao.interfaces.IChaussureDao;
import com.magasin.dao.interfaces.IFrigoDao;
import com.magasin.dao.interfaces.IFruitDao;
import com.magasin.dao.interfaces.ILaitierDao;
import com.magasin.dao.interfaces.IPullDao;
import com.magasin.dao.interfaces.ITvDao;
import com.magasin.entities.Article;
import com.magasin.entities.Frigo;
import com.magasin.entities.Fruit;
import com.magasin.entities.Laitier;
import com.magasin.entities.Pull;
import com.magasin.entities.Tv;

public class ArticleDaoImpl extends GenericDaoImpl implements IArticleDao {

	private IFrigoDao frigoDao;
	private IChaussureDao chaussureDao;
	private IFruitDao fruitDao;
	private ILaitierDao laitierDao;
	private IPullDao pullDao;
	private ITvDao tvDao;

	public ArticleDaoImpl() {
		this.frigoDao = new FrigoDaoImpl();
		this.chaussureDao = new ChaussureDaoImpl();
		this.fruitDao = new FruitDaoImpl();
		this.laitierDao = new LaitierDaoImpl();
		this.pullDao = new PullDaoImpl();
		this.tvDao = new TvDaoImpl();
	}

	// return all the articles in the database
	@Override
	public List<Article> findAll() {
		List<Article> allArticles = new ArrayList<Article>();

		allArticles.addAll(frigoDao.findAll());
		allArticles.addAll(chaussureDao.findAll());
		allArticles.addAll(fruitDao.findAll());
		//allArticles.addAll(laitierDao.findAll());
		allArticles.addAll(pullDao.findAll());
		allArticles.addAll(tvDao.findAll());

		return allArticles;

	}

	@Override
	public List<Article> findByLibelle(String libelle) {
		return findAll().stream()
				.filter(a -> a.getLibelle().equals(libelle))
				.collect(Collectors.toList());
	}

	// the methode return -1 if the article wasn't added
	@Override
	public int create(Article entite) {

		if (entite instanceof Frigo)
			return frigoDao.create((Frigo) entite);
		if (entite instanceof Fruit)
			return fruitDao.create((Fruit) entite);
		if (entite instanceof Laitier)
			return laitierDao.create((Laitier) entite);
		if (entite instanceof Pull)
			return pullDao.create((Pull) entite);
		if (entite instanceof Tv)
			return tvDao.create((Tv) entite);

		return -1;
	}

	// the methode return -1 if the article wasn't modified
	@Override
	public int edit(Article entite) {
		if (entite instanceof Frigo)
			return frigoDao.edit((Frigo) entite);
		if (entite instanceof Fruit)
			return fruitDao.edit((Fruit) entite);
		if (entite instanceof Laitier)
			return laitierDao.edit((Laitier) entite);
		if (entite instanceof Pull)
			return pullDao.edit((Pull) entite);
		if (entite instanceof Tv)
			return tvDao.edit((Tv) entite);

		return -1;

	}

	@Override
	public int delete(Article entite) {
		if (entite instanceof Frigo)
			return frigoDao.delete((Frigo) entite);
		if (entite instanceof Fruit)
			return fruitDao.delete((Fruit) entite);
		if (entite instanceof Laitier)
			return laitierDao.delete((Laitier) entite);
		if (entite instanceof Pull)
			return pullDao.delete((Pull) entite);
		if (entite instanceof Tv)
			return tvDao.delete((Tv) entite);

		return -1;
	}


}
