//package tests;
//
//import java.util.Collection;
//import java.util.Iterator;
//import java.util.List;
//import java.util.ListIterator;
//
//import com.magasin.entities.Article;
//import com.magasin.entities.Commande;
//import com.magasin.entities.LigneCommande;
//import com.magasin.service.implementation.ServiceArticleImpl;
//import com.magasin.service.implementation.ServiceCommandeImpl;
//import com.magasin.service.interfaces.IServiceArticle;
//import com.magasin.service.interfaces.IServiceArticle.ArticleTypes;
//import com.magasin.service.interfaces.IServiceCommande;
//
//public class TestServices {
//
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		IServiceArticle serviceArticle = new ServiceArticleImpl();
//		IServiceCommande serviceCommande = new ServiceCommandeImpl();
//
//		for ( Commande cmd12 : serviceCommande.findAll()) {
//			System.out.println(cmd12);
//		}
//		System.out.println("---------------------------");
//		
//		
////		Commande cmd = new Commande();
////		LigneCommande ln = new LigneCommande(serviceArticle.findById(ArticleTypes.CHAUSSURE, 2), cmd, 5);
////		cmd.getLignesCommande().add(ln);
////		serviceCommande.create(cmd);
//		
//		for ( Commande cmd13 : serviceCommande.findAll()) {
//			System.out.println(cmd13);
//		}
//		System.out.println("-----------");
//		serviceCommande.validateCommande(serviceCommande.findById(6));
//		System.out.println("-----------");
//		System.out.println(serviceCommande.findById(6));
//		
//		
//		
//		//		for(Article art : serviceArticle.findAll()) {
////			System.out.println(art);
////		}
////		
//		
//		
//	}
//
//}
