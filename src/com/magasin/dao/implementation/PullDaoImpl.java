package com.magasin.dao.implementation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.magasin.dao.interfaces.IPullDao;
import com.magasin.entities.Pull;

public class PullDaoImpl extends GenericDaoImpl implements IPullDao {
	public PullDaoImpl() {
	}

	@Override
	public Pull findById(int id) {
		
		Pull pull=null;
	
	try {	
		rs =cnx.getResult("SELECT * FROM pull where id="+id);
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
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		// TODO Auto-generated method stub
		return pull;

	}

	@Override
	public List<Pull> findAll() {
		List<Pull> allPull = new ArrayList<>();
		Pull pull;

	try {
		rs=cnx.getResult("SELECT * FROM pull");
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
		int rowUpdated = 0;				
		try{
			query = "UPDATE pull SET "
					+ " libelle=?, prixunitaire=?,quantite=?,fournisseur=?,couleur=?,marque=?,genre=?,taille=?,type=? "
					+"WHERE id = ?";
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
			psmt.setInt(10, entite.getId());
			rowUpdated = psmt.executeUpdate();
            if (rowUpdated > 0) {
                System.out.println("A pull was updated successfully!");
            }
					
		}catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Erreur !!!");

        }
		
		
		return 0;
	}

	@Override
	public int delete(Pull entite) {
		// TODO Auto-generated method stub
        int rowsDeleted = 0;
        try {
            query = "DELETE FROM pull WHERE id=?";
            psmt = cnx.connect().prepareStatement(query);
            psmt.setInt(1, entite.getId());
            rowsDeleted = psmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A pull was deleted successfully!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Erreur !!!!");

        }
        return rowsDeleted;
		
	}

	@Override
	public List<Pull> rechercherParTaille(String taille) {
		// TODO Auto-generated method stub
		Pull pull=null;
		List<Pull> allPull = new ArrayList<>();
		query="SELECT * FROM pull where taille="+"\'"+taille+"\'";
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
		return allPull;
	}

}
