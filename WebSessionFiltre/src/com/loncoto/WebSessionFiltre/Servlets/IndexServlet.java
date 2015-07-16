package com.loncoto.WebSessionFiltre.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class IndexServlet
 */
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int compteur = 0;
		if (session.getAttribute("compteur") == null) {
			System.out
					.println("creation du compteur dans la session de la servlet");
			compteur = 1;
		} else {
			compteur = (int) session.getAttribute("compteur");
			compteur++;
		}
		session.setAttribute("compteur", compteur);
		getServletContext().getRequestDispatcher("/index.jsp").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// reinitialiser lla session
		String action = request.getParameter("action");
		switch (action) {
		case "reinitialiser":
			// invalide la session
			request.getSession().invalidate();
			response.sendRedirect("IndexServlet");

			break;

		default:
			break;
		}

	}

}
