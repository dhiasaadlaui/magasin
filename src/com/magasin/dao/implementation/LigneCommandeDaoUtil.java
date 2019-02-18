package com.magasin.dao.implementation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.w3c.dom.ls.LSException;


import com.magasin.entities.Article;
import com.magasin.entities.Chaussure;
import com.magasin.entities.Commande;
import com.magasin.entities.Frigo;
import com.magasin.entities.Fruit;
import com.magasin.entities.Laitier;
import com.magasin.entities.LigneCommande;
import com.magasin.entities.Pull;
import com.magasin.entities.Tv;

 class LigneCommandeDaoUtil extends GenericDaoImpl {

	private Article convertArt(ResultSet rs, String typeArticle) {
		Article art = null;
		try {
			if (typeArticle.equals("pull")) {

				art = new Pull(rs.getInt("pull.id"), rs.getString("pull.libelle"), rs.getDouble("pull.prixUnitaire"), rs.getInt("pull.quantite"), rs.getString("pull.fournisseur"),
						rs.getString("pull.couleur"), rs.getString("pull.marque"), rs.getString("pull.genre"), rs.getString("pull.taille"), rs.getString("pull.type"));

			} else if (typeArticle.equals("tv")) {
				art = new Tv(rs.getInt("tv.id"), rs.getString("tv.libelle"), rs.getDouble("tv.prixunitaire"), rs.getInt("tv.quantite"), rs.getString("tv.fournisseur"),
						rs.getInt("tv.ratingconsomation"), rs.getInt("tv.resolution"));

			} else if (typeArticle.equals("chaussure")) {
				art = new Chaussure(rs.getInt("chaussure.id"), rs.getString("chaussure.libelle"), rs.getDouble("chaussure.prixunitaire"), rs.getInt("chaussure.quantite"), rs.getString("chaussure.fournisseur"),
						rs.getString("chaussure.couleur"), rs.getString("chaussure.marque"), rs.getString("chaussure.genre"), rs.getInt("chaussure.pointure"));

			} else if (typeArticle.equals("frigo")) {
				art = new Frigo(rs.getInt("frigo.id"), rs.getString("frigo.libelle"), rs.getDouble("frigo.prixunitaire"), rs.getInt("frigo.quantite"), rs.getString("frigo.fourniseur"),
						rs.getInt("frigo.ratingConsommation"), rs.getInt("frigo.capacite"));

			} else if (typeArticle.equals("fruit")) {
				art = new Fruit(rs.getInt("fruit.id"), rs.getString("fruit.libelle"), rs.getDouble("fruit.prixunitaire"), rs.getInt("fruit.quantite"), rs.getString("fruit.fournisseur"),
						rs.getString("fruit.saison"));

			} else if (typeArticle.equals("laitier")) {
				art = new Laitier(rs.getInt("laitier.id"), rs.getString("laitier.libelle"), rs.getDouble("laitier.prixunitaire"), rs.getInt("laitier.quantite"), rs.getString("laitier.fournisseur"),
						rs.getDate("laitier.dateExp"), rs.getDate("laitier.DateFab"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return art;
	}

	
	public LigneCommande find(int idArticle, int idCmd, String typeArticle) {
		query = "SELECT * FROM `lignecommande`,commande," + typeArticle + " WHERE idCmd=commande.id and idArticle="
				+ typeArticle + ".id and `idArticle`=? AND`idCmd`=? AND `typeArticle`=?";
		try {
			psmt = cnx.connect().prepareStatement(query);
			psmt.setInt(1, idArticle);
			psmt.setInt(2, idCmd);
			psmt.setString(3, typeArticle);
			rs = psmt.executeQuery();
			if (!rs.wasNull()) {
				rs.next();
				Article art = null;
				art = convertArt(rs, typeArticle);

				Commande cmd = new Commande(rs.getInt("commande.id"), rs.getDate("commande.datecmd"), rs.getString("commande.statutcmd"));

				LigneCommande l = new LigneCommande(art, cmd, rs.getInt(4));
				return l;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}

	
	public List<LigneCommande> findAll() {
		query = "SELECT * FROM lignecommande ";
		List<LigneCommande> lstlc = new ArrayList<>();
		try {
			smt = cnx.connect().createStatement();
			ResultSet resultSet = smt.executeQuery(query);
			while (resultSet.next()) {
				lstlc.add(find(resultSet.getInt("idarticle"), resultSet.getInt("idcmd"), resultSet.getString("typearticle")));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lstlc;
	}

	
	public List<LigneCommande> findByCmd(int idCmd) {
		query="select * from lignecommande where idcmd=?";
		List<LigneCommande> l=new ArrayList<>();

		try {
			psmt=cnx.connect().prepareStatement(query);
			psmt.setInt(1, idCmd);
			ResultSet r=psmt.executeQuery();
			while (r.next()) {
				l.add(find(r.getInt("idarticle"), r.getInt("idcmd"), r.getString("typearticle")));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	
	public int create(LigneCommande entite) {
		query="INSERT INTO `lignecommande`(`idArticle`, `idCmd`, `typeArticle`, `quantite`) VALUES (?,?,?,?)";
		try {
			psmt=cnx.connect().prepareStatement(query);
			psmt.setInt(1,entite.getArticle().getId());
			psmt.setInt(2,entite.getCommande().getId());
			psmt.setString(3, entite.getArticle().getClass().getSimpleName().toLowerCase() );
			psmt.setInt(4, entite.getQuantite());
			System.out.println("create done");
			return psmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	
	public int edit(LigneCommande entite) {
		query="UPDATE `lignecommande` SET `quantite`=? WHERE `idArticle`=? and `idCmd`=? and `typeArticle`=?;";
		try {
			psmt=cnx.connect().prepareStatement(query);
			psmt.setInt(1,entite.getQuantite());
			psmt.setInt(2,entite.getArticle().getId());
			psmt.setInt(3,entite.getCommande().getId());
			psmt.setString(4, entite.getArticle().getClass().getSimpleName().toLowerCase() );
			
			System.out.println("edit done");
			return psmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	
	public int delete(LigneCommande entite) {
		query="DELETE FROM `lignecommande` WHERE `idArticle`=? and `idCmd`=? and `typeArticle`=?;";
		try {
			psmt=cnx.connect().prepareStatement(query);
			psmt.setInt(1,entite.getArticle().getId());
			psmt.setInt(2,entite.getCommande().getId());
			psmt.setString(3, entite.getArticle().getClass().getSimpleName().toLowerCase() );
			
			System.out.println("delete done");
			return psmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
