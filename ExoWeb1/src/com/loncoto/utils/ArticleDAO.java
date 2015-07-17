package com.loncoto.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.loncoto.beans.Article;



public class ArticleDAO {
	
		public static final String ORDER_BY_DEFAULT = "0";
		public static final String ORDER_BY_PRIX= "1";
		public static final String ORDER_BY_POIDS = "2";
		public static final String FIND_ALL_SQL = "select * from `article`";
		public static final String FIND_ALL_ORDERED_SQL = "select * from `article` ORDER BY";
		
		private Connection base;
		
		private PreparedStatement findAllSatement;
		private PreparedStatement findAllOrderedSatement;
		
		public ArticleDAO(Connection base) {
			this.base = base;
			
			try {
				findAllSatement = base.prepareStatement(FIND_ALL_SQL);
				findAllOrderedSatement = base.prepareStatement(FIND_ALL_ORDERED_SQL);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// on renvoie un objet Article qui correspond a une ligne du resultSet
		private Article fetchRow(ResultSet rs) {
			try {
				return new Article(rs.getInt("id"), rs.getString("libelle"), rs.getDouble("prix"), rs.getDouble("poids"));
			} catch (SQLException e) {e.printStackTrace();}
			return null;
		}
		
		public List<Article> findAll(int orderType) {
			ArrayList<Article> articles = new ArrayList<Article>();
			
			try {
				findAllSatement.clearParameters();
				ResultSet rs = findAllSatement.executeQuery();
				while (rs.next()) {
					articles.add(fetchRow(rs));
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return articles;
		}
	}


