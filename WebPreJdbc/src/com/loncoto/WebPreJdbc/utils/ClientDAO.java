package com.loncoto.WebPreJdbc.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.loncoto.WebPreJdbc.beans.*;

public class ClientDAO {

	public static final String FIND_ALL_SQL = "SELECT * FROM  `client`";
	public static final String FIND_BY_ID_SQL = "SELECT * FROM  `client` where `id`=?";
	public static final String UPDATE_ONE_SQL = "update  `client` set`nom`=?,`email`=?,`solde`=? where `id`=? ";
	public static final String INSERT_ONE_SQL = "insert into  `client` (`nom`,`email`,`solde` ) values(?,?,?) ";
	public static final String DELETE_ONE_SQL = "delete from `client` where `id`=?";
	
	
	private PreparedStatement findAllStatement;
	private PreparedStatement findAByIDStatement;
	private PreparedStatement updateOneStatement;
	private PreparedStatement insertOneStatement;
	//private PreparedStatement deleteOneStatement;
	private PreparedStatement deleteOneStatement;
	
	private Connection base;

	// on passe l'ojet connection comme parametre dans le constructeur

	public ClientDAO(Connection base) {

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
	
	public int save(Client c){
		if (c.getId()>0) {
		// cest un update
			try {
				updateOneStatement.clearParameters();
				//attacher les param
			// respecter l'ordre de la requettte	
				updateOneStatement.setInt(4, c.getId());
				updateOneStatement.setString(1, c.getNom());
				updateOneStatement.setString(2, c.getEmail());
				updateOneStatement.setDouble(3, c.getSolde());
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
				insertOneStatement.setInt(4, c.getId());
				insertOneStatement.setString(1, c.getNom());
				insertOneStatement.setString(2, c.getEmail());
				insertOneStatement.setDouble(3, c.getSolde());
				return insertOneStatement.executeUpdate();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		return 0;
		
	}
	public Client findByID(int id) {
		Client c = null;
		try {
			findAByIDStatement.clearParameters();
			// je remplace le ? par l'id en parametre 
			findAByIDStatement.setInt(1, id);
			ResultSet rs = findAByIDStatement.executeQuery();
			if (rs.next()) {
				c = new Client(rs.getInt("id"), rs.getString("nom"),
						rs.getString("email"), rs.getDouble("solde"));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;

	}

	// List est une interface
	public List<Client> findAll() {

		// array list est une classe qui implemente l'interf lis
		ArrayList<Client> data = new ArrayList<Client>();
		try {
			// efface les parametres precedant
			findAllStatement.clearParameters();
			ResultSet rs = findAllStatement.executeQuery();
			while (rs.next()) {
				data.add(new Client(rs.getInt("id"), rs.getString("nom"), rs
						.getString("email"), rs.getDouble("solde")));
			}
			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

}
