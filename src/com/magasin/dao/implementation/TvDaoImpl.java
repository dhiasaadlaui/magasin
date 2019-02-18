package com.magasin.dao.implementation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.magasin.dao.interfaces.ITvDao;
import com.magasin.entities.Tv;

public class TvDaoImpl extends GenericDaoImpl implements ITvDao{
	
	public TvDaoImpl() {

	}

	@Override
	public Tv findById(int id) {
		Tv tv = null;
		query="SELECT * FROM tv WHERE id="+id;
		try {
			smt = cnx.connect().createStatement();
			rs = smt.executeQuery(query);
			while(rs.next()) {
				tv = new Tv();
				tv.setId(rs.getInt("id"));
				tv.setLibelle(rs.getString("libelle"));
				tv.setFournisseur(rs.getString("fournisseur"));
				tv.setPrixUnitaire(rs.getDouble("prixunitaire"));
				tv.setQuantite(rs.getInt("quantite"));
				tv.setRatingConsommation(rs.getInt("ratingconsommation"));
				tv.setResolution(rs.getInt("resolution"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tv;
	}

	@Override
	public List<Tv> findAll() {
		List<Tv> allTv = new ArrayList<>();
		Tv tv;
		query="SELECT * FROM tv";
	try {
		smt = cnx.connect().createStatement();
		rs = smt.executeQuery(query);
		while(rs.next()) {
			tv = new Tv();
			tv.setId(rs.getInt("id"));
			tv.setLibelle(rs.getString("libelle"));
			tv.setFournisseur(rs.getString("fournisseur"));
			tv.setPrixUnitaire(rs.getDouble("prixunitaire"));
			tv.setQuantite(rs.getInt("quantite"));
			tv.setRatingConsommation(rs.getInt("ratingconsommation"));
			tv.setResolution(rs.getInt("resolution"));
			allTv.add(tv);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return allTv;
	}

	@Override
	public int create(Tv entite) {
		int rowInserted = 0;
		query = "INSERT INTO tv"
				+ " (libelle, prixunitaire,quantite,fournisseur,ratingconsommation,resolution)"
				+ " VALUES ( ?,?,?,?,?,?)";
		
		try {
			psmt = cnx.connect().prepareStatement(query);
			psmt.setString(1, entite.getLibelle());
			psmt.setDouble(2, entite.getPrixUnitaire());
			psmt.setInt(3, entite.getQuantite());
			psmt.setString(4, entite.getFournisseur());
			psmt.setInt(5,entite.getRatingConsommation());
			psmt.setInt(6, entite.getResolution());
			rowInserted = psmt.executeUpdate();		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		return rowInserted;
	}

	@Override
	public int edit(Tv entite) {
		int updated = 0;
		query = "UPDATE tv SET"
				+ " libelle=?, prixunitaire=?,quantite=?,fournisseur=?,ratingconsommation=?,resolution=?"
				+ " WHERE id=?";
		
		try {
			psmt = cnx.connect().prepareStatement(query);
			psmt.setString(1, entite.getLibelle());
			psmt.setDouble(2, entite.getPrixUnitaire());
			psmt.setInt(3, entite.getQuantite());
			psmt.setString(4, entite.getFournisseur());
			psmt.setInt(5,entite.getRatingConsommation());
			psmt.setInt(6, entite.getResolution());
			psmt.setInt(7,entite.getId());
			updated = psmt.executeUpdate();
			if (updated>0) {
				System.out.println("A tv was updated successfully");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updated;
	}

	@Override
	public int delete(Tv entite) {
		int rowsDeleted = 0;
        try {
            query = "DELETE FROM tv WHERE id=?";
            psmt = cnx.connect().prepareStatement(query);
			psmt.setInt(1,entite.getId());
            rowsDeleted = psmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A tv was deleted successfully!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
		return rowsDeleted;
	}

	@Override
	public List<Tv> rechercherParResolution(int resolution) {
		Tv tv = null;
		List<Tv> allTv = new ArrayList<>();
		query="SELECT * FROM tv WHERE resolution="+resolution;
		try {
			smt = cnx.connect().createStatement();
			rs = smt.executeQuery(query);
			while(rs.next()) {
				tv = new Tv();
				tv.setId(rs.getInt("id"));
				tv.setLibelle(rs.getString("libelle"));
				tv.setFournisseur(rs.getString("fournisseur"));
				tv.setPrixUnitaire(rs.getDouble("prixunitaire"));
				tv.setQuantite(rs.getInt("quantite"));
				tv.setRatingConsommation(rs.getInt("ratingconsommation"));
				tv.setResolution(rs.getInt("resolution"));
				allTv.add(tv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allTv;
	}
	

}
