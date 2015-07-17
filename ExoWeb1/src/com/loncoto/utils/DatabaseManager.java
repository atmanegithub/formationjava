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
    public void contextDestroyed(ServletContextEvent arg0)  { 
        try {
  			base.close();
  		} catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
    	 System.out.println("demarrage de databaseManager");
         String driverclass = arg0.getServletContext().getInitParameter("driverclass");
         String databaseurl = arg0.getServletContext().getInitParameter("databaseurl");
         String login = arg0.getServletContext().getInitParameter("login");
         String password = arg0.getServletContext().getInitParameter("password");
         
         
         try {
        	 // chargement du driver mysql
             Class.forName(driverclass);
             base = DriverManager.getConnection(databaseurl, login, password);
             System.out.println("connecté à la base");
             ArticleDAO articleDAO = new ArticleDAO(base);
             arg0.getServletContext().setAttribute("articleDAO", articleDAO);
             
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
