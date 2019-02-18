package com.magasin.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.magasin.dao.implementation.ChaussureDaoImpl;
import com.magasin.dao.implementation.CommandeDaoImpl;
import com.magasin.dao.implementation.FrigoDaoImpl;
import com.magasin.dao.implementation.FruitDaoImpl;
import com.magasin.dao.implementation.PullDaoImpl;
import com.magasin.dao.implementation.TvDaoImpl;
import com.magasin.dao.interfaces.IChaussureDao;
import com.magasin.dao.interfaces.ICommandeDao;
import com.magasin.dao.interfaces.IFrigoDao;
import com.magasin.dao.interfaces.IFruitDao;
import com.magasin.dao.interfaces.IPullDao;
import com.magasin.dao.interfaces.ITvDao;
import com.magasin.entities.Chaussure;
import com.magasin.entities.Commande;
import com.magasin.entities.Frigo;
import com.magasin.entities.Fruit;
import com.magasin.entities.Pull;
import com.magasin.entities.Tv;

public class TestDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IPullDao daopull = new PullDaoImpl();
		ICommandeDao daocmd = new CommandeDaoImpl();
		IChaussureDao daochaussure = new ChaussureDaoImpl();
		IFrigoDao daofrigo = new FrigoDaoImpl();
		IFruitDao daofruit = new FruitDaoImpl();
		ITvDao daotv = new TvDaoImpl();
		
		
// ----------------TV dao TEST --------------------------
//		Tv tv = new Tv("TVoNE", 850d, 300, "Samsung", 4, 30);
//		Tv tv1 = new Tv("TVtWO", 1050d, 150, "Sony", 5, 40);
//		Tv tv2= new Tv("TVThree", 2500d, 100, "LG", 6, 80);
//		
//		daotv.create(tv);
//		daotv.create(tv1);
//		daotv.create(tv2);
//	System.out.println("all tvs");	
//		for (Tv entitie : daotv.findAll()) {
//			System.out.println(entitie);
//		}
//		
//		System.out.println("resolution tv 40 :"+ daotv.rechercherParResolution(40));
		System.out.println("finding by id 2"+ daotv.findById(2));
		
		Tv tv2=daotv.findById(2);
		System.out.println(daotv.delete(tv2));
		System.out.println(daotv.delete(tv2));
		
// ----------------- Fruit dao TEST --------------------

//		System.out.println(daofruit.rechercherParSaision("été"));
//		
		//		Fruit fruit = daofruit.findById(2);
//		fruit.setPrixUnitaire(2100);	
//		System.out.println(daofruit.edit(fruit));
//		
		
		
// ----------------- Frigo dao TEST --------------------

		
		
		
//		System.out.println(daofrigo.findById(2));
//
//Frigo fr = daofrigo.findById(2);
//fr.setQuantite(20000);
//fr.setFournisseur("Alger");
//fr.setLibelle("Testedit");		
//System.out.println(daofrigo.edit(fr));
//System.out.println(daofrigo.findById(2));
//		
//		
		
		
//		for(Frigo fr : daofrigo.findAll()) {
//			System.out.println(fr);
//		}

//		
//Frigo fr = new Frigo("Airwell",1300.5, 50, "Carrefour", 1, 11);
//System.out.println(fr);
//System.out.println(daofrigo.create(fr));
		
		
		
		
// ----------------- Chaussure dao TEST --------------------
		
		
	//Chaussure ch = new Chaussure("Adidas 3 bondes", 90d, 120, "Mehrez fripe", "rose", "Adidas", "Femme", 38);
		
//	System.out.println(daochaussure.rechercherParPointure(38));	
		
	
		
// ----------------- Commande dao TEST --------------------

		// List<Commande> cds = daocmd.findByStatut("confirmed");
//		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		
//		try {
//			Date datetest = sdf.parse("2019-02-14");
//		
//		
//		for(Commande cmd : daocmd.findByDate(datetest))
//		{
//	System.out.println(cmd);
//		}
//		
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		

		// System.out.println(dao.findById(2));
//--------------------- pull dao test --------------------------
//		List<Pull> allPull = dao.findAll();
//		
//		for(Pull pull : allPull) {
//			System.out.println(pull);
//		}
//		
//		Pull pl = new Pull("test", 0.0d, 55, "salah fripe", "dark", "lenovo", "doublepus", "M", "typetest");
//		System.out.println(dao.create(pl));
//				
//		allPull = dao.findAll();
//		for(Pull pull : allPull) {
//			System.out.println(pull);
//		}

	}

}
