package com.magasin.dao.implementation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.magasin.dao.interfaces.IFruitDao;
import com.magasin.entities.Fruit;

public class FruitDaoImpl extends GenericDaoImpl implements IFruitDao{
	
	 public FruitDaoImpl() {}
	 
     public Fruit findById(int id)  {
		Fruit fruit = null;
		 query ="SELECT * FROM fruit WHERE id ="+id;
	try {
		smt = cnx.connect().createStatement();
		rs = smt.executeQuery(query);
		while(rs.next()) {
			fruit = new Fruit();
			fruit.setId(rs.getInt("id"));
			fruit.setLibelle(rs.getString("libelle"));
			fruit.setPrixUnitaire(rs.getDouble("prixunitaire"));
			fruit.setFournisseur(rs.getString("fournisseur"));
			fruit.setSaison(rs.getString("saison"));
			fruit.setQuantite(rs.getInt("quantite"));
			
					}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		// TODO Auto-generated method stub
		return fruit;
	}

	@Override
	public List<Fruit> findAll() {
		List<Fruit> allFruit = new ArrayList<>();
		Fruit fruit;
		query="SELECT * FROM fruit";
	try {
		smt = cnx.connect().createStatement();
		rs = smt.executeQuery(query);
		while(rs.next()) {
			fruit = new Fruit();
			fruit.setId(rs.getInt("id"));
			fruit.setLibelle(rs.getString("libelle"));
			fruit.setPrixUnitaire(rs.getDouble("prixunitaire"));
			fruit.setFournisseur(rs.getString("fournisseur"));
			fruit.setSaison(rs.getString("saison"));
			fruit.setQuantite(rs.getInt("quantite"));
			
			allFruit.add(fruit);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		// TODO Auto-generated method stub
		return allFruit;
	}
	@Override
	public int create(Fruit entite) {
		int rowInserted = 0;
		query = "INSERT INTO fruit"
				+ "(libelle,prixunitaire,quantite,fournisseur,saison)"
				+ "VALUES (?,?,?,?,?)";
		
		try {
			psmt = cnx.connect().prepareStatement(query);
			psmt.setString(1, entite.getLibelle());
			psmt.setDouble(2, entite.getPrixUnitaire());
			psmt.setInt(3, entite.getQuantite());
			psmt.setString(4, entite.getFournisseur());
			psmt.setString(5,entite.getSaison() );
			
			rowInserted = psmt.executeUpdate();		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		return rowInserted;
	}

	@Override
	public int edit(Fruit entite) {
		// TODO Auto-generated method stub
		
		int rowUpdated = 0;
		query = "UPDATE fruit SET libelle = ? , prixunitaire = ?, quantite = ? , fournisseur = ? , saison = ?  WHERE id =  ?";
		try {
			psmt = cnx.connect().prepareStatement(query);
			psmt.setString(1, entite.getLibelle());
			psmt.setDouble(2, entite.getPrixUnitaire());
			psmt.setInt(3, entite.getQuantite());
			psmt.setString(4, entite.getFournisseur());
			psmt.setString(5,entite.getSaison() );
			psmt.setInt(6,entite.getId() );
			
			
			rowUpdated = psmt.executeUpdate();		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return rowUpdated;
	}

	@Override
	public int delete(Fruit entite) {
		int rowDeleted = 0;
		query = "DELETE FROM fruit WHERE id ="+entite.getId() ;
		
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
	public List<Fruit> rechercherParSaision(String saison) {
		List<Fruit> allFruit = new ArrayList<>();
		Fruit fruit ;
		 query ="SELECT * FROM fruit WHERE saison = \'"+saison+"\'";
	try {
		smt = cnx.connect().createStatement();
		rs = smt.executeQuery(query);
		while(rs.next()) {
			fruit = new Fruit();
			fruit.setId(rs.getInt("id"));
			fruit.setLibelle(rs.getString("libelle"));
			fruit.setPrixUnitaire(rs.getDouble("prixunitaire"));
			fruit.setFournisseur(rs.getString("fournisseur"));
			fruit.setSaison(rs.getString("saison"));
			fruit.setQuantite(rs.getInt("quantite"));
			allFruit.add(fruit);
					}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		// TODO Auto-generated method stub
		return allFruit;
		
	}
	}
		
		
	
