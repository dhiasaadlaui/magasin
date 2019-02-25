package com.magasin.gui;

import java.util.Scanner;
import java.util.function.Consumer;

import com.magasin.entities.Article;
import com.magasin.entities.Commande;
import com.magasin.entities.LigneCommande;
import com.magasin.service.implementation.ServiceArticleImpl;
import com.magasin.service.implementation.ServiceCommandeImpl;
import com.magasin.service.interfaces.IServiceArticle;
import com.magasin.service.interfaces.IServiceArticle.ArticleTypes;
import com.magasin.service.interfaces.IServiceCommande;

public class ValidationCommadeGUI {
	private IServiceCommande serviceCommande;
	private Scanner s = new Scanner(System.in);
	private int response;
	private boolean cmdDeleted=false;
	IServiceArticle serviceArticle= new ServiceArticleImpl();

	private Commande cmd;

	public ValidationCommadeGUI(Commande commande) {
		cmd = commande;
		serviceCommande = new ServiceCommandeImpl();
		int response;
		do {
			cmd.affiche();
			System.out.println("1- Delete");
			System.out.println("2- Update");
			System.out.println("0- Back");
			response = s.nextInt();
			switch (response) {
			case 1:
				verifie(e->this.serviceCommande.delete(e));
				break;
			case 2:
				UpdateGUI();
				break;
			default:
				break;
			}
		} while (response != 0 && !cmdDeleted);

		// TODO Auto-generated constructor stub

	}

	private void UpdateGUI() {
		
		// TODO Auto-generated method stub
		do {
			cmd.affiche();
			System.out.println("1-Add new product");
			System.out.println("2-Update product quantity");
			System.out.println("3-Validate commande");
			System.out.println("0-Back");
			response = s.nextInt();
			switch (response) {
			case 1:
				addLineGUI();
				break;
			case 2:
				updateComande();
				
				break;
			case 3:
				verifie(c->this.serviceCommande.validateCommande(c));
				break;
			default:
				break;
			}
		} while (response!=0);
		
		

	}

	private void updateComande() {
		// TODO Auto-generated method stub
		int i=0;
		for (LigneCommande l : cmd.getLignesCommande()) {
			System.out.println("1 ) "+l);
			i++;
		}
		System.out.println("Enter Index");
		i=s.nextInt();
		System.out.println("Enter New Quantity");
		cmd.getLignesCommande().get(i).setQuantite(s.nextInt());
		verifie(e->serviceCommande.edit(cmd));
		
		
		
	}

	private void addLineGUI() {
		// TODO Auto-generated method stub
		
		for ( Article article : serviceArticle.findAll()) {
			System.out.println(article);
		}
		
		System.out.print("Enter product Type( TV, PULL, CHAUSSURE, FRIGO, FRUIT, LAITIER  :");
		String type=s.next();
		System.out.print("Enter product ID :");
		int id=s.nextInt();
		System.out.print("Enter Quantity :");
		int q=s.nextInt();
		ArticleTypes t;
		if(type.toUpperCase().equals("PULL")) t=ArticleTypes.PULL;
		else if(type.toUpperCase().equals("CHAUSSURE")) t=ArticleTypes.CHAUSSURE;
		else if(type.toUpperCase().equals("FRIGO")) t=ArticleTypes.FRIGO;
		else if(type.toUpperCase().equals("TV")) t=ArticleTypes.TV;
		else if(type.toUpperCase().equals("FRUIT")) t=ArticleTypes.FRUIT;
		else t=ArticleTypes.LAITIER;

			
		Article a=serviceArticle.findById(t, id);
		LigneCommande l=new LigneCommande(a, cmd, q);
		cmd.getLignesCommande().add(l);
		//not working!!to fix.
		verifie(e->serviceCommande.edit(e));
		
		
		
		
	}

	private void verifie(Consumer<Commande> c) {
		// TODO Auto-generated method stub
	
		System.out.println("Are you sur?");
		System.out.println("1-Yes");
		System.out.println("2-No");
		response=s.nextInt();
		switch (response) {
		case 1:
			c.accept(cmd);
			cmdDeleted= true;
			break;
	
			
		}
	}



}
