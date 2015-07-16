package com.loncoto.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.loncoto.beans.Article;



public class ArticleDAO {
	public static final String FIND_ALL_SQL = "SELECT * FROM  `article`";
	public static final String FIND_BY_ID_SQL = "SELECT * FROM  `article` where `id`=?";
	public static final String UPDATE_ONE_SQL = "update  `article` set`libelle`=?,`prix`=?,`poids`=? where `id`=? ";
	public static final String INSERT_ONE_SQL = "insert into  `article` (`libelle`,`prix`,`poids` ) values(?,?,?) ";
	public static final String DELETE_ONE_SQL = "delete from `article` where `id`=?";
	
	
	private PreparedStatement findAllStatement;
	 private PreparedStatement findAByIDStatement;
	 private PreparedStatement updateOneStatement;
	private PreparedStatement insertOneStatement;
	private PreparedStatement deleteOneStatement;
	//private PreparedStatement deleteOneStatement;
	
	private Connection base;

	// on passe l'ojet connection comme parametre dans le constructeur

	public ArticleDAO(Connection base) {

		this.base = base;

		try {
			findAllStatement = base.prepareStatement(FIND_ALL_SQL);
			findAByIDStatement = base.prepareStatement(FIND_BY_ID_SQL);
		updateOneStatement= base.prepareStatement(UPDATE_ONE_SQL);
		insertOneStatement= base.prepareStatement(INSERT_ONE_SQL);
		//deleteOneStatement= base.prepareStatement(DELETE_ONE_SQL);
		deleteOneStatement = base.prepareStatement(DELETE_ONE_SQL);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public int delete(int id){
		
		try {
			deleteOneStatement.clearParameters();
			deleteOneStatement.setInt(1, id);
			return deleteOneStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return 0;	
	}
	
	public int save(Article A){
		if (A.getId()>0) {
		// cest un update
			try {
				updateOneStatement.clearParameters();
				//attacher les param
			// respecter l'ordre de la requettte	
				updateOneStatement.setInt(4, A.getId());
				updateOneStatement.setString(1, A.getlibelle());
				updateOneStatement.setDouble(2, A.getPrix());
				updateOneStatement.setDouble(3, A.getPoids());
				return updateOneStatement.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		else {
		//c'est un insert	
			try {
				insertOneStatement.clearParameters();
				insertOneStatement.setInt(4, A.getId());
				insertOneStatement.setString(1,A.getlibelle());
				insertOneStatement.setDouble(2, A.getPrix());
				insertOneStatement.setDouble(3, A.getPoids());
				return insertOneStatement.executeUpdate();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		return 0;
		
	}
	public Article findByID(int id) {
		Article A = null;
		try {
			findAByIDStatement.clearParameters();
			// je remplace le ? par l'id en parametre 
			findAByIDStatement.setInt(1, id);
			ResultSet rs = findAByIDStatement.executeQuery();
			if (rs.next()) {
				A = new Article(rs.getInt("id"), rs.getString("libelle"),
						rs.getDouble("prix"), rs.getDouble("poids"));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return A;

	}

	// List est une interface
	public List<Article> findAll() {

		// array list est une classe qui implemente l'interf lis
		ArrayList<Article> data = new ArrayList<Article>();
		try {
			// efface les parametres precedant
			findAllStatement.clearParameters();
			ResultSet rs = findAllStatement.executeQuery();
			while (rs.next()) {
				data.add(new Article(rs.getInt("id"), rs.getString("libelle"), rs.getDouble("prix"), rs.getDouble("poids")));
			}
			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

}
