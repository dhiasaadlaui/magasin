package com.magasin.dao.interfaces;

import java.util.List;

import com.magasin.entities.Article;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

public interface IArticleDao  {

List<Article> findAll();
int create (Article entite);
int edit (Article entite);
int delete(Article entite);
List<Article> findByLibelle(String libelle); 
	
}
