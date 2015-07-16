package com.loncoto.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class DatabaseManager
 *
 */
public class DatabaseManager implements ServletContextListener {

	// on le declare à ca niveau pour que la genericite

	private Connection base;

	/**
	 * Default constructor.
	 */
	public DatabaseManager() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

		System.out.println("demarrage de database manager");
		// recup parametres
		String driverclass = arg0.getServletContext().getInitParameter(
				"driverclass");
		String databaseurl = arg0.getServletContext().getInitParameter(
				"databaseurl");
		String login = arg0.getServletContext().getInitParameter("login");
		String password = arg0.getServletContext().getInitParameter("password");

		try {

			// chargement du drivers
			Class.forName(driverclass);
			base = DriverManager.getConnection(databaseurl, login, password);
			System.out.println("coonecté a la base");
			// Creation du dao
			ArticleDAO articleDAO = new ArticleDAO(base);
			// mettre la cient dao a dispo des servlet
			arg0.getServletContext().setAttribute("clientDAO", articleDAO);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
