package com.magasin.dao;

import java.util.List;

import com.magasin.dao.implementation.PullDaoImpl;
import com.magasin.dao.interfaces.IPullDao;
import com.magasin.entities.Pull;

public class TestDao {



	public static void main(String[] args) {
		// TODO Auto-generated method stub


		IPullDao dao = new PullDaoImpl();
		
//		List<Pull> allPull = dao.findAll();
//		
//		for(Pull pull : allPull) {
//			System.out.println(pull);
//		}
		
		Pull pl = new Pull("test", 0.0d, 55, "salah fripe", "dark", "lenovo", "doublepus", "M", "typetest");
		System.out.println(dao.create(pl));
				
//		allPull = dao.findAll();
//		for(Pull pull : allPull) {
//			System.out.println(pull);
//		}
		
	}

}
