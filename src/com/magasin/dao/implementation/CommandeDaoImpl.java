package com.magasin.dao.implementation;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.magasin.dao.interfaces.*;
import com.magasin.entities.Commande;
import com.magasin.entities.LigneCommande;
import com.mysql.jdbc.Statement;

public class CommandeDaoImpl extends GenericDaoImpl implements ICommandeDao{

		private LigneCommandeDaoImpl ligneCommandeDao = new LigneCommandeDaoImpl();
		
		
		
	public CommandeDaoImpl() {
			super();
			ligneCommandeDao = new LigneCommandeDaoImpl();
		
	}


	private Commande fetchCommand(ResultSet rs) {
		try {
			Commande cmd = new Commande();
			cmd.setId(rs.getInt("id"));
			cmd.setDateCmd(rs.getDate("datecmd"));
			cmd.setStatutCmd(rs.getString("statutcmd"));
			// Find all the Lignes with this command
			List<LigneCommande> allLignesCommande = this.ligneCommandeDao.findByCmd(cmd.getId());
			cmd.setLignesCommande(allLignesCommande);
			return cmd;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	@Override
	public Commande findById(int id) {
		Commande commande = null;
		query="SELECT * FROM commande where id="+id;
		
		try {
			smt = cnx.connect().createStatement();
			rs = smt.executeQuery(query);
			
			while(rs.next()) {
				commande = fetchCommand(rs);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return commande;
	}

	@Override
	public List<Commande> findAll() {
		List<Commande> commandes = new ArrayList<Commande>();
		query = "Select * from commande";
		
		try {
			smt = cnx.connect().createStatement();
			rs = smt.executeQuery(query);
			
			// for each command returned
			while(rs.next()) {
				// Create a new Commande
				Commande cmd = fetchCommand(rs);
				commandes.add(cmd);
			}
			
			
			
			return commandes;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public int create(Commande entite) {
		int rowInserted = 0;
		query = "INSERT INTO commande (datecmd, statutcmd) Values (?, ?)";
		
		try {
			psmt = cnx.connect().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			psmt.setDate(1,new java.sql.Date(entite.getDateCmd().getTime()));
			psmt.setString(2, entite.getStatutCmd());
			rowInserted = psmt.executeUpdate();
			ResultSet rs = psmt.getGeneratedKeys(); // Get back the key
			rs.next();
			entite.setId(rs.getInt(1));
			
			// for each ligenCommand in command
			for(LigneCommande lcd : entite.getLignesCommande()) {
				lcd.setCommande(entite);
				// add the ligne to the database
				this.ligneCommandeDao.create(lcd);
				
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rowInserted;
	}

	
	
	
	@Override
	public int edit(Commande entite) {
		int rowEdited = 0;
		query = "update commande set datecmd = ?, statutcmd = ? where id = ?";
		
		
		try {
			psmt = cnx.connect().prepareStatement(query);
			psmt.setDate(1, new java.sql.Date(entite.getDateCmd().getTime()));
			psmt.setString(2, entite.getStatutCmd());
			psmt.setInt(3, entite.getId());
			rowEdited = psmt.executeUpdate();
			
			// delete all related lignes 
			for(LigneCommande lcd : entite.getLignesCommande()) {
				this.ligneCommandeDao.delete(lcd);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rowEdited;
	}

	@Override
	public int delete(Commande entite) {
		int rowDeleted = 0;
		query = "DELETE FROM commande WHERE id = " + entite.getId();
		try {
			psmt = cnx.connect().prepareStatement(query);
			rowDeleted = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowDeleted;
	}


	@Override
	public List<Commande> findByDate(java.util.Date date) {
		List<Commande> commandes = new ArrayList<Commande>();
		query="SELECT * FROM commande where datecmd = ?";
		
		try {
			psmt = cnx.connect().prepareStatement(query);
			psmt.setDate(1,new java.sql.Date(date.getTime()) );;
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				Commande cmd = fetchCommand(rs);
				commandes.add(cmd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return commandes;
	}


	@Override
	public List<Commande> findByStatut(String statut) {
		// TODO Auto-generated method stub
		List<Commande> commandes = new ArrayList<Commande>();
		query="SELECT * FROM commande where statutcmd like ?" ;
		
		try {
			psmt = cnx.connect().prepareStatement(query);
			psmt.setString(1, statut);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				Commande cmd = fetchCommand(rs);
				commandes.add(cmd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return commandes;
	}
	
	
	@Override
	public List<Commande> findBeforeDate(java.util.Date date){
		List<Commande> commandes = new ArrayList<Commande>();
		query="SELECT * FROM commande where datecmd < ?";
		
		try {
			psmt = cnx.connect().prepareStatement(query);
			psmt.setDate(1,new java.sql.Date(date.getTime()));
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				Commande cmd = fetchCommand(rs);
				commandes.add(cmd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return commandes;
	}
	
	@Override
	public List<Commande> findAfterDate(java.util.Date date){
		List<Commande> commandes = new ArrayList<Commande>();
		query="SELECT * FROM commande where datecmd >= ?";
		
		try {
			psmt = cnx.connect().prepareStatement(query);
			psmt.setDate(1,new java.sql.Date(date.getTime()));;
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				Commande cmd = fetchCommand(rs);
				commandes.add(cmd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return commandes;
	}
	

}
