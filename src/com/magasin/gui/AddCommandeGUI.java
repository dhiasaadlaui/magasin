package com.magasin.gui;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.magasin.entities.Article;
import com.magasin.entities.Commande;
import com.magasin.entities.LigneCommande;
import com.magasin.service.implementation.ServiceArticleImpl;

import com.magasin.service.implementation.ServiceCommandeImpl;

import com.magasin.service.interfaces.IServiceArticle.ArticleTypes; 

public class AddCommandeGUI {
	Scanner scn;
	public AddCommandeGUI() {
		boolean test=true;
		 scn = new Scanner(System.in);
		System.out.println("|================== Add New Command  ====================|");
		ServiceArticleImpl sArt =new ServiceArticleImpl();
		ServiceCommandeImpl sCom = new ServiceCommandeImpl();
		List<Article> lArticle = sArt.findAll();
		List<LigneCommande> lLigne = new ArrayList<>();
		Commande commande = new Commande();
		for(Article ar : lArticle)
		{
			System.out.println(ar);
		}
		do {
			System.out.println("Add article to commande ? (y/n)");
			String sc=scn.next();
			if(sc.equals("y"))
			{
				//only for intialisation
				ArticleTypes type=ArticleTypes.CHAUSSURE;
			
				System.out.println("1 => chaussure , 2 => frigo, 3 => fruit, 4 => Laitier, 5"
						+ " => pull, 6 => tv");
				switch (scn.nextInt()) {
				case 1:
					type=ArticleTypes.CHAUSSURE;
				case 2:
					type=ArticleTypes.FRIGO;
				case 3:
					type=ArticleTypes.FRUIT;
				case 4:
					type=ArticleTypes.LAITIER;
				case 5:
					type=ArticleTypes.PULL;
				case 6:
					type=ArticleTypes.TV;
				}
				System.out.println("Article ID ?");
				Article article =sArt.findById(type,scn.nextInt());
				System.out.println("Quantite?");
				int qte = scn.nextInt();
				LigneCommande lc =new LigneCommande(article, commande, qte);
				lLigne.add(lc);
			}
			 else if(sc.equals("n"))
			 {
				 test=false;
			 }
			
		}while(test);
		commande.setLignesCommande(lLigne);
		System.out.println("Validate Commande ? (y/n)");
		if(scn.next().equals("y"))
		{
			sCom.create(commande);
		}
		else {
			System.exit(0);
		}
	}

}
