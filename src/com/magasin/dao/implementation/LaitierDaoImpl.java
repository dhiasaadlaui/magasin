package com.magasin.dao.implementation;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.magasin.dao.interfaces.ILaitierDao;
import com.magasin.entities.Laitier;
import com.magasin.entities.Tv;

public class LaitierDaoImpl extends GenericDaoImpl implements ILaitierDao {

	
	public LaitierDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Laitier findById(int id) {
		Laitier lait = new Laitier();
		query="SELECT * FROM laitier where id = "+id;
		try {
			smt = cnx.connect().createStatement();
			rs = smt.executeQuery(query);
			rs.next(); // No while loop needed Only one result is returned 
						// from the database the id is UNIQUE;
			lait = new Laitier(rs.getInt("id"),rs.getString("libelle"),
					rs.getDouble("prixUnitaire"),rs.getInt("quantite"),
					rs.getString("fournisseur"),rs.getDate("datefab"),
					rs.getDate("dateexp"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
	 
			e.printStackTrace();
		}	

		return lait;
		//
	}

	@Override
	public List<Laitier> findAll() {
		List<Laitier> listLaitier = new ArrayList<Laitier>();
		query="SELECT * FROM laitier";
		try {
			smt = cnx.connect().createStatement();
			rs = smt.executeQuery(query);
			while(rs.next()) {
				listLaitier.add(new Laitier(rs.getInt("id"),rs.getString("libelle"),
					rs.getDouble("prixUnitaire"),rs.getInt("quantite"),
					rs.getString("fournisseur"),rs.getDate("datefab"),
					rs.getDate("dateexp"))) ;		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
	 
			e.printStackTrace();
		}
		return listLaitier;
	}

	@Override
	public int create(Laitier entite) {
		int rowInserted = 0;
		query = "INSERT INTO laitier (libelle,prixunitaire,quantite,fournisseur,datefab,dateexp)  VALUES (?,?,?,?,?,?)";
		

		try {
			psmt = cnx.connect().prepareStatement(query);
			
			psmt.setString(1, entite.getLibelle());
			psmt.setDouble(2, entite.getPrixUnitaire());
			psmt.setInt(3, entite.getQuantite());
			psmt.setString(4,entite.getFournisseur());
			psmt.setDate(5, new java.sql.Date(entite.getDateFab().getTime()));
			psmt.setDate(6, new java.sql.Date(entite.getDateExp().getTime()));
			
			rowInserted = psmt.executeUpdate();		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowInserted;
	}

	@Override
	public int edit(Laitier entite) {
		int updated = 0;
		query = "UPDATE laitier SET"
				+ " libelle=?, prixunitaire=?,quantite=?,fournisseur=?,datefab=?,dateexp=?"
				+ " WHERE id=?";
		
		try {
			psmt = cnx.connect().prepareStatement(query);
			psmt.setString(1, entite.getLibelle());
			psmt.setDouble(2, entite.getPrixUnitaire());
			psmt.setInt(3, entite.getQuantite());
			psmt.setString(4, entite.getFournisseur());
			psmt.setDate(5, new java.sql.Date(entite.getDateFab().getTime()));
			psmt.setDate(6, new java.sql.Date(entite.getDateExp().getTime()));
			
			psmt.setInt(7,entite.getId());
			updated = psmt.executeUpdate();
			if (updated>0) {
				System.out.println("A Laitier was updated successfully");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updated;
	}

	@Override
	public int delete(Laitier entite) {
		int rowDeleted = 0;
		query = "DELETE FROM Laitier WHERE id ="+entite.getId() ;
		
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
	public List<Laitier> findByDateExp(Date date) {
		List<Laitier> listLaitier = new ArrayList<Laitier>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		
		query="SELECT * FROM laitier where dateexp = '"+sdf.format(date)+"'";
		try {
			smt = cnx.connect().createStatement();
			rs = smt.executeQuery(query);
			while(rs.next()) {
				listLaitier.add(new Laitier(rs.getInt("id"),rs.getString("libelle"),
					rs.getDouble("prixUnitaire"),rs.getInt("quantite"),
					rs.getString("fournisseur"),rs.getDate("datefab"),
					rs.getDate("dateexp"))) ;		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
	 
			e.printStackTrace();
		}
		return listLaitier;
		
	}

	@Override
	public List<Laitier> findAfterDateExp(Date date) {
		List<Laitier> listLaitier = new ArrayList<Laitier>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		
		query="SELECT * FROM laitier where dateexp < '"+sdf.format(date)+"'";
		try {
			smt = cnx.connect().createStatement();
			rs = smt.executeQuery(query);
			while(rs.next()) {
				listLaitier.add(new Laitier(rs.getInt("id"),rs.getString("libelle"),
					rs.getDouble("prixUnitaire"),rs.getInt("quantite"),
					rs.getString("fournisseur"),rs.getDate("datefab"),
					rs.getDate("dateexp"))) ;		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
	 
			e.printStackTrace();
		}
		
		return listLaitier;
	}

	@Override
	public List<Laitier> findBeforeDateExp(Date date) {
		List<Laitier> listLaitier = new ArrayList<Laitier>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		
		query="SELECT * FROM laitier where dateexp > '"+sdf.format(date)+"'";
		try {
			smt = cnx.connect().createStatement();
			rs = smt.executeQuery(query);
			while(rs.next()) {
				listLaitier.add(new Laitier(rs.getInt("id"),rs.getString("libelle"),
					rs.getDouble("prixUnitaire"),rs.getInt("quantite"),
					rs.getString("fournisseur"),rs.getDate("datefab"),
					rs.getDate("dateexp"))) ;		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
	 
			e.printStackTrace();
		}
		
		return listLaitier;
	}

}
