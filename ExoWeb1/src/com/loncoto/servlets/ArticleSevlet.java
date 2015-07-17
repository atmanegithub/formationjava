package com.loncoto.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import com.loncoto.beans.Article;
import com.loncoto.utils.ArticleDAO;

/**
 * Servlet implementation class ArticleSevlet
 */
public class ArticleSevlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
    
	private ArticleDAO articleDAO;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		articleDAO = (ArticleDAO)getServletContext().getAttribute("articleDAO");
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("articles", articleDAO.findAll(0));
		getServletContext().getRequestDispatcher("/liste.jsp")
							.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
