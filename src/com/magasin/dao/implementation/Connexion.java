package com.magasin.dao.implementation;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;
/*
 * 
 */
public class Connexion {
	
	private static final Logger LOGGER = Logger.getLogger(Connexion.class.getName());
	private String url;
	private String username;
	private String password;
	private String driver;
	private static Connexion instance = null;
	private Connection cn;
	public static Connexion getInstance() {
		if (instance == null) {
			synchronized (Connexion.class) {
				if (instance == null)
					instance = new Connexion();
			}

		}

		return instance;
	}

	private Connexion() {
		try {

			FileInputStream fis = new FileInputStream(".\\src\\connection.properties");
			Properties p = new Properties();
			p.load(fis);
			url = (String) p.get("url");
			username = (String) p.get("user");
			password = (String) p.get("password");
			driver = (String) p.get("driver");
			LOGGER.info("The class ("+LOGGER.getName()+") attempting to connect database ..");
			
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
	}

	public Connection connect() {
		try {
			Class.forName(driver);
			
			cn = DriverManager.getConnection(url, username, password);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			LOGGER.warning("The class ("+LOGGER.getName()+") failed to connected  database ..");			
			
		}
		return cn;
	}

	
	public ResultSet getResult(String query) throws SQLException {
		
		return getInstance().connect().createStatement().executeQuery(query);
	}
	
	
	
	public void disconnect() {
		try {
			if (cn != null)
				cn.close();
		} catch (Exception e) {
		}
	}
}