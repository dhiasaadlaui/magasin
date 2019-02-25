package com.magasin.gui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.magasin.dao.implementation.ArticleDaoImpl;
import com.magasin.dao.interfaces.IArticleDao;
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


public class AddArticleGUI {
	IArticleDao articleDao = new ArticleDaoImpl();
	protected String validation;
	protected String libelle;
	protected double prixUnitaire;
	protected int quantite ;
	protected String fournisseur;
	static Scanner sc ;
	public AddArticleGUI() {
		// TODO Auto-generated constructor stub
		sc = new Scanner(System.in);
		int typeArticle = 0;

		System.out.println("_____________________________________________________");
		System.out.println("|                                                    |");
		System.out.println("|                      Welcome                       |");
		System.out.println("|____________________________________________________|");
		System.out.println("|              Choose Artical type                   |");
		System.out.println("|____________________________________________________|");
		System.out.println("|         1.Pull                  2.Shoes            |");
		System.out.println("|         3.Laitier               4.Fruit            |");
		System.out.println("|         5.Tv                    6.Frigo            |");
		System.out.println("|                     7.Back                         |");
		System.out.println("|____________________________________________________|");
		boolean test = false;
		do {
			if (test == true)
				System.out.println("Plz choose a valide typeArticle !!!");
			else
				System.out.print("Choose Article type between (1,2,3,4,5,6 or 7) :");
			typeArticle = sc.nextInt();
			test = true;
		} while (typeArticle != 1 && typeArticle != 2 && typeArticle != 3 && typeArticle != 4 && typeArticle != 5
				&& typeArticle != 6 && typeArticle != 7);

		switch (typeArticle) {
		case 1: {
			String couleurPull;
			String marquePull;
			String genrePull;
			String taillePull;
			String typePull;
			Pull pull;
			IServicePull iServicePull = new ServicePullImpl();
			do {

				do {
					System.out.print("libelle (String) :");
					libelle = sc.next();
				} while (libelle.equals(""));
				do {
					System.out.print("Prix Unitaire (double != 0.0) :");
					prixUnitaire = sc.nextDouble();
				} while (prixUnitaire == 0.0);
				do {
					System.out.print("Quantite (int != 0) :");
					quantite = sc.nextInt();
				} while (quantite == 0);
				do {
					System.out.print("Fournisseur (String) :");
					fournisseur = sc.next();
				} while (fournisseur.equals(""));
				do {
					System.out.print("Couleur (String) :");
					couleurPull = sc.next();
				} while (couleurPull.equals(""));
				do {
					System.out.print("marquePull (String) :");
					marquePull = sc.next();
				} while (marquePull.equals(""));
				do {
					System.out.print("Genre (String) :");
					genrePull = sc.next();
				} while (genrePull.equals(""));
				do {
					System.out.print("Taille ('s','xs','m','l','xl','xxl','xxxl') :");
					taillePull = sc.next();
				} while (!taillePull.toLowerCase().equals("s") && !taillePull.toLowerCase().equals("xs")
						&& !taillePull.toLowerCase().equals("m") && !taillePull.toLowerCase().equals("l")
						&& !taillePull.toLowerCase().equals("xl") && !taillePull.toLowerCase().equals("xxl")
						&& !taillePull.toLowerCase().equals("xxxl"));
				do {
					System.out.print("Type (String) :");
					typePull = sc.next();
				} while (typePull.equals(""));
				// System.out.println("Libelle : "+libelle + " \nPrixUnitaire : "+
				// prixUnitaire
				// +"\nQuantite : "+ quantite +"\nFournisseur : "+ fournisseur
				// +"\nCouleur : "+couleurPull +"\nMarque : "+marquePull
				// +"\nGenre : "+genrePull+"\nTaille "+taillePull+"\nType : "+typePull);
				pull = new Pull(libelle, prixUnitaire, quantite, fournisseur, couleurPull, marquePull,
						genrePull, taillePull, typePull);
				System.out.println(pull);
				System.out.println("You confirme ?? (Y/N) default 'Y'");
				validation = sc.next();
			} while (!validation.toUpperCase().equals("Y"));
			if (iServicePull.create(pull) != 0) {
				System.out.println("______________________________________________________");
				System.out.println("|                      Pull Add                      |");
				System.out.println("|____________________________________________________|");
				new AddArticleGUI();
			} else {
				System.out.println("______________________________________________________");
				System.out.println("|          System hors service try later             |");
				System.out.println("|____________________________________________________|");
				new AddArticleGUI();
			}

			break;
		}

		case 2: {
			String couleurShose;
			String marqueShose;
			String genreShose;
			int pointureShose;
			Chaussure chaussure;
			IServiceChaussure iServiceChaussure = new ServiceChaussureImpl();
			do {
				do {
					System.out.print("libelle (String) :");
					libelle = sc.next();
				} while (libelle.equals(""));
				do {
					System.out.print("Prix Unitaire (double != 0.0) :");
					prixUnitaire = sc.nextDouble();
				} while (prixUnitaire == 0.0);
				do {
					System.out.print("Quantite (int != 0) :");
					quantite = sc.nextInt();
				} while (quantite == 0);
				do {
					System.out.print("Fournisseur (String) :");
					fournisseur = sc.next();
				} while (fournisseur.equals(""));
				do {
					System.out.print("Couleur (String) :");
					couleurShose = sc.next();
				} while (couleurShose.equals(""));
				do {
					System.out.print("marquePull (String) :");
					marqueShose = sc.next();
				} while (marqueShose.equals(""));
				do {
					System.out.print("Genre (String) :");
					genreShose = sc.next();
				} while (genreShose.equals(""));
				do {
					System.out.print("Pointure (33 -> 44) :");
					pointureShose = sc.nextInt();
				} while (pointureShose < 33 || pointureShose > 44);
				// System.out.println("Libelle : "+libelle + " \nPrixUnitaire : "+
				// prixUnitaire
				// +"\nQuantite : "+ quantite +"\nFournisseur : "+ fournisseur
				// +"\nCouleur : "+couleurShose +"\nMarque : "+marqueShose
				// +"\nGenre : "+genreShose+"\nPointure "+pointureShose);
				chaussure = new Chaussure(libelle, prixUnitaire, quantite, fournisseur,
						couleurShose, marqueShose, genreShose, pointureShose);
				System.out.println(chaussure);
				System.out.println("You confirme ?? (Y/N) default 'Y'");
				validation = sc.next();

			} while (!validation.toUpperCase().equals("Y"));
			if (iServiceChaussure.create(chaussure) != 0) {
				System.out.println("______________________________________________________");
				System.out.println("|                  Chaussure Add                     |");
				System.out.println("|____________________________________________________|");
				new AddArticleGUI();
			} else {
				System.out.println("______________________________________________________");
				System.out.println("|          System hors service try later             |");
				System.out.println("|____________________________________________________|");
				new AddArticleGUI();
			}
			break;
		}
		case 3: {
			Date dateExpLaitier = null;
			Date dateFabLaitier = null;
			Laitier laitier;
			IServiceLaitier iServiceLaitier = new ServiceLaitierImpl();
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
			do {
				do {
					System.out.print("libelle (String) :");
					libelle = sc.next();
				} while (libelle.equals(""));
				do {
					System.out.print("Prix Unitaire (double != 0.0) :");
					prixUnitaire = sc.nextDouble();
				} while (prixUnitaire == 0.0);
				do {
					System.out.print("Quantite (int != 0) :");
					quantite = sc.nextInt();
				} while (quantite == 0);
				do {
					System.out.print("Fournisseur (String) :");
					fournisseur = sc.next();
				} while (fournisseur.equals(""));
				do {
					System.out.print("dateExpLaitier (Date : MM-DD-YYYY ) :");

					try {
						dateExpLaitier = sdf.parse(sc.next());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(sdf.format(dateExpLaitier));
				} while (dateExpLaitier.equals(""));
				do {
					System.out.print("dateFabLaitier (String) :");

					try {
						dateFabLaitier = sdf.parse(sc.next());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(dateFabLaitier);
				} while (dateFabLaitier.equals(""));
				laitier = new Laitier(libelle, prixUnitaire, quantite, fournisseur,
						dateExpLaitier, dateFabLaitier);
				System.out.println(laitier);
				System.out.println("You confirme ?? (Y/N) ");
				validation = sc.next();
			} while (!validation.toUpperCase().equals("Y"));

			if (iServiceLaitier.create(laitier) != 0) {
				System.out.println("______________________________________________________");
				System.out.println("|                    Laitier Add                     |");
				System.out.println("|____________________________________________________|");
				new AddArticleGUI();
			} else {
				System.out.println("______________________________________________________");
				System.out.println("|          System hors service try later             |");
				System.out.println("|____________________________________________________|");
				new AddArticleGUI();
			}
			break;
		}
		case 4: {
			String saisonFruit;
			IServiceFruit iServiceFruit = new ServiceFruitImpl();
			Fruit fruit;
			do {
				do {
					System.out.print("libelle (String) :");
					libelle = sc.next();
				} while (libelle.equals(""));
				do {
					System.out.print("Prix Unitaire (double != 0.0) :");
					prixUnitaire = sc.nextDouble();
				} while (prixUnitaire == 0.0);
				do {
					System.out.print("Quantite (int != 0) :");
					quantite = sc.nextInt();
				} while (quantite == 0);
				do {
					System.out.print("Fournisseur (String) :");
					fournisseur = sc.next();
				} while (fournisseur.equals(""));

				do {
					System.out.print("Saison (String) :");
					saisonFruit = sc.next();
				} while (saisonFruit.equals(""));
				fruit = new Fruit(libelle, prixUnitaire, quantite, fournisseur, saisonFruit);
				System.out.println(fruit);
				System.out.println("You confirme ?? (Y/N) ");
				validation = sc.next();
			} while (!validation.toUpperCase().equals("Y"));
			if (iServiceFruit.create(fruit) != 0) {
				System.out.println("______________________________________________________");
				System.out.println("|                     Fruit Add                      |");
				System.out.println("|____________________________________________________|");
				new AddArticleGUI();
			} else {
				System.out.println("______________________________________________________");
				System.out.println("|          System hors service try later             |");
				System.out.println("|____________________________________________________|");
				new AddArticleGUI();
			}
			break;
		}
		case 5: {
			int ratingConsommationTV;
			int resolutionTV;
			IServiceTv iServiceTv = new ServiceTvImpl();
			Tv tv;
			do {
				do {
					System.out.print("libelle (String) :");
					libelle = sc.next();
				} while (libelle.equals(""));
				do {
					System.out.print("Prix Unitaire (double != 0.0) :");
					prixUnitaire = sc.nextDouble();
				} while (prixUnitaire == 0.0);
				do {
					System.out.print("Quantite (int != 0) :");
					quantite = sc.nextInt();
				} while (quantite == 0);
				do {
					System.out.print("Fournisseur (String) :");
					fournisseur = sc.next();
				} while (fournisseur.equals(""));

				do {
					System.out.print("ratingConsommation (int != 0) :");
					ratingConsommationTV = sc.nextInt();
				} while (ratingConsommationTV == 0);
				do {
					System.out.print("resolution (int != 0) :");
					resolutionTV = sc.nextInt();
				} while (resolutionTV == 0);
				tv = new Tv(libelle, prixUnitaire, quantite, fournisseur, ratingConsommationTV, resolutionTV);
				System.out.println(tv);
				System.out.println("You confirme ?? (Y/N) ");
				validation = sc.next();
			} while (!validation.toUpperCase().equals("Y"));
			if (iServiceTv.create(tv) != 0) {
				System.out.println("______________________________________________________");
				System.out.println("|                      TV Add                        |");
				System.out.println("|____________________________________________________|");
				new AddArticleGUI();
			} else {
				System.out.println("______________________________________________________");
				System.out.println("|          System hors service try later             |");
				System.out.println("|____________________________________________________|");
				new AddArticleGUI();
			}
			break;
		}
		case 6:{
			String validation = "Y";
			String libelle;
			double prixUnitaire;
			int quantite;
			String fournisseur;
			int ratingConsommationFrigo;
			int capaciteFrigo;
			Frigo frigo;
			IServiceFrigo iServiceFrigo = new ServiceFrigoImpl();
			do {
				do {
					System.out.print("libelle (String) :");
					libelle = sc.next();
				} while (libelle.equals(""));
				do {
					System.out.print("Prix Unitaire (double != 0.0) :");
					prixUnitaire = sc.nextDouble();
				} while (prixUnitaire == 0.0);
				do {
					System.out.print("Quantite (int != 0) :");
					quantite = sc.nextInt();
				} while (quantite == 0);
				do {
					System.out.print("Fournisseur (String) :");
					fournisseur = sc.next();
				} while (fournisseur.equals(""));

				do {
					System.out.print("ratingConsommation (int != 0) :");
					ratingConsommationFrigo = sc.nextInt();
				} while (ratingConsommationFrigo == 0);
				do {
					System.out.print("Capacite (int != 0) :");
					capaciteFrigo = sc.nextInt();
				} while (capaciteFrigo == 0);
				frigo = new Frigo(libelle, prixUnitaire, quantite, fournisseur, ratingConsommationFrigo, capaciteFrigo);
				System.out.println(frigo);
				System.out.println("You confirme ?? (Y/N) ");
				validation = sc.next();
			}while (!validation.toUpperCase().equals("Y"));
			if (iServiceFrigo.create(frigo) != 0) {
				System.out.println("______________________________________________________");
				System.out.println("|                      TV Add                        |");
				System.out.println("|____________________________________________________|");
				new AddArticleGUI();
			} else {
				System.out.println("______________________________________________________");
				System.out.println("|          System hors service try later             |");
				System.out.println("|____________________________________________________|");
				new AddArticleGUI();
			}
			break;
		}
		case 7: {
			String[] args = null;
			new MainMenu().main(args);
			break;
		}
		default:
			break;

		}

	}


}
