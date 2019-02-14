package com.magasin.dao.implementation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.magasin.dao.interfaces.IFrigoDao;
import com.magasin.dao.interfaces.IPullDao;
import com.magasin.entities.Frigo;
import com.magasin.entities.Frigo;
import com.mysql.jdbc.EscapeTokenizer;

public class FrigoDaoImpl extends GenericDaoImpl implements IFrigoDao {
	
	@Override
	public Frigo findById(int id) {
		
		Frigo frigo=null;
		query="SELECT * FROM frigo where id="+id;
	try {
		smt = cnx.connect().createStatement();
		rs = smt.executeQuery(query);
		while(rs.next()) {
			frigo = new Frigo();
			frigo.setId(rs.getInt("id"));
			frigo.setLibelle(rs.getString("libelle"));
			frigo.setFournisseur(rs.getString("fournisseur"));
			frigo.setPrixUnitaire(rs.getDouble("prixunitaire"));
			frigo.setRatingConsommation(rs.getInt("ratingConsommation"));	
			frigo.setCapacite(rs.getInt("capacite"));	
			frigo.setQuantite(rs.getInt("quantite"));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		// TODO Auto-generated method stub
		return frigo;

	}

	@Override
	public List<Frigo> findAll() {
		List<Frigo> allFrigo = new ArrayList<>();
		Frigo frigo;
		query="SELECT * FROM frigo";
	try {
		smt = cnx.connect().createStatement();
		rs = smt.executeQuery(query);
		while(rs.next()) {
			frigo = new Frigo();
			frigo.setId(rs.getInt("id"));
			frigo.setLibelle(rs.getString("libelle"));
			frigo.setFournisseur(rs.getString("fournisseur"));
			frigo.setPrixUnitaire(rs.getDouble("prixunitaire"));
			frigo.setCapacite(rs.getInt("capacite"));
			frigo.setRatingConsommation(rs.getInt("ratingConsommation"));
			frigo.setQuantite(rs.getInt("quantite"));	
			
			allFrigo.add(frigo);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		// TODO Auto-generated method stub
		return allFrigo;
	}

	@Override
	public int create(Frigo entite) {
		
		int rowInserted = 0;
		query = "INSERT INTO frigo"
				+ " (libelle, prixunitaire,quantite,fournisseur,capacite,ratingConsommation)"
				+ " VALUES ( ?,?,?,?,?,?)";
		
		try {
			psmt = cnx.connect().prepareStatement(query);
			psmt.setString(1, entite.getLibelle());
			psmt.setDouble(2, entite.getPrixUnitaire());
			psmt.setInt(3, entite.getQuantite());
			psmt.setString(4, entite.getFournisseur());
			psmt.setInt(5,entite.getCapacite() );
			psmt.setInt(6,entite.getRatingConsommation());
			
			rowInserted = psmt.executeUpdate();		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		return rowInserted;
	}

	@Override
	public int edit(Frigo entite) {
		int editRows=0;
		if (entite!= null)
		{String query="UPDATE frigo SET libelle=?,prixunitaire=?,quantite=?,fournisseur=?,capacite=?,ratingconsommation=? WHERE id=?";
	
       try{
    	 
    	   psmt = cnx.connect().prepareStatement(query);
    	   psmt.setString(1, entite.getLibelle());
    	   psmt.setDouble(2, entite.getPrixUnitaire());
    	   psmt.setInt(3, entite.getQuantite());
    	   psmt.setString(4, entite.getFournisseur());
    	   psmt.setInt(5, entite.getCapacite());
    	  
    	   psmt.setInt(6, entite.getRatingConsommation());
    	   psmt.setInt(7, entite.getId());
    	  
    	  
    	    psmt.executeUpdate();
    	 //  System.out.println("\n"+psmt.getUpdateCount());
       }catch (SQLException e)
       {
    	   e.getMessage();
       }
		}
		return editRows;
	}

	@Override
	public int delete(Frigo entite) {
		// TODO Auto-generated method stub
		int deleteRows= 0;
		if (entite!= null)
		{String guery = "delete  from Frigo where id= "+entite.getId()+";";
		try{
			
			smt = cnx.connect().createStatement();
			smt.executeUpdate(guery);
		}catch(SQLException e)
		{
			e.getMessage();
		}}
		return deleteRows;
	}

	@Override
	public ArrayList<Frigo> rechercherParCapacite(int capacite) {
		List<Frigo> allFrigo = new ArrayList<>();
		Frigo frigo;
		query="SELECT * FROM frigo where capacite="+capacite;
	try {
		smt = cnx.connect().createStatement();
		rs = smt.executeQuery(query);
		while(rs.next()) {
			frigo = new Frigo();
			frigo.setId(rs.getInt("id"));
			frigo.setLibelle(rs.getString("libelle"));
			frigo.setFournisseur(rs.getString("fournisseur"));
			frigo.setPrixUnitaire(rs.getDouble("prixunitaire"));
			frigo.setCapacite(rs.getInt("capacite"));
			frigo.setRatingConsommation(rs.getInt("ratingConsommation"));
			frigo.setQuantite(rs.getInt("quantite"));	
			
			allFrigo.add(frigo);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		// TODO Auto-generated method stub
		return (ArrayList<Frigo>) allFrigo;
	}

	@Override
	public ArrayList<Frigo> rechercherParRationCons(int ratingCon) {
		List<Frigo> allFrigo = new ArrayList<>();
		Frigo frigo;
		query="SELECT * FROM frigo where ratingconsommation="+ratingCon;
	try {
		smt = cnx.connect().createStatement();
		rs = smt.executeQuery(query);
		while(rs.next()) {
			frigo = new Frigo();
			frigo.setId(rs.getInt("id"));
			frigo.setLibelle(rs.getString("libelle"));
			frigo.setFournisseur(rs.getString("fournisseur"));
			frigo.setPrixUnitaire(rs.getDouble("prixunitaire"));
			frigo.setCapacite(rs.getInt("capacite"));	
			frigo.setRatingConsommation(rs.getInt("ratingconsommation"));
			frigo.setQuantite(rs.getInt("quantite"));	
			
			allFrigo.add(frigo);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		// TODO Auto-generated method stub
		return (ArrayList<Frigo>) allFrigo;
	}


}
