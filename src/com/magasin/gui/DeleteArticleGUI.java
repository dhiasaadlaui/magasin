package com.magasin.gui;

import java.util.Scanner;

import com.magasin.entities.Article;
import com.magasin.entities.Chaussure;
import com.magasin.entities.Frigo;
import com.magasin.entities.Fruit;
import com.magasin.entities.Laitier;
import com.magasin.entities.Pull;
import com.magasin.entities.Tv;
import com.magasin.service.implementation.ServiceChaussureImpl;
import com.magasin.service.implementation.ServiceFrigoImpl;
import com.magasin.service.implementation.ServiceFruitImpl;
import com.magasin.service.implementation.ServiceLaitierImpl;
import com.magasin.service.implementation.ServicePullImpl;
import com.magasin.service.implementation.ServiceTvImpl;
import com.magasin.service.interfaces.IServiceChaussure;
import com.magasin.service.interfaces.IServiceFrigo;
import com.magasin.service.interfaces.IServiceFruit;
import com.magasin.service.interfaces.IServiceLaitier;
import com.magasin.service.interfaces.IServicePull;
import com.magasin.service.interfaces.IServiceTv;

public class DeleteArticleGUI {
	static Scanner sc ;
	int typeArticle = 0;
	int id;
	String validation;
	public DeleteArticleGUI(Article article) {
		// TODO Auto-generated constructor stub
		sc = new Scanner(System.in);
		boolean test = false;
		System.out.println("_____________________________________________________");
		System.out.println("|                                                    |");
		System.out.println("|                      Welcome                       |");
		System.out.println("|____________________________________________________|");
		System.out.println("|         Choose Artical type to delate it           |");
		System.out.println("|____________________________________________________|");
		System.out.println("|         1.Pull                  2.Shoes            |");
		System.out.println("|         3.Laitier               4.Fruit            |");
		System.out.println("|         5.Tv                    6.Frigo            |");
		System.out.println("|                     7.Back                         |");
		System.out.println("|____________________________________________________|");
		do {
			if (test == true)
				System.out.println("Plz choose a valide type Article !!!");
			else
				System.out.println("Choose Article type between (1,2,3,4,5,6 or 7) :");
			typeArticle = sc.nextInt();
			sc.nextLine();
			test = true;
		} while (typeArticle != 1 && typeArticle != 2 && typeArticle != 3 && typeArticle != 4 && typeArticle != 5
				&& typeArticle != 6 && typeArticle != 7);
			
		switch (typeArticle) {
		case 1:
		{
			IServicePull iServicePull = new ServicePullImpl();
			for (Pull pull : iServicePull.findAll()) {
				System.out.println("_____________________________________________________");
				System.out.println(pull);
				System.out.println("_____________________________________________________");
			}
			do {
			System.out.println("_____________________________________________________");
			System.out.println("|         Choose Pull Id you want to delate          |");
			System.out.println("|____________________________________________________|");
			id = sc.nextInt();
			sc.nextLine();
			}while(id  == 0);
			do {
				System.out.println("You sure want confirme the delate !!(Y/N)");
				validation = sc.nextLine();
			}while(!validation.toUpperCase().equals("Y"));
			try {
				
				if(iServicePull.delete(iServicePull.findById(id)) != 0) {
					System.out.println("______________________________________________________");
					System.out.println("|                    Pull delated                    |");
					System.out.println("|____________________________________________________|");
					new DeleteArticleGUI(article);
				}else {
					System.out.println("______________________________________________________");
					System.out.println("|          System hors service try later             |");
					System.out.println("|                 Or id not Exist                    |");
					System.out.println("|____________________________________________________|");
					new DeleteArticleGUI(article);
				}
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println("______________________________________________________");
				System.out.println("|          System hors service try later             |");
				System.out.println("|____________________________________________________|");
				new DeleteArticleGUI(article);
			}
			
			break;
		}
		case 2:
		{
			IServiceChaussure iServiceChaussure = new ServiceChaussureImpl();
			for (Chaussure chaussure : iServiceChaussure.findAll()) {
				System.out.println(chaussure);
				System.out.println("__________________________________________________________________________________________________________");
			}
			do {
			System.out.println("_____________________________________________________");
			System.out.println("|         Choose Pull Id you want to delate          |");
			System.out.println("|____________________________________________________|");
			id = sc.nextInt();
			sc.nextLine();
			}while(id  == 0);
			do {
				System.out.println("You sure want confirme the delate !!(Y/N)");
				validation = sc.nextLine();
			}while(!validation.toUpperCase().equals("Y"));
			try {
				
				if(iServiceChaussure.delete(iServiceChaussure.findById(id)) != 0) {
					System.out.println("______________________________________________________");
					System.out.println("|                 Chaussure delated                  |");
					System.out.println("|____________________________________________________|");
					new DeleteArticleGUI(article);
				}else {
					System.out.println("______________________________________________________");
					System.out.println("|          System hors service try later             |");
					System.out.println("|                 Or id not Exist                    |");
					System.out.println("|____________________________________________________|");
					new DeleteArticleGUI(article);
				}
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println("______________________________________________________");
				System.out.println("|          System hors service try later             |");
				System.out.println("|                 Or id not Exist                    |");
				System.out.println("|____________________________________________________|");
				new DeleteArticleGUI(article);
			}
			
			break;
		}
		case 3:
		{
			IServiceLaitier iServiceLaitier = new ServiceLaitierImpl();
			for (Laitier laitier : iServiceLaitier.findAll()) {
				System.out.println(laitier);
				System.out.println("__________________________________________________________________________________________________________");
			}
			do {
			System.out.println("_____________________________________________________");
			System.out.println("|       Choose Laitier Id you want to delate         |");
			System.out.println("|____________________________________________________|");
			id = sc.nextInt();
			sc.nextLine();
			}while(id  == 0);
			do {
				System.out.println("You sure want confirme the delate !!(Y/N)");
				validation = sc.nextLine();
			}while(!validation.toUpperCase().equals("Y"));
			try {
				
				if(iServiceLaitier.delete(iServiceLaitier.findById(id)) != 0) {
					System.out.println("_____________________________________________________");
					System.out.println("|                 Laitier delated                  |");
					System.out.println("|____________________________________________________|");
					new DeleteArticleGUI(article);
				}else {
					System.out.println("______________________________________________________");
					System.out.println("|          System hors service try later             |");
					System.out.println("|                 Or id not Exist                    |");
					System.out.println("|____________________________________________________|");
					new DeleteArticleGUI(article);
				}
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println("______________________________________________________");
				System.out.println("|          System hors service try later             |");
				System.out.println("|                 Or id not Exist                    |");
				System.out.println("|____________________________________________________|");
				new DeleteArticleGUI(article);
			}
			
			break;
		}
		case 4:
		{
			IServiceFruit iServiceFruit = new ServiceFruitImpl();
			for (Fruit fruit : iServiceFruit.findAll()) {
				System.out.println(fruit);
				System.out.println("__________________________________________________________________________________________________________");
			}
			do {
			System.out.println("_____________________________________________________");
			System.out.println("|         Choose Fruit Id you want to delate          |");
			System.out.println("|____________________________________________________|");
			id = sc.nextInt();
			sc.nextLine();
			}while(id  == 0);
			do {
				System.out.println("You sure want confirme the delate !!(Y/N)");
				validation = sc.nextLine();
			}while(!validation.toUpperCase().equals("Y"));
			try {
				
				if(iServiceFruit.delete(iServiceFruit.findById(id)) != 0) {
					System.out.println("______________________________________________________");
					System.out.println("|                   Fruit delated                    |");
					System.out.println("|____________________________________________________|");
					new DeleteArticleGUI(article);
				}else {
					System.out.println("______________________________________________________");
					System.out.println("|          System hors service try later             |");
					System.out.println("|                 Or id not Exist                    |");
					System.out.println("|____________________________________________________|");
					new DeleteArticleGUI(article);
				}
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println("______________________________________________________");
				System.out.println("|          System hors service try later             |");
				System.out.println("|                 Or id not Exist                    |");
				System.out.println("|____________________________________________________|");
				new DeleteArticleGUI(article);
			}
			
			break;
		}
		case 5:
		{
			IServiceTv iServiceTv = new ServiceTvImpl();
			for (Tv tv : iServiceTv.findAll()) {
				System.out.println(tv);
				System.out.println("__________________________________________________________________________________________________________");
			}
			do {
			System.out.println("_____________________________________________________");
			System.out.println("|          Choose tv Id you want to delate           |");
			System.out.println("|____________________________________________________|");
			id = sc.nextInt();
			sc.nextLine();
			}while(id  == 0);
			do {
				System.out.println("You sure want confirme the delate !!(Y/N)");
				validation = sc.nextLine();
			}while(!validation.toUpperCase().equals("Y"));
			try {
				
				if(iServiceTv.delete(iServiceTv.findById(id)) != 0) {
					System.out.println("______________________________________________________");
					System.out.println("|                     Tv delated                     |");
					System.out.println("|____________________________________________________|");
					new DeleteArticleGUI(article);
				}else {
					System.out.println("______________________________________________________");
					System.out.println("|          System hors service try later             |");
					System.out.println("|                 Or id not Exist                    |");
					System.out.println("|____________________________________________________|");
					new DeleteArticleGUI(article);
				}
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println("______________________________________________________");
				System.out.println("|          System hors service try later             |");
				System.out.println("|                 Or id not Exist                    |");
				System.out.println("|____________________________________________________|");
				new DeleteArticleGUI(article);
			}
			
			break;
		}
		case 6:
		{
			IServiceFrigo iServiceFrigo = new ServiceFrigoImpl();
			for (Frigo frigo : iServiceFrigo.findAll()) {
				System.out.println(frigo);
				System.out.println("__________________________________________________________________________________________________________");
			}
			do {
			System.out.println("_____________________________________________________");
			System.out.println("|         Choose Frigo Id you want to delate          |");
			System.out.println("|____________________________________________________|");
			id = sc.nextInt();
			sc.nextLine();
			}while(id  == 0);
			do {
				System.out.println("You sure want confirme the delate !!(Y/N)");
				validation = sc.nextLine();
			}while(!validation.toUpperCase().equals("Y"));
			try {
				
				if(iServiceFrigo.delete(iServiceFrigo.findById(id)) != 0) {
					System.out.println("______________________________________________________");
					System.out.println("|                   Frigo delated                    |");
					System.out.println("|____________________________________________________|");
					new DeleteArticleGUI(article);
				}else {
					System.out.println("______________________________________________________");
					System.out.println("|          System hors service try later             |");
					System.out.println("|                 Or id not Exist                    |");
					System.out.println("|____________________________________________________|");
					new DeleteArticleGUI(article);
				}
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println("______________________________________________________");
				System.out.println("|          System hors service try later             |");
				System.out.println("|                 Or id not Exist                    |");
				System.out.println("|____________________________________________________|");
				new DeleteArticleGUI(article);
			}
			
			break;
		}
		case 7:
			String[] args = null;
			new MainMenu().main(args);
			break;
		default:
			break;
		}
	}
	public static void main(String[] args) {
		Article article = new Article();
		new DeleteArticleGUI(article);
	}

}
