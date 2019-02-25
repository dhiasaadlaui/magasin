package com.magasin.service.interfaces;

import java.util.List;

import com.magasin.entities.Article;

public interface IServiceArticle  {
	
	public enum ArticleTypes{
		PULL,CHAUSSURE,FRIGO,TV,FRUIT,LAITIER;
	}
	Article findById(ArticleTypes type ,int id);
	List<Article> findAll();
	int create (Article entite);
	int edit (Article entite);
	int delete(Article entite);
	
}
