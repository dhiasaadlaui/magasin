package com.magasin.dao.implementation;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.magasin.dao.interfaces.IPullDao;
import com.magasin.entities.Pull;

public class PullDaoImpl extends GenericDaoImpl implements IPullDao {

	public PullDaoImpl() {
	}

	@Override
	public Pull findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pull> findAll() {
		List<Pull> allPull = new ArrayList<>();
		Pull pull;
		query="SELECT * FROM pull";
	try {
		smt = cnx.connect().createStatement();
		rs = smt.executeQuery(query);
		while(rs.next()) {
			pull = new Pull();
			pull.setId(rs.getInt("id"));
			pull.setLibelle(rs.getString("libelle"));
			pull.setFournisseur(rs.getString("fournisseur"));
			pull.setPrixUnitaire(rs.getDouble("prixunitaire"));
			pull.setTaille(rs.getString("taille"));
			pull.setType(rs.getString("type"));
			pull.setMarque(rs.getString("marque"));
			pull.setGenre(rs.getString("genre"));
			pull.setQuantite(rs.getInt("quantite"));	
			pull.setCouleur(rs.getString("couleur"));
			allPull.add(pull);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		// TODO Auto-generated method stub
		return allPull;
	}

	@Override
	public int create(Pull entite) {
		
		int rowInserted = 0;
		query = "INSERT INTO pull"
				+ " (libelle, prixunitaire,quantite,fournisseur,couleur,marque,genre,"
				+ "taille,type)"
				+ " VALUES ( ?,?,?,?,?,?,?,?,?)";
		
		try {
			psmt = cnx.connect().prepareStatement(query);
			psmt.setString(1, entite.getLibelle());
			psmt.setDouble(2, entite.getPrixUnitaire());
			psmt.setInt(3, entite.getQuantite());
			psmt.setString(4, entite.getFournisseur());
			psmt.setString(5,entite.getCouleur() );
			psmt.setString(6,entite.getMarque());
			psmt.setString(7, entite.getGenre());
			psmt.setString(8, entite.getTaille());
			psmt.setString(9, entite.getType());
			rowInserted = psmt.executeUpdate();		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		return rowInserted;
	}

	@Override
	public int edit(Pull entite) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Pull entite) {
		// TODO Auto-generated method stub
		return 00;
	}

	@Override
	public List<Pull> rechercherParTaille(String taille) {
		// TODO Auto-generated method stub
		return null;
	}

}
