package com.magasin.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.magasin.dao.implementation.ChaussureDaoImpl;
import com.magasin.dao.implementation.CommandeDaoImpl;
import com.magasin.dao.implementation.FrigoDaoImpl;
import com.magasin.dao.implementation.PullDaoImpl;
import com.magasin.dao.interfaces.IChaussureDao;
import com.magasin.dao.interfaces.ICommandeDao;
import com.magasin.dao.interfaces.IFrigoDao;
import com.magasin.dao.interfaces.IPullDao;
import com.magasin.entities.Chaussure;
import com.magasin.entities.Commande;
import com.magasin.entities.Frigo;
import com.magasin.entities.Pull;

public class TestDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IPullDao daopull = new PullDaoImpl();
		ICommandeDao daocmd = new CommandeDaoImpl();
		IChaussureDao daochaussure = new ChaussureDaoImpl();
		IFrigoDao daofrigo = new FrigoDaoImpl();
		
		
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
