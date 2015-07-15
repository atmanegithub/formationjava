package com.loncoto.WebPreJdbc.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.loncoto.WebPreJdbc.beans.*;

public class ClientDAO {

	public static final String FIND_ALL_SQL = "SELECT * FROM  `client`";
	private PreparedStatement findAllStatement;
	private Connection base;

	// on passe l'ojet connection comme parametre dans le constructeur

	public ClientDAO(Connection base) {

		this.base = base;

		try {
			findAllStatement = base.prepareStatement(FIND_ALL_SQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
