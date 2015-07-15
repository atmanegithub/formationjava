package com.loncoto.WebPreJdbc.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loncoto.WebPreJdbc.beans.Client;
import com.loncoto.WebPreJdbc.utils.ClientDAO;

/**
 * Servlet implementation class ClientServlet
 */
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// recup du dao
	private ClientDAO clientDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClientServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {

		// TODO Auto-generated method stub
		// appeler le contructeur parent
		super.init(config);
		clientDAO = (ClientDAO) getServletContext().getAttribute("clientDAO");

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		List<Client> clients = clientDAO.findAll();
		request.setAttribute("clients", clients);
		getServletContext().getRequestDispatcher("/liste.jsp").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	// recup action
		
		String action =  request.getParameter("action");
		switch (action) {
		case "editer":
			
			int id = Integer.parseInt(request.getParameter("id"));
			Client c =clientDAO.findByID(id);
			request.setAttribute("client", c);
			getServletContext().getRequestDispatcher("/edit.jsp").forward(request, response);
			
			break;

		}
	
	}

}
