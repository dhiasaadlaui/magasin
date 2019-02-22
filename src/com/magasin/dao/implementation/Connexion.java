package com.magasin.dao.implementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
	private String url = "jdbc:mysql://localhost:3306/magasin";
	private String username = "root";
	private String password = "";
	private static Connexion instance = null;
	private Connection cn;

	public static Connexion getInstance() {
		if (instance == null) {
			synchronized (Connexion.class) {
				if (instance == null) {
					instance = new Connexion();
					System.out.println("Connected !!!!!!!!!!!!!!!!");
				}
			}

		}
//		else
//		{
//			System.out.println("already connected !!!!!!!!!!!!!!!!");
//		}
//		

		return instance;
	}

	private Connexion() {

	}

	public Connection connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			cn = DriverManager.getConnection(url, username, password);
			// System.out.println("Connected");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return cn;
	}

	public void disconnect() {
		try {
			if (cn != null)
				cn.close();
		} catch (Exception e) {
		}
	}
}