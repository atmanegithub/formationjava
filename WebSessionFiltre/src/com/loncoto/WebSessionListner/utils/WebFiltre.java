package com.loncoto.WebSessionListner.utils;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class WebFiltre
 */
public class WebFiltre implements Filter {
private String name;
	/**
	 * Default constructor.
	 */
	public WebFiltre() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		System.out.println(name+"appel de dofilter avant chain");
		System.out.println(name+"request ->" + request.getLocalAddr());
		chain.doFilter(request, response);
		System.out.println("appel de dofilter apres  chain");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

		System.out.println("init du filtre ");
		name =fConfig.getFilterName();
	System.out.println("init web filtre  Web filtre :"+ name);
	}

}
