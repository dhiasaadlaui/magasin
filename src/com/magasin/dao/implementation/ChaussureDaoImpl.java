package com.magasin.dao.implementation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.magasin.dao.interfaces.IChaussureDao;
import com.magasin.entities.Chaussure;


public class ChaussureDaoImpl extends GenericDaoImpl implements IChaussureDao {

	@Override
	public Chaussure findById(int id) {
		Chaussure chaussure =null;
		query="SELECT * FROM chaussure where id="+id;
	try {
		smt = cnx.connect().createStatement();
		rs = smt.executeQuery(query);
		while(rs.next()) {
			chaussure = new Chaussure(rs.getInt("id"),rs.getString("libelle"),rs.getDouble("prixunitaire"),rs.getInt("quantite"),rs.getString("fournisseur"),rs.getString("couleur"),rs.getString("marque"),rs.getString("genre"),rs.getInt("pointure"));
			}
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return chaussure;
		}

	@Override
	public List<Chaussure> findAll() {
		List<Chaussure> allChaussure = new ArrayList<>();
		Chaussure chaussure;
		query="SELECT * FROM chaussure";
	try {
		smt = cnx.connect().createStatement();
		rs = smt.executeQuery(query);
		while(rs.next()) {
			chaussure = new Chaussure(rs.getInt("id"),rs.getString("libelle"),rs.getDouble("prixunitaire"),rs.getInt("quantite"),rs.getString("fournisseur"),rs.getString("couleur"),rs.getString("marque"),rs.getString("genre"),rs.getInt("pointure"));
			allChaussure.add(chaussure);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return allChaussure;
	}

	@Override
	public int create(Chaussure entite) {
		int rowInserted = 0;
		query = "INSERT INTO chaussure"
				+ " (libelle, prixunitaire,quantite,fournisseur,couleur,marque,genre,"
				+ "pointure)"
				+ " VALUES ( ?,?,?,?,?,?,?,?)";
		try {
			psmt = cnx.connect().prepareStatement(query);
			psmt.setString(1, entite.getLibelle());
			psmt.setDouble(2, entite.getPrixUnitaire());
			psmt.setInt(3, entite.getQuantite());
			psmt.setString(4, entite.getFournisseur());
			psmt.setString(5,entite.getCouleur() );
			psmt.setString(6,entite.getMarque());
			psmt.setString(7, entite.getGenre());
			psmt.setInt(8, entite.getPointure());
			rowInserted = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowInserted;
	}

	@Override
	public int edit(Chaussure entite) {
		int rowUpdated = 0;
		query="UPDATE chaussure SET libelle = ?, prixunitaire = ?, quantite = ?, fournisseur= ?,"
				+ "couleur= ?, marque=?, genre= ?, pointure= ?  WHERE id = "+entite.getId();
	try {
		psmt = cnx.connect().prepareStatement(query);
		psmt.setString(1, entite.getLibelle());
		psmt.setDouble(2, entite.getPrixUnitaire());
		psmt.setInt(3, entite.getQuantite());
		psmt.setString(4, entite.getFournisseur());
		psmt.setString(5,entite.getCouleur() );
		psmt.setString(6,entite.getMarque());
		psmt.setString(7, entite.getGenre());
		psmt.setInt(8, entite.getPointure());
		rowUpdated = psmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return rowUpdated;
	}

	@Override
	public int delete(Chaussure entite) {
		int rowDeleted = 0;
		query="DELETE FROM chaussure WHERE id="+entite.getId();
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
	//return list Chaussures qui ont la meme pointure
	public List<Chaussure> rechercherParPointure(int pointure) {
		List<Chaussure> allChaussure = new ArrayList<>();
		Chaussure chaussure;
		query="SELECT * FROM chaussure WHERE pointure = "+pointure;
	try {
		smt = cnx.connect().createStatement();
		rs = smt.executeQuery(query);
		while(rs.next()) {
			chaussure = new Chaussure(rs.getInt("id"),rs.getString("libelle"),rs.getDouble("prixunitaire"),rs.getInt("quantite"),rs.getString("fournisseur"),rs.getString("couleur"),rs.getString("marque"),rs.getString("genre"),rs.getInt("pointure"));
			allChaussure.add(chaussure);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return allChaussure;
	}

	@Override
	//return list Chaussures qui ont la meme couleur
	public List<Chaussure> rechercherParCouleur(String couleur) {
		List<Chaussure> allChaussure = new ArrayList<>();
		Chaussure chaussure;
		query="SELECT * FROM chaussure WHERE couleur = \'"+couleur+"\'";
	try {
		smt = cnx.connect().createStatement();
		rs = smt.executeQuery(query);
		while(rs.next()) {
			chaussure = new Chaussure(rs.getInt("id"),rs.getString("libelle"),rs.getDouble("prixunitaire"),rs.getInt("quantite"),rs.getString("fournisseur"),rs.getString("couleur"),rs.getString("marque"),rs.getString("genre"),rs.getInt("pointure"));
			allChaussure.add(chaussure);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return allChaussure;
	}

	@Override
	//return list Chaussures qui ont la meme marque
	public List<Chaussure> rechercherParMarque(String marque) {
		List<Chaussure> allChaussure = new ArrayList<>();
		Chaussure chaussure;
		query="SELECT * FROM chaussure WHERE marque = \'"+marque+"\'";
	try {
		smt = cnx.connect().createStatement();
		rs = smt.executeQuery(query);
		while(rs.next()) {
			chaussure = new Chaussure(rs.getInt("id"),rs.getString("libelle"),rs.getDouble("prixunitaire"),rs.getInt("quantite"),rs.getString("fournisseur"),rs.getString("couleur"),rs.getString("marque"),rs.getString("genre"),rs.getInt("pointure"));
			allChaussure.add(chaussure);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return allChaussure;
	}

	@Override
	//return list Chaussures qui ont la meme genre
	public List<Chaussure> rechercherParGenre(String genre) {
		List<Chaussure> allChaussure = new ArrayList<>();
		Chaussure chaussure;
		query="SELECT * FROM chaussure WHERE genre = \'"+genre+"\'";
	try {
		smt = cnx.connect().createStatement();
		rs = smt.executeQuery(query);
		while(rs.next()) {
			chaussure = new Chaussure(rs.getInt("id"),rs.getString("libelle"),rs.getDouble("prixunitaire"),rs.getInt("quantite"),rs.getString("fournisseur"),rs.getString("couleur"),rs.getString("marque"),rs.getString("genre"),rs.getInt("pointure"));
			allChaussure.add(chaussure);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return allChaussure;
	}

}
