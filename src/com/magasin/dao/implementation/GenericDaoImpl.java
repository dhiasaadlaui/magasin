package com.magasin.dao.implementation;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.magasin.dao.Connexion;

public class GenericDaoImpl {

	
	
protected	Statement smt = null;
protected	PreparedStatement psmt = null;
protected	ResultSet rs = null;
protected	Connexion cnx = Connexion.getInstance();
protected	String query ;
	
	
	public GenericDaoImpl() {
		// TODO Auto-generated constructor stub
	}

}
